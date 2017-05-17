package com.orienttech.statics.service.cognos.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cognos.developer.schemas.bibus._3.Account;
import com.cognos.developer.schemas.bibus._3.BaseClass;
import com.cognos.developer.schemas.bibus._3.PropEnum;
import com.cognos.developer.schemas.bibus._3.QueryOptions;
import com.cognos.developer.schemas.bibus._3.SearchPathMultipleObject;
import com.cognos.developer.schemas.bibus._3.SearchPathSingleObject;
import com.cognos.developer.schemas.bibus._3.Sort;
import com.cognos.developer.schemas.bibus._3.XmlEncodedXML;
import com.orienttech.statics.service.cognos.common.ServerInfoHelper.ServerInfo;
import com.orienttech.statics.service.cognos.entity.CRNConnect;
import com.orienttech.statics.service.cognos.entity.Logon;
import com.orienttech.statics.service.cognos.exception.CognosBaseException;

public class LogonSessionMng {
	private static Logger logger=LoggerFactory.getLogger(Logon.class);
	private static CRNConnect connect = null;
	private static String userId = "";
	static {
		connect = new CRNConnect();
	}

	public static CRNConnect initLoginInfo() {
		ServerInfo serverInfo = ServerInfoHelper.getServerInfo();
		connect.connectToCognosServer(serverInfo.getServerUrl());
		try {
			quickLogon(connect, serverInfo.getUserNamespace(),
					serverInfo.getUserName(), serverInfo.getUserPassword());
			return connect;
		} catch (Exception e) {
			throw new CognosBaseException("quickLogin Fail !!");
		}
	}

	/**
	 * Use this Java method to log on, bypassing any prompts.
	 *
	 * @param connection
	 *            Connection to Server
	 * 
	 * @param namespace
	 *            Specifies the namespace where the user ID is stored.
	 * @param uid
	 *            Specifies the ID of the user.
	 * @param pwd
	 *            Specifies the password of the user.
	 * @return Returns a string containing status information.
	 */
	public static String quickLogon(CRNConnect connection, String namespace,
			String uid, String pwd) throws Exception {
		StringBuffer credentialXML = new StringBuffer();

		credentialXML.append("<credential>");

		credentialXML.append("<namespace>");
		credentialXML.append(namespace);
		credentialXML.append("</namespace>");

		credentialXML.append("<username>");
		credentialXML.append(uid);
		credentialXML.append("</username>");

		credentialXML.append("<password>");
		credentialXML.append(pwd);
		credentialXML.append("</password>");

		credentialXML.append("</credential>");

		String encodedCredentials = credentialXML.toString();
		connection.getCMService().logon(new XmlEncodedXML(encodedCredentials),
				new SearchPathSingleObject[] {});

		return ("Logon successful as " + uid);
	}

	public static boolean checkLogin(CRNConnect connect) {
		return (userId != "" || userId == null || doTestForAnonymous(connect));
	}

	/**
	 * Use this Java method to find out if Anonymous access is enabled
	 *
	 * @param connection
	 *            Connection to Server
	 * 
	 * @return Returns a boolean indicating whether or not Anonymous access is
	 *         enabled (true) or disabled (false).
	 */
	public static boolean doTestForAnonymous(CRNConnect connection) {

		boolean doTestForAnonymous = false;
		try {
			BaseClass bc[] = connection.getCMService().query(
					new SearchPathMultipleObject("/content"),
					new PropEnum[] {}, new Sort[] {}, new QueryOptions());
			if (bc != null) {
				doTestForAnonymous = true;
			} else {
				doTestForAnonymous = false;
			}
		} catch (java.rmi.RemoteException remoteEx) {
			// Ignore this, it means that Anonymous access is denied...
		}

		return doTestForAnonymous;
	}

	// Get account information for the current user.
	public static Account getLogonAccount(CRNConnect connection) {
		// sn_dg_sdk_task_querycontent_start_0
		PropEnum props[] = new PropEnum[] { PropEnum.searchPath,
				PropEnum.defaultName, PropEnum.policies, PropEnum.userName,
				PropEnum.notificationEMail };
		Account myAccount = null;
		// sn_dg_sdk_task_querycontent_end_0

		if (connection.getCMService() == null) {
			logger.info("Invalid parameter passed to function logon.");
			return myAccount;
		}

		try {
			// sn_dg_sdk_task_querycontent_start_1
			BaseClass bc[] = connection.getCMService().query(
					new SearchPathMultipleObject("~"), props, new Sort[] {},
					new QueryOptions());

			if ((bc != null) && (bc.length > 0)) {
				for (int i = 0; i < bc.length; i++) {
					myAccount = (Account) bc[i];
				}
			}
			// sn_dg_sdk_task_querycontent_end_1
		} catch (java.rmi.RemoteException remoteEx) {
			// An exception here likely indicates the client is not currently
			// logged in, so the query fails.
			logger.info("Caught RemoteException:\n {}",remoteEx.getMessage());
		}

		return myAccount;
	}
}
