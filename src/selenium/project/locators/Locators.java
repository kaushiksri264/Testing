package selenium.project.locators;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/kaushikpamidimuklala/Desktop/Selenium Projects/chromedriver");
		
		WebDriver driver = new ChromeDriver(); 
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
		driver.findElement(By.id("inputUsername")).sendKeys("rahul");
		
		driver.findElement(By.name("inputPassword")).sendKeys("hello123");
		
		driver.findElement(By.className("signInBtn")).click();
		
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		
		driver.findElement(By.linkText("Forgot your password?")).click();
		
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Mark");
		
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("Mark123@gmail.com");
		
		driver.findElement(By.cssSelector("input[placeholder='Phone Number']")).sendKeys("123-456-7890");
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).clear();
		
		driver.findElement(By.xpath("//input[@type='text'][3]")).sendKeys("123-456-7890");
		
		driver.findElement(By.xpath("//form/input[3]")).clear();
		
		driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();
		
		System.out.println(driver.findElement(By.cssSelector("form p")).getText());
		
		//driver.findElement(By.xpath("//button[@class='go-to-login-btn']")).click();
		
		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
		
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys("rahul");
		
		driver.findElement(By.cssSelector("input[type*='Pass']")).sendKeys("rahulshettyacademy");
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//input[contains(@id,'chkboxOne')]")).click();
		
		driver.findElement(By.xpath("//input[contains(@id,'chkboxTwo')]")).click();
		
		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
		
		
		
		
	}

}
