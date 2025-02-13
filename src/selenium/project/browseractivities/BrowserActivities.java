package selenium.project.browseractivities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserActivities {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "/Users/kaushikpamidimuklala/Desktop/Selenium Projects/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().fullscreen( );
		
		driver.get("http://google.com");
		
		driver.navigate().to("https://rahulshettyacademy.com");
		
		driver.navigate().back();
		
		
		
	}

}
