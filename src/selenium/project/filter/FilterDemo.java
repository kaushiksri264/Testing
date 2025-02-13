package selenium.project.filter;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FilterDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "/Users/kaushikpamidimuklala/Desktop/selenium-java-project/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		List<String> discountProd;
		/*
		 * driver.findElement(By.id("search-field")).sendKeys("Rice");
		 * 
		 * 
		 * List<WebElement> prod = driver.findElements(By.xpath("//tr/td[1]"));
		 * 
		 * List<WebElement> filteredProd = prod.stream().filter(p ->
		 * p.getText().contains("Rice")) .collect(Collectors.toList());
		 * 
		 * Assert.assertEquals(prod, filteredProd);
		 */
		  
		  int pageCount = 0;
		  int pageLimit = 3;
		do {
	    List<WebElement> actualList = driver.findElements(By.xpath("//tr/td[1]"));
		
		
		discountProd = actualList.stream().filter(list -> list.getText().contains("Flour"))
						   							   .map(list -> getDiscount(list))
						   							   .collect(Collectors.toList());
		discountProd.forEach(l -> System.out.println(l));
		
		if(discountProd.size() < 1) {
			
			if(pageCount >= pageLimit) {
				
				System.out.println("Product Not Found!" + discountProd);
				break;
			}
			pageCount++;
			
			List<WebElement> nextButton = driver.findElements(By.cssSelector("a[aria-label='Next']"));
			
			if(!nextButton.isEmpty()) {
				nextButton.get(0).click();
			}else {
				System.out.println("No more pages available!");
				break;
			}
			
		}
		}while(discountProd.size() < 1);
	}

	private static String getDiscount(WebElement list) {
		// TODO Auto-generated method stub
		
		String prodDiscount = list.findElement(By.xpath("following-sibling::td[2]")).getText();
		return prodDiscount;
	}

}
