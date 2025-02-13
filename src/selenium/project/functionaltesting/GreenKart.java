package selenium.project.functionaltesting;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GreenKart {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		int count = 0;
		
		System.setProperty("webdriver.chrome.driver", "/Users/kaushikpamidimuklala/Desktop/selenium-java-project/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		String[] listGroc = {"Cucumber","Brocolli","Carrot"};
		
 		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
 		
		
		for(int i = 0; i < products.size(); i++) {
			
		 String[] name = products.get(i).getText().split("-"); 
		 
		 String itemName = name[0].trim();
		 
			List<String> veggies = Arrays.asList(listGroc);
			
			
			if(veggies.contains(itemName )) {
				
				count++;
				
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				
				Thread.sleep(1000);
				
				if(count==listGroc.length) {
					break;
				}
				
			} 
		}
 	}

}
