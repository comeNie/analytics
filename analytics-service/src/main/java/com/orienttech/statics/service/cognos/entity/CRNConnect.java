package com.orienttech.statics.service.cognos.entity;

import java.net.MalformedURLException;

import javax.xml.rpc.ServiceException;

import org.apache.axis.client.Stub;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cognos.developer.schemas.bibus._3.BiBusHeader;
import com.cognos.developer.schemas.bibus._3.ContentManagerService_PortType;
import com.cognos.developer.schemas.bibus._3.ContentManagerService_ServiceLocator;
import com.cognos.developer.schemas.bibus._3.ReportService_PortType;
import com.cognos.developer.schemas.bibus._3.ReportService_ServiceLocator;
import com.cognos.developer.schemas.bibus._3.SystemService_PortType;
import com.cognos.developer.schemas.bibus._3.SystemService_ServiceLocator;
import com.orienttech.statics.service.cognos.common.BIBusHeaderHelper;

/** 
 Licensed Materials - Property of IBM

 IBM Cognos Products: DOCS

 (C) Copyright IBM Corp. 2005, 2010

 US Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP Schedule Contract with
 IBM Corp.
 */
/**
 * CRNConnect.java
 *
 * Copyright (C) 2008 Cognos ULC, an IBM Company. All rights reserved. Cognos
 * (R) is a trademark of Cognos ULC, (formerly Cognos Incorporated).
 *
 * Description: This code sample demonstrates how to establish a connection to
 * the IBM Cognos services
 */
public class CRNConnect {
	private Logger logger = LoggerFactory.getLogger(CRNConnect.class);
	// Set the location of the sample reports.
	// private String curDir = System.getProperty("user.dir");
	private String CRN_HOME = "D:/Program Files (x86)/ibm/cognos/c10"; // curDir.substring(0,curDir.lastIndexOf("sdk")-1);
	private String REPORT_PATH = CRN_HOME + "/webcontent/samples";

	// Create a variable that contains the default URL for Content Manager.
	public static String CM_URL = "http://localhost:9300/p2pd/servlet/dispatch";

	// Create the objects that provide the connections to the services.
	private ContentManagerService_ServiceLocator cmServiceLocator = null;
	private ReportService_ServiceLocator reportServiceLocator = null;
	private SystemService_ServiceLocator systemServiceLocator = null;

	// There is an interface class for each service named
	// <servicename>_Port. The implementation class for each interface
	// is named <servicename>Stub. The stub class implements the methods
	// in the interface, and can be used to access the functionality provided
	// by the service. However, as it is a common practice, this sample
	// programs to the interfaces, instantiating instances of the
	// <servicename>_Port classes.
	private ReportService_PortType repService = null;
	private ContentManagerService_PortType cmService = null;
	private SystemService_PortType sysService = null;

	/**
	 * Use this method to connect to the server, bypassing any prompts.
	 * 
	 * @param CMURL
	 *            The URL for the server
	 * @return A connection to the server
	 */
	public void connectToCognosServer(String CMURL) {
		CM_URL = CMURL;
		// Create the service locators
		cmServiceLocator = new ContentManagerService_ServiceLocator();
		reportServiceLocator = new ReportService_ServiceLocator();
		systemServiceLocator = new SystemService_ServiceLocator();
		try {
			java.net.URL serverURL = new java.net.URL(CM_URL);
			logger.info(serverURL.toString());

			cmService = cmServiceLocator.getcontentManagerService(serverURL);
			repService = reportServiceLocator.getreportService(serverURL);
			sysService = systemServiceLocator.getsystemService(serverURL);
		} // ... catch expected exceptions after this point
		catch (MalformedURLException e) {
			logger.error("Malformed URL:\n {}", e.getMessage());
		} catch (ServiceException e) {
			logger.error("Service Exception:\n {}" + e.getMessage());
		}
	}

	public String getDefaultSavePath() {
		return REPORT_PATH;
	}

	public void setDefaultSavePath(String newReportPath) {
		REPORT_PATH = newReportPath;
	}

	// handle service requests that do not specify new conversation for
	// backwards compatibility
	public ReportService_PortType getReportService() {
		return getReportService(false, "");

	}

	public ReportService_PortType getReportService(boolean isNewConversation,
			String RSGroup) {

		BiBusHeader bibus = null;
		bibus = BIBusHeaderHelper.getHeaderObject(((Stub) repService)
				.getResponseHeader(
						"http://developer.cognos.com/schemas/bibus/3/",
						"biBusHeader"), isNewConversation, RSGroup);

		if (bibus == null) {
			BiBusHeader CMbibus = null;
			CMbibus = BIBusHeaderHelper.getHeaderObject(((Stub) cmService)
					.getResponseHeader(
							"http://developer.cognos.com/schemas/bibus/3/",
							"biBusHeader"), true, RSGroup);

			((Stub) repService).clearHeaders();
			((Stub) repService).setHeader(
					"http://developer.cognos.com/schemas/bibus/3/",
					"biBusHeader", CMbibus);
		} else {
			((Stub) repService).clearHeaders();
			((Stub) repService).setHeader(
					"http://developer.cognos.com/schemas/bibus/3/",
					"biBusHeader", bibus);
		}

		return repService;
	}

	// handle service requests that do not specify new conversation for
	// backwards compatibility
	public ContentManagerService_PortType getCMService() {

		return getCMService(false, "");

	}

	public ContentManagerService_PortType getCMService(
			boolean isNewConversation, String RSGroup) {
		BiBusHeader bibus = null;
		bibus = BIBusHeaderHelper.getHeaderObject(((Stub) cmService)
				.getResponseHeader(
						"http://developer.cognos.com/schemas/bibus/3/",
						"biBusHeader"), isNewConversation, RSGroup);

		if (!(bibus == null)) {
			((Stub) cmService).clearHeaders();
			((Stub) cmService).setHeader(
					"http://developer.cognos.com/schemas/bibus/3/",
					"biBusHeader", bibus);

		}
		return cmService;
	}
	
	//handle service requests that do not specify new conversation for backwards compatibility
    public SystemService_PortType getSystemService() {
        
        return getSystemService(false, "");
        
    }
    
    // sn_dg_sdk_mng_svc_hdrs_end_1

	public SystemService_PortType getSystemService(boolean isNewConversation, String RSGroup)
	{
		BiBusHeader bibus = null;
		bibus =
			BIBusHeaderHelper.getHeaderObject(((Stub)sysService).getResponseHeader("http://developer.cognos.com/schemas/bibus/3/", "biBusHeader"), isNewConversation, RSGroup);

		if (bibus == null) 
		{
			BiBusHeader CMbibus = null;
			CMbibus =
				BIBusHeaderHelper.getHeaderObject(((Stub)cmService).getResponseHeader("http://developer.cognos.com/schemas/bibus/3/", "biBusHeader"), true, RSGroup);

            ((Stub)sysService).clearHeaders();
			((Stub)sysService).setHeader("http://developer.cognos.com/schemas/bibus/3/", "biBusHeader", CMbibus);
		}
        else
        {
            ((Stub)sysService).clearHeaders();
            ((Stub)sysService).setHeader("http://developer.cognos.com/schemas/bibus/3/", "biBusHeader", bibus); 

        }
		return sysService;
	}
}
