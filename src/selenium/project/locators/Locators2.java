package selenium.project.locators;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;



public class Locators2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
System.setProperty("webdriver.chrome.driver", "/Users/kaushikpamidimuklala/Desktop/Selenium Projects/chromedriver");
		
		WebDriver driver = new ChromeDriver(); 
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		String name = "rahul";
		
		String password = getPassword(driver);
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
		driver.findElement(By.id("inputUsername")).sendKeys(name);
		
		driver.findElement(By.name("inputPassword")).sendKeys(password);
		
		Thread.sleep(1000);
		
		driver.findElement(By.cssSelector("input[id='chkboxOne']")).click();
		
		driver.findElement(By.xpath("//input[contains(@id,'chkboxTwo')]")).click();
		
		driver.findElement(By.className("signInBtn")).click();
		
		Thread.sleep(1000);
		
		System.out.println(driver.findElement(By.tagName("p")).getText());
		
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//button[text()='Log Out']")).click();
		
		Thread.sleep(1000);
		
		driver.close();
		
		}
	
		public static String getPassword(WebDriver driver) throws InterruptedException {
			
			driver.get("https://rahulshettyacademy.com/locatorspractice/");
			
			driver.findElement(By.linkText("Forgot your password?")).click();
			
			Thread.sleep(1000);
			
			driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();
			
			String passwordText = driver.findElement(By.cssSelector("form p")).getText();
			
			String[] passwordArray = passwordText.split("'");
			
			String password = passwordArray[1].split("'")[0];
			
			return password;
			
		}

}
