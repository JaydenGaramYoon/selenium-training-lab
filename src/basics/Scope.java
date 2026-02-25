package basics;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Scope {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.ebay.com/");

		// get the first column
		WebElement firstColumnDriver = driver.findElement(By.xpath("//div[@class='gf-big-links__col'][1]/div/ul"));
		List<WebElement> links = firstColumnDriver.findElements(By.tagName("a"));
		System.out.println(links.size());

		// key chord to click on any link to open
		String clickLinks = Keys.chord(Keys.CONTROL, Keys.ENTER);

		// send the keychord to sendkeys method of the link element
		for (WebElement link : links) {
			link.sendKeys(clickLinks);
		}
		// set of browsers - Set<String> openBrowsers = driver.getWindowHandles();
		Set<String> openBrowsers = driver.getWindowHandles();
		// get each ids - use Iterator<String> browserId = OpenBrowsers.iterator();
		Iterator<String> currentBrowserId = openBrowsers.iterator();
		// while the browserId has next browser Id - browserId.hasNext();
		while (currentBrowserId.hasNext()) {
			driver.switchTo().window(currentBrowserId.next());
			// get the browser name
			System.out.println(driver.getTitle());
		}
	}

	public static void clickFirstColumnLinks(WebDriver driver) {
		// get the first column
		WebElement firstColumnDriver = driver.findElement(By.xpath("//div[@class='gf-big-links__col'][1]/div/ul"));
		List<WebElement> links = firstColumnDriver.findElements(By.tagName("a"));
		System.out.println(links.size());

		// key chord to click on any link to open
		String clickLinks = Keys.chord(Keys.CONTROL, Keys.ENTER);

		// send the keychord to sendkeys method of the link element
		for (WebElement link : links) {
			link.sendKeys(clickLinks);
		}
		// set of browsers - Set<String> openBrowsers = driver.getWindowHandles();
		Set<String> openBrowsers = driver.getWindowHandles();
		// get each ids - use Iterator<String> browserId = OpenBrowsers.iterator();
		Iterator<String> currentBrowserId = openBrowsers.iterator();
		// while the browserId has next browser Id - browserId.hasNext();
		while (currentBrowserId.hasNext()) {
			driver.switchTo().window(currentBrowserId.next());
			// get the browser name
			System.out.println(driver.getTitle());
		}
	}

}
