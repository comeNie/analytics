package com.orienttech.statics.commons.utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class T14001031ExcelAction {
	
	 private XSSFWorkbook wb;

	 public T14001031ExcelAction(String templateName)
	    {
	        try
	        {
	        	File file = new File(templateName);
	        	FileInputStream fis = new FileInputStream(file);
	            wb = new XSSFWorkbook(fis);
	        }
	        catch(Exception e)
	        {
	            e.printStackTrace();
	        }
	    }
	 public ByteArrayOutputStream process(Map map)
		        throws Exception
		    {
		        XSSFSheet sheet = wb.getSheetAt(0);
		        
		        List list = (List)map.get("list");
		        if(list!=null&&list.size()>0){
		        	for(int i = 0; i < list.size(); i++)
		            {
		        		POIUtil.insertRowWithStyle(sheet, i + 2);
		        		XSSFRow row = sheet.getRow(i);
		        		Object obj[] = (Object[])list.get(i);
		        		row.getCell((short)0).setCellValue(obj[2] != null ? obj[2].toString().trim() : "-");
		            }
		        }
		        ByteArrayOutputStream out = new ByteArrayOutputStream();
		        try
		        {
		            wb.write(out);
		        }
		        catch(IOException _ex) { }
		        return out;
		    }
	 public static String Round2(double f, int n)
	    {
	        NumberFormat nbf = NumberFormat.getInstance();
	        nbf.setMinimumFractionDigits(n);
	        nbf.setMaximumFractionDigits(n);
	        return nbf.format(f);
	    }

	 
}