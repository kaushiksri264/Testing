package selenium.project.clandertest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CalenderTestDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "/Users/kaushikpamidimuklala/Desktop/selenium-java-project/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
		//Maximize the screen
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		String year = "2027";
		String day = "15";
		String month = "6";
		String[] expectedDate = {month,day,year};
		
		driver.findElement(By.cssSelector(".react-date-picker__inputGroup")).click();
		driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
		driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
		driver.findElement(By.xpath("//button[text()='" + year + "']")).click();
		driver.findElements(By.cssSelector(".react-calendar__year-view__months__month")).get(Integer.parseInt(month)-1).click();
		driver.findElement(By.xpath("//abbr[text()='" + day+"']")).click();
		
		
		List<WebElement> date = driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));
		
		for(int i= 0; i < date.size(); i++) {
			System.out.println(date.get(i).getDomAttribute("value"));
			
			Assert.assertEquals(date.get(i).getDomAttribute("value"), expectedDate[i]);
			
			
		}
		driver.close();
	}

}
