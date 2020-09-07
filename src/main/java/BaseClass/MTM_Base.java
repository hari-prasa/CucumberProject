package BaseClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class MTM_Base {
	public static WebDriver driver;

	public static void Base() {
		
		char grade = 'A';
		      switch(grade) {
		         case 'A' :
		        	 System.setProperty("webdriver.chrome.driver", "C:\\Users\\hagude\\chromedriver\\chromedriver.exe");
						driver=new ChromeDriver();
						driver.get("https://www.makemytrip.com/flights/");
						driver.manage().window().maximize();
						driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		            break;
		         case 'B' :
		        	 System.setProperty("webdriver.ie.driver", "C:\\Users\\hagude\\Downloads\\IEDriverServer\\IEDriverServer.exe");
					  driver=new InternetExplorerDriver();
					  driver.get("https://www.makemytrip.com/flights/");
						driver.manage().window().maximize();
						driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
				    System.out.println("InternetExplorer");
		            break;
		        default :
		            System.out.println("Invalid grade");
		      }
		    
	}
}
