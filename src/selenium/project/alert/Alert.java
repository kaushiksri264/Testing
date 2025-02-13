package selenium.project.alert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alert {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String text = "Rahul";
		
		System.setProperty("webdriver.chrome.driver", "/Users/kaushikpamidimuklala/Desktop/selenium-java-project/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.findElement(By.id("name")).sendKeys(text);
		
		driver.findElement(By.cssSelector("input[value='Alert']")).click();
		
		Thread.sleep(1000);
		
		System.out.println(driver.switchTo().alert().getText());
		
		String getValue = driver.switchTo().alert().getText();
		
		String[] arrVal = getValue.split(",");
		
		String resVal = arrVal[0].split(" ")[1];
		
		System.out.println(resVal);
		
		driver.switchTo().alert().accept();	
		
		driver.findElement(By.id("name")).sendKeys(text);
		
		driver.findElement(By.id("confirmbtn")).click();
		
		Thread.sleep(1000);
			
		System.out.println(driver.switchTo().alert().getText());
		
		driver.switchTo().alert().dismiss();

	}

}
