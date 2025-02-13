package selenium.project.actions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "/Users/kaushikpamidimuklala/Desktop/selenium-java-project/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
		//Maximize the screen
		driver.manage().window().maximize();
		
		driver.get("https://www.amazon.com/");
		
		Actions act = new Actions(driver);
		
		WebElement move = driver.findElement(By.id("nav-link-accountList"));
		
		//Move to specific Element
		act.moveToElement(move)
						.contextClick()
						.build()
						.perform();
		
		
		//Explicit Wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']"))));
				
		//Composite Action
		act.moveToElement(driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']")))
												.click()
												.keyDown(Keys.SHIFT)
												.sendKeys("Hello")
												.doubleClick()
												.build()
												.perform();
		
		

	}

}
