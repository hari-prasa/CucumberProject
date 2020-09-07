package stepDefinitions;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestData {

	
	public TestData() throws IOException {
		try {
			FileInputStream fs = new FileInputStream("C://Users//hagude//Desktop//Excel//TestData.xlsx");
			@SuppressWarnings("resource")
			Workbook work = new XSSFWorkbook(fs);
			Sheet  sheeet_name = work.getSheet("LoginCredentials");
			String User_Name=sheeet_name.getRow(1).getCell(0).getStringCellValue();
			String password=sheeet_name.getRow(1).getCell(1).getStringCellValue();
		} catch (Exception e) {
			e.getMessage();
		}
		
	}
}
