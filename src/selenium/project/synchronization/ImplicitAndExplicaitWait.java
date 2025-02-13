package selenium.project.synchronization;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ImplicitAndExplicaitWait {
	
	public static void addItems(WebDriver driver, String[] listGroc) {
		
		int count = 0;
		
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
 		
		
		for(int i = 0; i < products.size(); i++) {
			
		 String[] name = products.get(i).getText().split("-"); 
		 
		 String itemName = name[0].trim();
		 
			List<String> veggies = Arrays.asList(listGroc);
			
			
			if(veggies.contains(itemName )) {
				
				count++;
				
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				
				if(count==listGroc.length) {
					break;
				}
				
			} 
		}
		
	}
	public static void checkOutToPayment(WebDriver driver) {
		
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		
		driver.findElement(By.xpath("//div[@class='action-block']/button")).click();
		
	}
	
	public static void addPromoCode(WebDriver driver, String promoCode) {
			
		driver.findElement(By.cssSelector("input[placeholder='Enter promo code']")).sendKeys(promoCode);
		
		driver.findElement(By.xpath("//button[@class='promoBtn']")).click();
	}
	
	public static void getMessage(WebDriver driver) {
		
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "/Users/kaushikpamidimuklala/Desktop/selenium-java-project/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		String[] listGroc = {"Cucumber","Brocolli","Carrot"};
		
		String promoCode = "rahulshettyacademy";
		
		addItems(driver,listGroc);
		
		checkOutToPayment(driver);
		
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[placeholder='Enter promo code']")));
		
		addPromoCode(driver, promoCode);
		
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		
		getMessage(driver);
 		
	}
	

}
