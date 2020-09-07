package stepDefinitions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import BaseClass.BaseClass;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ScrollDownAction  extends BaseClass {
	
	WebDriver driver;
	
	@Given("^user is on MakeMyTrip home page$")
	
	public void user_is_on_MakeMyTrip_home_page() throws InterruptedException, IOException {
		
		BaseClass.Base();
		driver=BaseClass.driver;
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

	Thread.sleep(3000);

	try {
		WebElement web=driver.findElement(By.xpath("//span[@data-cy='modalClose']"));
		 js.executeScript("arguments[0].click();", web);
	} catch (Exception e) {
		System.out.println("User login successfully");
	}		 

	Thread.sleep(2000);

	for(String C_Window : driver.getWindowHandles())
	{
		driver.switchTo().window(C_Window);
	}

	}
	
	
	@When("^verify title of MakeMyTrip$")
	public void verify_title_of_MakeMyTrip() throws InterruptedException {
		
		String title=driver.getTitle();
		System.out.println(title);
		Assert.assertEquals("MakeMyTrip - #1 Travel Website 50% OFF on Hotels, Flights & Holiday", title);
		Thread.sleep(5000);
	}
	
	@Then("^user perform scrolldown action and capture screen shot$")
	public void user_perform_scrolldown_action_and_capture_screen_shot() throws InterruptedException, IOException {
		
		//to perform Scroll on application using MakeMyTrip
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,550)", "");
        
        TakesScreenshot ts = (TakesScreenshot)driver; File source=ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(source, new File("./Test_Report/scrolldown.png"));
        System.out.println("the Screenshot is taken");
        Thread.sleep(2000);
		
	}
	
	@Then("^user close broswer$")
	public void user_close_broswer() {
		driver.close();
	}
}
