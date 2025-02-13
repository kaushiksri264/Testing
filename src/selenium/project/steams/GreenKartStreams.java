package selenium.project.steams;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class GreenKartStreams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "/Users/kaushikpamidimuklala/Desktop/selenium-java-project/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		//xpath - //thead//tr/th[1]
		
		driver.findElement(By.xpath("//table[@class='table table-bordered'] //thead//tr/th[1]")).click();
		
		//cssSelector - tr td:nth-child(1)
		List<WebElement> actualProducts = driver.findElements(By.cssSelector("table[class*='table'] tbody tr td:nth-child(1)"));
		
		List<String> orginialProducts = actualProducts.stream()
													  .map(products -> products.getText())
													  .collect(Collectors.toList());
		
		
		List<String> sortedProducts = orginialProducts.stream().sorted().collect(Collectors.toList());
		
		Assert.assertTrue(orginialProducts.equals(sortedProducts));
		
		List<String> price;
		
		do {
		
		List<WebElement> elementsList = driver.findElements(By.cssSelector("table[class*='table'] tbody tr td:nth-child(1)"));
		
		price = elementsList.stream().filter(prod -> prod.getText().contains("Wheat"))
																   .map(prod -> getProdPrice(prod))
													   			   .collect(Collectors.toList());
		price.forEach(prod->System.out.println(prod));
		
		if(price.size() < 1) {
			
			driver.findElement(By.cssSelector("a[aria-label='Next']")).click();
		}
		
		}while(price.size() < 1);
		
	}

	private static String getProdPrice(WebElement prod) {
		// TODO Auto-generated method stub
		String priceValue = prod.findElement(By.xpath("following-sibling::td[1]")).getText();
		return priceValue;
	}

}
