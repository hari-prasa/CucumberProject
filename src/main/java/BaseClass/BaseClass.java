package BaseClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
public static WebDriver driver;

public void initialization() throws IOException {
	 try{
	Properties prop=new Properties();
	FileInputStream ip= new FileInputStream("C:\\Users\\hagude\\eclipse-workspace\\CucumberProject\\com.config.properties\\config.properties");
    prop.load(ip);
    } 
	 catch (IOException e) {
        e.getMessage();
    }
    }

public static void Base() throws IOException {
	Properties prop=new Properties();
	FileInputStream ip= new FileInputStream("C:\\Users\\hagude\\eclipse-workspace\\CucumberProject\\com.config.properties\\config.properties");
    prop.load(ip);
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\hagude\\chromedriver\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.get(prop.getProperty("MTM_URL"));
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
}

	
}