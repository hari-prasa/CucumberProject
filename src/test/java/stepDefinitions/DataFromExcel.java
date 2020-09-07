package stepDefinitions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import BaseClass.MTM_Base;
import cucumber.api.java.en.Given;

public class DataFromExcel extends MTM_Base{
	WebDriver driver;
	
	@Given("^user is on MakeMyTrip Home$")
	public void user_is_on_MakeMyTrip_Home() throws IOException, InterruptedException {
		
	MTM_Base.Base();
	driver=MTM_Base.driver;
	
	FileInputStream fs = new FileInputStream("C://Users//hagude//Desktop//Excel//TestData.xlsx");
	@SuppressWarnings("resource")
	Workbook work = new XSSFWorkbook(fs);
	Sheet  sheeet_name = work.getSheet("LoginCredentials");
	
	String User_Name=sheeet_name.getRow(1).getCell(0).getStringCellValue();
	String password=sheeet_name.getRow(1).getCell(1).getStringCellValue();
	
	WebElement wb= driver.findElement(By.xpath("//a[@class='mmtLogo makeFlex']//img"));
	JavascriptExecutor js = (JavascriptExecutor)driver;
		   js.executeScript("arguments[0].click();", wb);

		   WebElement account= driver.findElement(By.xpath("//li[@data-cy='account']"));
		   
		   js.executeScript("arguments[0].click();", account);

	Thread.sleep(3000);


	driver.findElement(By.xpath("//div[@data-cy='googleLogin']")).click();

	Thread.sleep(3000);

	String Parent_Window = driver.getWindowHandle();
	Thread.sleep(3000);
	for(String Child_Window : driver.getWindowHandles())
	{
	if (!(Parent_Window == Child_Window))
	{
	driver.switchTo().window(Child_Window);
	}
	}

	driver.findElement(By.xpath("//input[@type='email']")).sendKeys(User_Name);

	Thread.sleep(3000);

	driver.findElement(By.xpath("//div[@class='VfPpkd-RLmnJb']")).click();

	Thread.sleep(3000);

	driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);

	Thread.sleep(3000);

	driver.findElement(By.xpath("//div[@class='VfPpkd-RLmnJb']")).click();

	Thread.sleep(6000);

	try {
		driver.findElement(By.xpath("//span[@data-cy='modalClose']")).click();
	} catch (Exception e) {
		System.out.println("User login successfully");
	}	
	Thread.sleep(6000);

	try {
		WebElement modal= driver.findElement(By.xpath("//span[@data-cy='modalClose']"));
		   
		   js.executeScript("arguments[0].click();", modal);
		/*driver.findElement(By.xpath("//span[@data-cy='modalClose']")).click();*/
	} catch (Exception e) {
		System.out.println("User login successfully");
	}		 
	
	Thread.sleep(2000);
	
	for(String C_Window : driver.getWindowHandles())
	{
		driver.switchTo().window(C_Window);
	}
	
	}
}