package selenium.project.endtoend;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CompleteLocators {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "/Users/kaushikpamidimuklala/Desktop/selenium-java-project/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		
		driver.findElement(By.cssSelector("a[value='BLR']")).click();
		
		driver.findElement(By.xpath("//div[@class='search_options_menucontentbg'] //a[@value='MAA']")).click();
		
		driver.findElement(By.cssSelector("a[class='ui-state-default ui-state-active']")).click();
		
		System.out.println(driver.findElement(By.id("Div1")).getDomAttribute("style").contains("1"));
		
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();
		
		if(driver.findElement(By.id("Div1")).getDomAttribute("style").contains("1")) {
			
			System.out.println("Is Enabled");
			
			Assert.assertTrue(false);
		}
		else {
			Assert.assertTrue(true);
		}
		
        driver.findElement(By.id("divpaxinfo")).click();
		
		Thread.sleep(1000);
		  
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		
		for(int i = 1; i < 5; i++) {
			
			driver.findElement(By.id("hrefIncAdt")).click();
			
		}
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		
		driver.findElement(By.id("btnclosepaxoption")).click();
		
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_chk_friendsandfamily']")).click();
		
		driver.findElement(By.name("ctl00$mainContent$btn_FindFlights")).click();
		

	}

}
