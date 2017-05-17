package com.orienttech.statics.service.cognos.entity;

import com.cognos.developer.schemas.bibus._3.BaseClass;
import com.cognos.developer.schemas.bibus._3.PropEnum;
import com.cognos.developer.schemas.bibus._3.QueryOptions;
import com.cognos.developer.schemas.bibus._3.SearchPathMultipleObject;
import com.cognos.developer.schemas.bibus._3.SearchPathSingleObject;
import com.cognos.developer.schemas.bibus._3.Sort;
import com.cognos.developer.schemas.bibus._3.XmlEncodedXML;

public class Logon {
	private static String userId = "";

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
	public String quickLogon(CRNConnect connection, String namespace,
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

	public static boolean loggedIn(CRNConnect connection) {
		return (userId != "" || userId == null || doTestForAnonymous(connection));
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
}
