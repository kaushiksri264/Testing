package selenium.project.invokingmultipulewindows;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class InvokingMultipuleWindows {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "/Users/kaushikpamidimuklala/Desktop/selenium-java-project/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		driver.switchTo().newWindow(WindowType.TAB);
		
		Set<String> handle= driver.getWindowHandles();
		
		//Iterator
		Iterator<String> id = handle.iterator();
		
		String parentId = id.next();
		String childId = id.next();
		
		driver.switchTo().window(childId);
		
		driver.get("https://rahulshettyacademy.com/");
		
		String courseName = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']")).get(1).getText();
		
		driver.switchTo().window(parentId);
		
		WebElement name = driver.findElement(By.xpath("//input[@name='name']"));
		
		name.sendKeys(courseName);
		
		//screentShot
		File source = name.getScreenshotAs(OutputType.FILE);
		
		
		FileUtils.copyFile(source, new File("logo.png"));
		Thread.sleep(3000L);
		//Get Dimensions
		System.out.println(name.getRect().getDimension().getHeight());
		System.out.println(name.getRect().getDimension().getWidth());
		
	}
	
}
