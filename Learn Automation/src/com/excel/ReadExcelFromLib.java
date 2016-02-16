package com.excel;

import Lib.ReadExcelCofig;

public class ReadExcelFromLib {
	
	
		public static void main(String[] args) {
		
			ReadExcelCofig excel=new ReadExcelCofig("C:\\Users\\user\\Desktop\\filesforseleniumtest\\address.xlsx");
				
			System.out.println(excel.getData(0,4,0));
			
			
			
			
	}

}
