package selenium.project.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment8 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "/Users/kaushikpamidimuklala/Desktop/selenium-java-project/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		
		  driver.findElement(By.id("autocomplete")).click();
		  
		  driver.findElement(By.id("autocomplete")).sendKeys("ind");
		  
		  Thread.sleep(2000L);
		  
		  driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
		  driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
		  
		  Thread.sleep(2000L);
		  
		  System.out.println(driver.findElement(By.id("autocomplete")).getDomProperty(
		  "value"));
		 
		
		 
	    }
	}