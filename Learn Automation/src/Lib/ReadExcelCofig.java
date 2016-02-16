package Lib;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelCofig {
	
	XSSFWorkbook wb;
	XSSFSheet sh1;
	public ReadExcelCofig(String excelpath)
	{
		try {
			File src=new File(excelpath);
			FileInputStream fis= new FileInputStream(src);
			// will load workbook
			 wb = new XSSFWorkbook(fis);
			 
			
			//XSSFSheet sh1=wb.getSheet("Sheet1");
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getData(int sheetnumber,int row, int column)
	{
		sh1=wb.getSheetAt(sheetnumber);
		String data=sh1.getRow(row).getCell(column).getStringCellValue();
		return data;
	}
	
	
	public int getRowcount(int sheetIndex){
		int row=wb.getSheetAt(sheetIndex).getLastRowNum();
		//if total number of rows are 10 ,the above statement will return 9 as it starts with 0
		//to get the actual number of rows we have to add 1
		row=row+1;
		return row;
	}
}
