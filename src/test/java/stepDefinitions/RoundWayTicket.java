package stepDefinitions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import BaseClass.BaseClass;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RoundWayTicket extends BaseClass{

WebDriver driver;
public static String src1= "Delhi";
public static String des1= "Mumbai";	
JavascriptExecutor js;
	
@Given("^when user is on MakeMyTrip home page after successfull login$")
public void when_user_is_on_MakeMyTrip_home_page_after_successfull_login() throws InterruptedException, IOException{
	BaseClass.Base();
	driver=BaseClass.driver;
	 js= (JavascriptExecutor)driver;
	FileInputStream fs = new FileInputStream("C://Users//hagude//Desktop//Excel//TestData.xlsx");
	@SuppressWarnings("resource")
	Workbook work = new XSSFWorkbook(fs);
	Sheet  sheeet_name = work.getSheet("LoginCredentials");
	
	String User_Name=sheeet_name.getRow(1).getCell(0).getStringCellValue();
	String password=sheeet_name.getRow(1).getCell(1).getStringCellValue();
	
	WebElement wb= driver.findElement(By.xpath("//a[@class='mmtLogo makeFlex']//img"));
/*JavascriptExecutor js = (JavascriptExecutor)driver;*/
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

Thread.sleep(5000);

try {
driver.findElement(By.xpath("//span[@data-cy='modalClose']")).click();
	/*WebElement web=driver.findElement(By.xpath("//span[@data-cy='modalClose']"));
	 js.executeScript("arguments[0].click();", web);*/
} catch (Exception e) {
	
	System.out.println("User login successfully");
}		 

Thread.sleep(2000);

for(String C_Window : driver.getWindowHandles())
{
	driver.switchTo().window(C_Window);
}

}
		
@When("^user select RoundWay Trip$")
public void user_select_RoundWay_Trip() {
	WebElement round_way= driver.findElement(By.xpath("//li[@data-cy='roundTrip']/parent::ul//li[text()='Round Trip']/span"));
	   
	   js.executeScript("arguments[0].click();", round_way);
/*	driver.findElement(By.xpath("//li[@data-cy='roundTrip']/parent::ul//li[text()='Round Trip']")).click();*/
}

@When("^user select Source and Destination$")
public void user_select_Source_and_Destination() throws InterruptedException {
	//Selected source
	WebElement src= driver.findElement(By.xpath("//label[@for='fromCity']"));
	src.click();
	Thread.sleep(5000);
	
	driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys(src1);
	Thread.sleep(5000);

	driver.findElement(By.cssSelector("#react-autowhatever-1-section-0-item-0 .makeFlex")).click();

    Thread.sleep(5000);
    
    //Selected Destination
    
	driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys(des1);
	Thread.sleep(5000);

	driver.findElement(By.cssSelector("#react-autowhatever-1-section-0-item-0 .makeFlex")).click();

    Thread.sleep(5000);
}

@And("^user click on Travel date$")
public void user_click_on_Travel_date() {
	
	driver.findElement(By.xpath("//div[@aria-label='Thu Sep 24 2020']")).click();
	/*WebElement departure= driver.findElement(By.xpath("//div[@aria-label='Wed Sep 30 2020']/div"));
		
	 js.executeScript("arguments[0].click();", departure);*/
}

@When("^user click on return Date$")
public void user_click_on_return_Date() { 
	 /*WebElement nextmonth =driver.findElement(By.xpath("//span[@aria-label='Next Month']"));

	js.executeScript("arguments[0].click();", nextmonth);*/
	driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
	 
	/*WebElement dep_return= driver.findElement(By.xpath("//div[@aria-label='Wed Oct 21 2020']/div"));
	
	 js.executeScript("arguments[0].click();", dep_return);*/
	driver.findElement(By.xpath("//div[@aria-label='Wed Oct 21 2020']/div")).click();
}

@And("^user should able to book RoundWay Flight Ticket$")
public void user_should_able_to_book_RoundWay_Flight_Ticket() throws InterruptedException {

	 WebElement tra=driver.findElement(By.xpath("//label[@for='travellers']"));
        tra.click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//li[@data-cy='adults-1']")).click();
        
        Thread.sleep(3000);
        driver.findElement(By.xpath("//li[@data-cy='children-0']")).click();
        
        Thread.sleep(3000);
        driver.findElement(By.xpath("//li[@data-cy='infants-0']")).click();
        
        Thread.sleep(3000);
        driver.findElement(By.xpath("//li[@data-cy='travelClass-1']")).click();
    
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@data-cy='travellerApplyBtn']")).click();
        
        WebElement srcbtn= driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/p/a"));
		
		 js.executeScript("arguments[0].click();", srcbtn);
		 Thread.sleep(5000);

}

@Then("^user close the browser$")
public void user_close_the_browser() { 
	driver.quit();
}
}
	

