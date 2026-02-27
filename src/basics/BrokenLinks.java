package basics;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class BrokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException, URISyntaxException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		// not stop reading codes when test fails
		SoftAssert softAssert = new SoftAssert();
		// broken URL
		// get all the URLs tied up to the links using Selenium
		List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		for (WebElement link : links) {
			String url = link.getAttribute("href");
			// create URI class to use open Connection method
			// string to URI
			URI uri = new URI(url);
			// URI to URL
			URL brokenLink = uri.toURL();
			HttpURLConnection conn = (HttpURLConnection) brokenLink.openConnection();
			// java methods will call URL's and gets you the status code
			conn.setRequestMethod("HEAD");
			conn.connect(); // conn gets the response
			// if the status code is > 400 than url is not working
			int resCode = conn.getResponseCode();
			softAssert.assertTrue(resCode < 400, link.getText() + " has broken url with status " + resCode); // step1
		}
		softAssert.assertAll(); // step2-store all the fail or pass and show them at once at the end
	}

}
