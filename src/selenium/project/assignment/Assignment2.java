package selenium.project.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "/Users/kaushikpamidimuklala/Desktop/selenium-java-project/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		driver.findElement(By.name("name")).sendKeys("Mark");
		
		driver.findElement(By.name("email")).sendKeys("mark123@gmail.com");
		
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("Markpassword123");
		
		driver.findElement(By.cssSelector("input[type='checkbox")).click();
		
		WebElement elements = driver.findElement(By.id("exampleFormControlSelect1"));
		
		Select staticDropDown = new Select(elements);
		
		staticDropDown.selectByVisibleText("Male");
		
		driver.findElement(By.xpath("//input[@value='option1']")).click();
		
		driver.findElement(By.name("bday")).sendKeys("02/15/1993");
		
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		
		Thread.sleep(1000);
		
		System.out.println(driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText());

	}

}
