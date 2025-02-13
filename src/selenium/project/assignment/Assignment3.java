package selenium.project.assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment3 {
	
	public static void getUserDetails(WebDriver driver, String userName, String password) throws InterruptedException {
	
		
	driver.findElement(By.id("username")).sendKeys(userName);
	
	driver.findElement(By.id("password")).sendKeys(password);
	
	//driver.findElement(By.xpath("(//span[@class='checkmark'])[2]")).click();
	
	driver.findElement(By.xpath("//label[@class='customradio'] /input[@value='user']")).click();
	
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	
	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("button[id='okayBtn']")));
	
	driver.findElement(By.cssSelector("button[id='okayBtn']")).click();
	
	WebElement option = driver.findElement(By.cssSelector("div[class='form-group'] select"));
	
	Select element = new Select(option);
	
	element.selectByValue("consult");
	
	driver.findElement(By.xpath("//input[@name='terms']")).click();
	
	driver.findElement(By.name("signin")).click();
	
		
	}
	
	public static void addDevicesToCart(WebDriver driver) {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".card-footer .btn-info")));
		
		List<WebElement> products = driver.findElements(By.cssSelector(".card-footer .btn-info"));
		
		for(int i = 0; i < products.size();i++) {
			
				products.get(i).click();
		}
		
		driver.findElement(By.partialLinkText("Checkout")).click();
		
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "/Users/kaushikpamidimuklala/Desktop/selenium-java-project/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		
		String userName = "rahulshettyacademy";
		String password = "learning";
		
		getUserDetails(driver,userName,password);
		
		addDevicesToCart(driver);

	}

}
