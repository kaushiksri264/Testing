package selenium.project.miscelleanous;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Miscelleanous {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "/Users/kaushikpamidimuklala/Desktop/selenium-java-project/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		//Delete cookies			
		driver.manage().deleteAllCookies();
		
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//TakeScreenShot in Selenium
		try {
			File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			
			File destination = new File("/Users/kaushikpamidimuklala/Desktop/selenium-java-project/screenshot.png");
			
			FileUtils.copyFile(src,destination);
			
			System.out.println("Sreenshot is taken successfully!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
            System.out.println("Error capturing screenshot: " + e.getMessage());

		}
	}

}
