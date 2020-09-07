package stepDefinitions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
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

import BaseClass.BaseClass;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class LoginFunctionality extends BaseClass{
	Properties prop=new Properties();
WebDriver driver;
JavascriptExecutor js = (JavascriptExecutor)driver;
	
@Given("^user enters username and password$")
public void user_enters_username_and_password() throws InterruptedException, IOException{
	BaseClass.Base();
	driver=BaseClass.driver;
	FileInputStream ip= new FileInputStream("C:\\Users\\hagude\\eclipse-workspace\\CucumberProject\\com.config.properties\\config.properties");
	prop.load(ip);
	FileInputStream fs = new FileInputStream("C://Users//hagude//Desktop//Excel//TestData.xlsx");
	@SuppressWarnings("resource")
	Workbook work = new XSSFWorkbook(fs);
	Sheet  sheeet_name = work.getSheet("LoginCredentials");
	
	String User_Name=sheeet_name.getRow(1).getCell(0).getStringCellValue();
	String password=sheeet_name.getRow(1).getCell(1).getStringCellValue();
	WebElement wb= driver.findElement(By.xpath(prop.getProperty("MTM_Img_xpath")));
JavascriptExecutor js = (JavascriptExecutor)driver;
	   js.executeScript("arguments[0].click();", wb);

	   WebElement account= driver.findElement(By.xpath(prop.getProperty("account_xpath")));
	   
	   js.executeScript("arguments[0].click();", account);

Thread.sleep(3000);


driver.findElement(By.xpath(prop.getProperty("google_login_xpath"))).click();

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

driver.findElement(By.xpath(prop.getProperty("email_xpath"))).sendKeys(User_Name);

Thread.sleep(3000);

driver.findElement(By.xpath(prop.getProperty("next_button_xpath"))).click();

Thread.sleep(3000);

driver.findElement(By.xpath(prop.getProperty("password_xpath"))).sendKeys(password);

Thread.sleep(3000);

driver.findElement(By.xpath(prop.getProperty("next_button_xpath"))).click();

Thread.sleep(3000);

try {
	driver.findElement(By.xpath(prop.getProperty("cross_mark_xpath"))).click();
} catch (Exception e) {
	System.out.println("User login successfully");
}		 

Thread.sleep(2000);

for(String C_Window : driver.getWindowHandles())
{
	driver.switchTo().window(C_Window);
}

}
		

	@When("^user is on MakeMyTrip Home Page$")
	public void user_is_on_MakeMyTrip_Home_Page() throws InterruptedException, IOException{
	        
		String title=driver.getTitle();
		System.out.println(title);
		Assert.assertEquals("MakeMyTrip - #1 Travel Website 50% OFF on Hotels, Flights & Holiday", title);
		
		
		Thread.sleep(5000);
		
		try {
			
			driver.switchTo().frame("webklipper-publisher-widget-container-notification-frame");
			driver.findElement(By.cssSelector("a.close")).click();
			driver.switchTo().defaultContent();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("No Alert found");
		}

	}
	
	@And("^user capture screen shot after successfull login$")
	public void user_capture_screen_shot_after_successfull_login() throws IOException, InterruptedException {
		TakesScreenshot ts = (TakesScreenshot)driver; File source=ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(source, new File("./Test_Report/Loginsuccesfull.png"));
        System.out.println("the Screenshot is taken");
        Thread.sleep(2000);
	}
	
	@Then("^user is able close the browser$")
	public void user_is_able_close_the_browser() {
		
		driver.close();
		
	}
	  
	
	}

		
	



