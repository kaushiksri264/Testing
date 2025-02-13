package selenium.project.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "/Users/kaushikpamidimuklala/Desktop/selenium-java-project/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		System.out.println(driver.findElement(By.cssSelector("input[id='checkBoxOption1'] ")).isSelected());
		
		//Assert.assertFalse(driver.findElement(By.cssSelector("input[id='checkBoxOption1'] ")).isSelected());
		
		driver.findElement(By.cssSelector("input[id='checkBoxOption1'] ")).click();
		
		System.out.println(driver.findElement(By.cssSelector("input[id='checkBoxOption1'] ")).isSelected());
		
		//Assert.assertTrue(driver.findElement(By.cssSelector("input[id='checkBoxOption1'] ")).isSelected());
		
		Thread.sleep(1000);
		
		driver.findElement(By.cssSelector("input[id='checkBoxOption1']")).click();
		
		System.out.println(driver.findElement(By.cssSelector("input[id='checkBoxOption1'] ")).isSelected());
		
		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
		
		
		
		
	}

}
