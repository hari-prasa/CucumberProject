package com.ExcelSheet;


	import java.io.FileInputStream;

	import org.apache.poi.ss.usermodel.Cell;

	import org.apache.poi.ss.usermodel.Workbook;

	import org.apache.poi.ss.usermodel.WorkbookFactory;

	 

	public class excelSheet {

	    public static String getCellValue(String xl, String Sheet, int r, int c)

	      {

	          try

	                {

	                             FileInputStream fis = new FileInputStream("C:\\Users\\hagude\\Test Data\\TestData.xlsx");

	                             Workbook wb = WorkbookFactory.create(fis);

	                             Cell cell = wb.getSheet(Sheet).getRow(r).getCell(c);

	                              return cell.getStringCellValue();

	                                }

	                                catch (Exception e)

	                                {

	                                                return "";

	                                }

	           

	}
	}
