package com.orienttech.statics.commons.utils;

import java.text.DecimalFormat;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;






public class POIUtil {
	static String getFormat(String str){
		double j=Double.parseDouble(str);
		double i=j*100;
		String strd;
		DecimalFormat df=new DecimalFormat("0.00"); 
		strd=df.format(i) ;
		return strd+"%";		
	}
	static String getFormat(double dou){
		double j = dou;
		double i = j*100;
		String strd;
		DecimalFormat df=new DecimalFormat("0.00"); 
		strd=df.format(i) ;
		return strd+"%";		
	}
	public static void insertRowWithStyle(XSSFSheet sheet,int r){
		sheet.shiftRows(r, sheet.getLastRowNum(), 1, true, false);
		XSSFRow source=sheet.getRow(r+1);
		XSSFRow target=sheet.createRow(r);
		target.setHeight(source.getHeight());
		Iterator<Cell> iCells=source.cellIterator();

		while (iCells.hasNext()) {
			XSSFCell cells = (XSSFCell) iCells.next();
//			cells.setEncoding(XSSFWorkbook.ENCODING_UTF_16);
			short cellnum=(short) cells.getColumnIndex();//getCell();
			XSSFCell cellt=target.createCell(cellnum);
//			cellt.setEncoding(XSSFWorkbook.ENCODING_UTF_16);
			cellt.setCellStyle(cells.getCellStyle());
			cellt.setCellType(cells.getCellType());
		}
		
	}
	static void setEncoding(XSSFSheet sheet,int r){
		XSSFRow source=sheet.getRow(r);
		Iterator<Cell> iCells=source.cellIterator();
		while(iCells.hasNext()){
			XSSFCell cell=(XSSFCell) iCells.next();
//			cell.setEncoding(XSSFWorkbook.ENCODING_UTF_16);
		}
	}
	
}
