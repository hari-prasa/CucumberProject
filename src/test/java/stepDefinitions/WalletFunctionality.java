package stepDefinitions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import BaseClass.BaseClass;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class WalletFunctionality extends BaseClass{
	WebDriver driver;
	JavascriptExecutor js = (JavascriptExecutor)driver;
	@Given("^when user is on MMT Home Page successfull$")
	public void when_user_is_on_MMT_Home_Page_successfull() throws IOException, InterruptedException {
		
		BaseClass.Base();
	driver=BaseClass.driver;
	
	//Retrieve Data from Excel sheet
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
	} catch (Exception e) {
		System.out.println("User login successfully");
	}		 
	
	Thread.sleep(2000);
	
	for(String P_Window : driver.getWindowHandles())
	{
		driver.switchTo().window(P_Window);
	}
	
	}
	
	@And("^user click on Wallet from the list$")
	public void user_click_on_Wallet_from_the_list() throws InterruptedException {
		driver.findElement(By.xpath("//li[@data-cy='Wallet']")).click();
		/*WebElement wallet= driver.findElement(By.xpath("//li[@data-cy='Wallet']"));
		   
		   js.executeScript("arguments[0].click();", wallet);*/
		   
		   String Parent_Window = driver.getWindowHandle();
			Thread.sleep(3000);
			for(String Child_Window : driver.getWindowHandles())
			{
			if (!(Parent_Window == Child_Window))
			{
			driver.switchTo().window(Child_Window);
			}
			}
		
}
	@And("^user capture screen shot as wallet$")
	public void user_capture_screen_shot_as_wallet() throws IOException, InterruptedException {
		TakesScreenshot ts = (TakesScreenshot)driver; File source=ts.getScreenshotAs(OutputType.FILE);
        
        FileUtils.copyFile(source, new File("./Test_Report/Wallet_blance.png"));
        System.out.println("the Screenshot is taken");
        Thread.sleep(2000);
	}
	
	@Then("^user quit the browser$")
	public void user_quit_the_browser() {
		driver.close();
		
	}
}