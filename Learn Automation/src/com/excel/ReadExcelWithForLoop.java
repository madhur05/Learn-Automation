package com.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelWithForLoop {

	public static void main(String[] args) throws Exception {
		
		//to specify excel file path
		File src=new File("C:\\Users\\user\\Desktop\\filesforseleniumtest\\address.xlsx");
		FileInputStream fis= new FileInputStream(src);
		// will load workbook
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh1=wb.getSheetAt(0);
		//XSSFSheet sh1=wb.getSheet("Sheet1");
				
		int rowcount=sh1.getLastRowNum();
		System.out.println("Total number of rows are:"+rowcount);
		
		for (int i=0;i<rowcount+1;i++)
		{
			String data0=sh1.getRow(i).getCell(0).getStringCellValue();
			System.out.println("Data from excel is:"+ data0);
		}
		
		wb.close();
		
		
		
		

	}

}
