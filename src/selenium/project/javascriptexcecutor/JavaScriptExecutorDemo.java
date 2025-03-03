package selenium.project.javascriptexcecutor;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class JavaScriptExecutorDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "/Users/kaushikpamidimuklala/Desktop/selenium-java-project/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js= (JavascriptExecutor)driver;
		
		js.executeScript("window.scrollBy(0,500)");
		
		Thread.sleep(3000L);
		
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
		
		List<WebElement> values = driver.findElements(By.xpath("//div[@class='tableFixHead'] //tr/td[4]"));
		
		int sum = 0;
		for(int i = 0; i < values.size(); i++) {
			
			sum += Integer.parseInt(values.get(i).getText());
			
	   }
		System.out.println(sum);
		
		int expectedValue = Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount"))
														.getText()
														.split(":")[1]
														.trim());
		
		Assert.assertEquals(sum, expectedValue);
	}
}
