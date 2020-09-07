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

import BaseClass.BaseClass;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OneWayTicket extends BaseClass{

WebDriver driver;
public static String src1= "Delhi";
public static String des1= "Mumbai";	
JavascriptExecutor js = (JavascriptExecutor)driver;
	
@Given("^user is on MakeMyTrip Application home page$")
public void user_is_on_MakeMyTrip_Application_home_page() throws InterruptedException, IOException{
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
		
		
	@When("^user select OneWay Trip$")
	public void user_select_OneWay_Trip() throws InterruptedException, IOException{
	        
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
	  
	@And("^user enter Source and Destination$")
	public void user_enter_Source_and_Destination() throws IOException, InterruptedException {
		        
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
		        
		        
		        WebElement dep= driver.findElement(By.xpath("//div[@aria-label='Wed Sep 30 2020']/div"));
		        JavascriptExecutor js = (JavascriptExecutor)driver;
				 js.executeScript("arguments[0].click();", dep);
				 
				/* WebElement departure= driver.findElement(By.xpath("//div[@aria-label='Fri Aug 28 2020']/div"));
					
				 js.executeScript("arguments[0].click();", departure);*/
			
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
		  
				 driver.findElement(By.xpath("//div[@class='rc-slider']")).click();
				 
				 driver.findElement(By.xpath("//p[text()='Airlines']/parent::div//span[@data-filtertext='collapsed_airline_SG']")).click();
				 
			}
				
	@And("^user capture screen shot of flight deatils$")
	public void user_capture_screen_shot_of_flight_deatils() throws IOException, InterruptedException {
		
		TakesScreenshot ts = (TakesScreenshot)driver; File source=ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(source, new File("./Test_Report/flightDeatils.png"));
        System.out.println("the Screenshot is taken");
        Thread.sleep(2000);
	}
	
	@And("^user click on Booknow button$")
	public void user_click_on_Booknow_button() throws InterruptedException {
		
		          driver.findElement(By.xpath("//button[text()='Book Now']")).click();
				 String Parent_Window = driver.getWindowHandle();
				 Thread.sleep(3000);
				 for(String Child_Window : driver.getWindowHandles())
				 {
				 if (!(Parent_Window == Child_Window))
				 {
				 driver.switchTo().window(Child_Window);
				 }
				 }
		         
				 try {
					 driver.findElement(By.xpath("//label[@class='block radio append_bottom15']/parent::div//input[@value='yes']")).click();
				} catch (Exception e) {
					
					
					WebElement yes= driver.findElement(By.xpath("//label[@class='make_flex radio append_bottom15']/parent::div//span[@class='outer marR8']"));
					js.executeScript("arguments[0].click();", yes);
				}
				
				 
		         Thread.sleep(3000);
				 driver.findElement(By.xpath("//button[@id='review-continue']")).click();
				 
				 Thread.sleep(5000);
				 driver.findElement(By.xpath("//input[@placeholder='Mobile No']")).sendKeys("7799143082");
				/* Thread.sleep(3000);
				 driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("hariprasadgude@gmail.com");*/
				 
				 Thread.sleep(3000);
				 driver.findElement(By.xpath("//button[@type='button']")).click();
				 Thread.sleep(3000);
				 
				 driver.findElement(By.xpath("//p[@class='viewAll-trvlr']/parent::div//a[text()= '+ ADD ADULT']")).click();
				 Thread.sleep(3000);
				 
				 driver.findElement(By.xpath("//input[@placeholder='First & Middle Name']")).sendKeys("HARI PRASAD");
				 Thread.sleep(3000);
				 driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("GUDE");
				 Thread.sleep(3000);
				 
				 try {
					/* WebElement gender=driver.findElement(By.xpath("//span[text()= 'MALE']"));
					 js.executeScript("arguments[0].click();", gender);*/
						driver.findElement(By.xpath("//span[text()= 'MALE']")).click();
					 Thread.sleep(5000);
				} catch (Exception e) {

				}
				 
				 
				 
				 
				 driver.findElement(By.xpath("//a[text()='Done']")).click();
				 Thread.sleep(3000);
				 
				 driver.findElement(By.xpath("//a[text()='CONFIRM']")).click();
				 Thread.sleep(3000);
				
				
	}
	
	@Then("^user close an broswer$")
	public void user_close_an_broswer() {
		driver.quit();
	}
	
	}

		
	




