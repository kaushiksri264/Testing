package selenium.project.dropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UpdatedDropDown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "/Users/kaushikpamidimuklala/Desktop/SeleniumProject/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		driver.findElement(By.id("divpaxinfo")).click();
		
		Thread.sleep(1000);
		
		
		/*
		 * while(i<5) {
		 * 
		 * driver.findElement(By.id("hrefIncAdt")).click(); i++;
		 * 
		 * }
		 */
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		
		for(int i = 1; i < 5; i++) {
			
			driver.findElement(By.id("hrefIncAdt")).click();
			
		}
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		
		driver.findElement(By.id("btnclosepaxoption")).click();

	}

}
