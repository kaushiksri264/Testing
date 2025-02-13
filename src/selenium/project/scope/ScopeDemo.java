package selenium.project.scope;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScopeDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

			System.setProperty("webdriver.chrome.driver", "/Users/kaushikpamidimuklala/Desktop/selenium-java-project/chromedriver");
			
			WebDriver driver = new ChromeDriver();
			
			//Maximize the screen
			driver.manage().window().maximize();
			
			driver.get("https://rahulshettyacademy.com/AutomationPractice/");
			
			//Get count of links in a page
			System.out.println(driver.findElements(By.tagName("a")).size());
			
			//Get count of links in footer of this page
			//System.out.println(driver.findElements(By.xpath("//div[@id='gf-BIG'] //a']")).size());
			
			
			//Create a subset for driver object, and limiting its scope to footer
			WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
			 
			System.out.println(footerDriver.findElements(By.tagName("a")).size());
			
			//Limiting footerDriver Scope
			
			WebElement firstSecDriver = driver.findElement(By.xpath("//tbody/tr/td[1]/ul[1]"));
			
			System.out.println(firstSecDriver.findElements(By.tagName("a")).size());
			
			//click on the links in the first section and check if the page is displayed
			
			int count = firstSecDriver.findElements(By.tagName("a")).size();
			
			for(int i = 1; i < count; i++) {
				
				String openTab = Keys.chord(Keys.COMMAND,Keys.ENTER);
				
				firstSecDriver.findElements(By.tagName("a")).get(i).sendKeys(openTab);
				
				Thread.sleep(3000L);
			}
				Set<String> windows= driver.getWindowHandles();
				
				//Iterate over the windowHandles
				Iterator<String> id = windows.iterator();
				
				while(id.hasNext()) {
					
					driver.switchTo().window(id.next());
					System.out.println(driver.getTitle());
				}
	

	}
	
}
