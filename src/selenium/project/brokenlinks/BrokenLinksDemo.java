package selenium.project.brokenlinks;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class BrokenLinksDemo {

	public static void main(String[] args) throws URISyntaxException, MalformedURLException, IOException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "/Users/kaushikpamidimuklala/Desktop/selenium-java-project/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		/*
		 * String url =
		 * driver.findElement(By.cssSelector("a[href*='brokenlink']")).getDomAttribute(
		 * "href");
		 * 
		 * HttpURLConnection conn = (HttpURLConnection) new
		 * URI(url).toURL().openConnection();
		 * 
		 * conn.setRequestMethod("HEAD");
		 * 
		 * conn.connect();
		 * 
		 * int responseCode = conn.getResponseCode();
		 * 
		 * System.out.println(responseCode);
		 */
		//Get base URL
		String baseUrl = driver.getCurrentUrl();
		
		List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		
		SoftAssert as = new SoftAssert();

        for (WebElement link : links) {
        	
            String url = link.getDomAttribute("href");

            //Check if URL is null or empty before proceeding
            if (url == null || url.isEmpty()) {
                System.out.println("Skipping empty href for: " + link.getText());
                continue;
            }
            
            //Convert relative URLs to absolute URLS
            if(!url.startsWith("http")) {
            	url = baseUrl + url;
            }

            // Create a connection and send a HEAD request
            HttpURLConnection conn = (HttpURLConnection) new URI(url).toURL().openConnection();
            conn.setRequestMethod("HEAD");
            conn.connect();

            int responseCode = conn.getResponseCode();
            System.out.println("Response Code for " + link.getText() + " : " + responseCode);
            
          //If response is 400 or above, flag as broken link
            as.assertTrue(responseCode<400,"Broken Link Found: " + link.getText() + " (" + url + ")");   
        }
        //if any failure are store use assertall(it reports failure) and then fail
        as.assertAll();
        }
}
