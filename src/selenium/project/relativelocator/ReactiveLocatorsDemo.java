package selenium.project.relativelocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;



public class ReactiveLocatorsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "/Users/kaushikpamidimuklala/Desktop/selenium-java-project/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		WebElement nameEditBox = driver.findElement(By.name("email"));
		
		//above relative locator
		String name = driver.findElement(with(By.tagName("label")).above(nameEditBox)).getText();
		
		System.out.println(name);
		
		//below relative locator - still not applicable for 'flex' webelement
		WebElement dob = driver.findElement(By.cssSelector("[for='dateofBirth']"));
		
	   driver.findElement(with(By.tagName("input")).below(dob)).click();
	   
	   
	   //left relative locator
	   WebElement check = driver.findElement(By.cssSelector("[class='form-check-label']"));
	   driver.findElement(with(By.tagName("input")).toLeftOf(check)).click();
	   
	   //right relative locator
	   WebElement ch = driver.findElement(By.cssSelector("[id='inlineRadio1']"));
	   String val = driver.findElement(with(By.tagName("label")).toRightOf(ch)).getText();
	   System.out.println(val);

	}

}
