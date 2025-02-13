package selenium.project.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/kaushikpamidimuklala/Desktop/selenium-java-project/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
		//Maximize the screen
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//Select a checkbox
		//driver.findElement(By.id("checkBoxOption2")).click();
		
		driver.findElement(By.xpath("//*[@id='checkbox-example'] /fieldset/label[2]/input")).click();
		
		String label = driver.findElement(By.xpath("//*[@id='checkbox-example'] /fieldset/label[2]")).getText();
		
		WebElement dropDown = driver.findElement(By.id("dropdown-class-example"));
		
		Select opt = new Select(dropDown);
		
		opt.selectByVisibleText(label);
		
		driver.findElement(By.id("name")).sendKeys(label);
		
		driver.findElement(By.cssSelector("input[class='btn-style']")).click();
		
		String text = driver.switchTo().alert().getText();
		
		if(text.contains(label)) {
			
			System.out.println("Alert message is successfull!");
		}else {
			
			System.out.println("Something is Wrong with Execution");
		}
		

		
		
		
	}

}