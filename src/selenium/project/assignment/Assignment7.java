package selenium.project.assignment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "/Users/kaushikpamidimuklala/Desktop/selenium-java-project/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		js.executeScript("window.scroll(0,500)");
		
		/*
		 * int totalColumn = driver.findElements(By.
		 * xpath("//div[@class='left-align'] //fieldset/table/tbody/tr/th")).size();
		 * 
		 * System.out.println(totalColumn);
		 * 
		 * int totalRows = driver.findElements(By.
		 * xpath("//div[@class='left-align'] //fieldset/table/tbody/tr")).size();
		 * 
		 * System.out.println(totalRows);
		 * 
		 * System.out.println(driver.findElement(By.
		 * xpath("//div[@class='left-align'] //fieldset/table/tbody/tr[3]")).getText());
		 * 
		 */
		
		WebElement table = driver.findElement(By.id("product"));
		
		System.out.println(table.findElements(By.tagName("tr")).size());
		
		System.out.println(table.findElements(By.tagName("tr")).get(0).findElements(By.tagName("th")).size());
		
		List<WebElement> secondRow = table.findElements(By.tagName("tr")).get(2).findElements(By.tagName("td"));
		
		System.out.println(secondRow.get(0).getText());
		
		System.out.println(secondRow.get(1).getText());
		
		System.out.println(secondRow.get(2).getText());
	}

}
