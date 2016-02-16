package com.excel;

import java.io.File;
import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcel {

	public static void main(String[] args) throws Exception {
		
		//to specify excel file path
		File src=new File("C:\\Users\\user\\Desktop\\filesforseleniumtest\\address.xlsx");
		FileInputStream fis= new FileInputStream(src);
		// will load workbook
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh1=wb.getSheetAt(0);
		//XSSFSheet sh1=wb.getSheet("Sheet1");
		
		sh1.getRow(0).createCell(2).setCellValue("hello");
		sh1.getRow(1).createCell(2).setCellValue("hello");
		sh1.getRow(2).createCell(2).setCellValue("hello");
		FileOutputStream fos=new FileOutputStream(src);
		
		wb.write(fos);
		wb.close();

	}

}
