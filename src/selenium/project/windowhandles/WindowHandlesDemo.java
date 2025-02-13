package selenium.project.windowhandles;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandlesDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "/Users/kaushikpamidimuklala/Desktop/selenium-java-project/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
		//Maximize the screen
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
		
		driver.findElement(By.cssSelector("a[class='blinkingText']")).click();
		
		//Get id of windowHandels - How many windows are opened by selenium - [parentId, childId]
		Set<String> windows = driver.getWindowHandles();
		
		
		//iterate to get the child id
		Iterator<String> id = windows.iterator();
		
		String parentID = id.next(); 
		String childID = id.next();
		
		driver.switchTo().window(childID);
		
		//getting the text from from child window
		System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());		
		
		//retrieve email from the statement
		String emailId = driver.findElement(By.cssSelector(".im-para.red"))
												.getText()
												.split("at")[1]
												.trim()
												.split(" ")[0];
		driver.switchTo().window(parentID);
		driver.findElement(By.id("username")).sendKeys(emailId);
	}

}
