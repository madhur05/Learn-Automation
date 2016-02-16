package com.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

@SuppressWarnings("unused")
public class ReadExcel {

	public static void main(String[] args) throws Exception {
		
		//to specify excel file path
		File src=new File("C:\\Users\\user\\Desktop\\filesforseleniumtest\\address.xlsx");
		FileInputStream fis= new FileInputStream(src);
		// will load workbook
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh1=wb.getSheetAt(0);
		//XSSFSheet sh1=wb.getSheet("Sheet1");
				
		String data0=sh1.getRow(0).getCell(0).getStringCellValue();
		//System.out.println(data0);
		String data1=sh1.getRow(0).getCell(1).getStringCellValue();
		System.out.println(data0 + data1);
		wb.close();
		

	}

}
