package BaseClass;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class verifytitlewithoutusingassert {
	Logger log=Logger.getLogger(verifytitlewithoutusingassert.class);
	public void verifytitle() {
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\hagude\\\\chromedriver\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		log.info("Browser Launched");
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		driver.navigate().to("https://www.inviul.com");
		log.info("Inviul Application URL Launched");
		String actualTitle = driver.getTitle();
		driver.manage().window().maximize();
		String expectedTitle = "Free Selenium Tutorials | TestNG Tutorials | Cucumber Tutorials | Inviul";
		if(actualTitle.equalsIgnoreCase(expectedTitle))
			System.out.println("Title Matched");
		else
			System.out.println("Title didn't match");
		driver.close();
		driver.quit();
		log.info("Inviual Application Title verifed");
	}
	
	
	public static void main(String[] args) {
		
		verifytitlewithoutusingassert verify=new verifytitlewithoutusingassert();
		verify.verifytitle();
	}

}
