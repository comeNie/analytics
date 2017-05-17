package com.orienttech.statics.service.cognos.entity;


/** 

Licensed Materials - Property of IBM

IBM Cognos Products: DOCS

(C) Copyright IBM Corp. 2005, 2008

US Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP Schedule Contract with
IBM Corp.
*/
/**
 * DeleteReport.java
 *
 * Copyright (C) 2008 Cognos ULC, an IBM Company. All rights reserved.
 * Cognos (R) is a trademark of Cognos ULC, (formerly Cognos Incorporated).
 *
 * Description: This code sample demonstrates how to delete reports using the 
 *	           following methods:
 *	           - query 
 *	             Use this method to request objects from Content Manager.
 *	           - delete
 *	             Use this method to delete objects from the content store.
 */



import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import org.apache.axis.AxisFault;
import org.apache.axis.client.Stub;
import org.apache.axis.message.SOAPHeaderElement;

import com.cognos.developer.schemas.bibus._3.BaseClass;
import com.cognos.developer.schemas.bibus._3.BiBusHeader;
import com.cognos.developer.schemas.bibus._3.CAM;
import com.cognos.developer.schemas.bibus._3.ContentManagerService_PortType;
import com.cognos.developer.schemas.bibus._3.ContentManagerService_ServiceLocator;
import com.cognos.developer.schemas.bibus._3.DeleteOptions;
import com.cognos.developer.schemas.bibus._3.FormFieldVar;
import com.cognos.developer.schemas.bibus._3.FormatEnum;
import com.cognos.developer.schemas.bibus._3.HdrSession;
import com.cognos.developer.schemas.bibus._3.OrderEnum;
import com.cognos.developer.schemas.bibus._3.PropEnum;
import com.cognos.developer.schemas.bibus._3.QueryOptions;
import com.cognos.developer.schemas.bibus._3.SearchPathMultipleObject;
import com.cognos.developer.schemas.bibus._3.Sort;
import com.cognos.developer.schemas.bibus._3.StringProp;
import com.cognos.developer.schemas.bibus._3.TokenProp;
import com.orienttech.statics.service.cognos.common.ServerInfoHelper;
import com.orienttech.statics.service.cognos.common.ServerInfoHelper.ServerInfo;


public class DeleteReport
{
	public  BaseClass getReportObject(String tempreportsearchpath)
	{
		BaseClass baseclass = null;
		ServerInfo sInfo=ServerInfoHelper.getServerInfo();
		
		try
		{
			// Create the connection to Content Manager Service.
			 URL endPointUrl =	new URL(sInfo.getServerUrl());
			ContentManagerService_ServiceLocator service =
				new ContentManagerService_ServiceLocator();
			ContentManagerService_PortType cms =
				service.getcontentManagerService(endPointUrl);

			// Search properties: we need the defaultName and the searchPath.
			PropEnum[] properties =
				{ PropEnum.defaultName, PropEnum.searchPath };

			// Sort options: ascending sort on the defaultName property.
			//
			// The cmQuery.pl sample doesn't do this, it returns the default unsorted response.
			Sort[] sortBy = { new Sort()};
			sortBy[0].setOrder(OrderEnum.ascending);
			sortBy[0].setPropName(PropEnum.defaultName);

			// Query options; use the defaults.
			QueryOptions options = new QueryOptions();

			// Add the authentication information, if any.
			//
			// Another option would be to use the logon() and logonAs() methods...
			
			CAM cam = new CAM();
			cam.setAction("logonAs");

			HdrSession header = new HdrSession();
			
			if (sInfo.getUserNamespace() != null)
			{
				FormFieldVar[] vars = new FormFieldVar[3];

				vars[0] = new FormFieldVar();
				vars[0].setName("CAMNamespace");
				vars[0].setValue(sInfo.getUserNamespace());
				vars[0].setFormat(FormatEnum.not_encrypted);

				vars[1] = new FormFieldVar();
				vars[1].setName("CAMUsername");
				vars[1].setValue(sInfo.getUserName());
				vars[1].setFormat(FormatEnum.not_encrypted);

				vars[2] = new FormFieldVar();
				vars[2].setName("CAMPassword");
				vars[2].setValue(sInfo.getUserPassword());
				vars[2].setFormat(FormatEnum.not_encrypted);

				header.setFormFieldVars(vars);
			}
			else
			{
				cam.setAction("logon");
			}
             
			BiBusHeader bibus = new BiBusHeader();
			bibus.setCAM(cam);
			bibus.setHdrSession(header);

			((Stub)cms).setHeader("http://developer.cognos.com/schemas/bibus/3/", "biBusHeader", bibus);
            
			// Make the query.
			try
			{
				BaseClass[] results =
					cms.query(
						new SearchPathMultipleObject(tempreportsearchpath),
						properties,
						sortBy,
						options);

				// Display the results.
				System.out.println("Results:");
				for (int i = 0; i < results.length; i++)
				{
					TokenProp theDefaultName = results[i].getDefaultName();
					StringProp theSearchPath = results[i].getSearchPath();

					System.out.print("######??");
					System.out.print(theDefaultName.getValue());
					System.out.print("\t");
					System.out.println(theSearchPath.getValue());
					
					baseclass = results[i] ;
					
				}
			}

			catch (AxisFault ex)
			{
				// Fault details can be found via ex.getFaultDetails(),
				// which returns an Element array.

				System.out.println("SOAP Fault:");
				System.out.println(ex.toString());
			}

			catch (RemoteException ex)
			{
				SOAPHeaderElement theException =
					 ((Stub)cms).getHeader(
						"",
						"biBusHeader");

				// You can now use theException to find out more information
				// about the problem.
				System.out.println(theException.toString());

				System.out.println("The request threw an RMI exception:");
				System.out.println(ex.getMessage());
				System.out.println("Stack trace:");
				ex.printStackTrace();
			}
		}

		catch (MalformedURLException ex)
		{
			System.out.println("Malformed URL exception:");
			System.out.println(ex.getMessage());
			System.out.println("Stack trace:");
			ex.printStackTrace();
		}

		catch (ServiceException ex)
		{
			System.out.println("Remote service exception:");
			System.out.println(ex.getMessage());
			System.out.println("Stack trace:");
			ex.printStackTrace();
		}
		
		
		 
		
		return baseclass;
	}
	
	
	
	
	public String deleteReport(CRNConnect connection ,BaseClass reportToBeDeleted)
	{
		
		
		

		
		
		String output = new String();
		if (connection != null)
		{
		   //System.out.println(connection.toString());
			// Set the options for the delete method.                       
			DeleteOptions delOptions = new DeleteOptions();

			// Set the force option to true. When the force option is true,
			// a selected object will be deleted if the current user has either 
			// write or setPolicy permission for the following: 
			//   - the selected object
			//   - the parent of the selected object
			//   - every descendant of the selected object
			
			// sn_dg_prm_smpl_deletereport_start_0
			delOptions.setForce(true);
			delOptions.setFaultIfObjectReferenced(false);
			delOptions.setRecursive(true);

			 
			
			try
			{
				if (reportToBeDeleted != null)
				{
					System.out.println("Deleting report: " + reportToBeDeleted);

					BaseClass reportsForDeletion[] =
						new BaseClass[] { reportToBeDeleted};
					int delReturnCode =
						connection.getCMService().delete(reportsForDeletion, delOptions);
					// sn_dg_prm_smpl_deletereport_end_0
					if (delReturnCode > 0)
					{
						output = "The report was deleted successfully.\n";
					}
					else
					{
						output =
							"An error occurred while deleting the report.\n";
					}
				}
			}
			//catch unhandled exceptions
			catch (java.rmi.RemoteException remoteEx)
			{
				remoteEx.printStackTrace();
			}

		}

		return output;
	}
	
	
	//todeleteReport(serverurl,uid,pa,na,tempreportsearchpath) ;
	
	public void todeleteReport(CRNConnect connection,String tempreportsearchpath)
	{
		BaseClass bcreport = null;
		bcreport = getReportObject(tempreportsearchpath);
		deleteReport(connection , bcreport ) ;
		
		
	}
	

}
