package practices;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WindowsHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

		String parentBrowserId;
		String childBrowserId;
		// Open browser
		driver.get("https://the-internet.herokuapp.com/");
		// click the "multiple windows" link
		List<WebElement> listOfLinks = driver.findElements(By.cssSelector("li a"));
		for (WebElement link : listOfLinks) {
			String text = link.getText();
			System.out.println(text);
			if (text.contains("Windows")) {
				link.click();
				break;
			}
		}
		// wait for the next element to be visible
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='example'] a")));
		if (driver.findElement(By.cssSelector("div[class='example'] a")).isDisplayed()) {
			driver.findElement(By.cssSelector("div[class='example'] a")).click();
		}
		// set both parent and child windows
		Set<String> windows = driver.getWindowHandles();
		// get ids from the windows
		Iterator<String> window = windows.iterator();
		// get window ids
		String parentWindowId = window.next();
		String childWindId = window.next();
		// switch to the child browser
		driver.switchTo().window(childWindId);
		// print out the "window" from the text
		String textFromChild = driver.findElement(By.cssSelector("div[class='example'] h3")).getText().split(" ")[1];
		System.out.println("Grabbed from child window: " + textFromChild);
		// switch back to the parent
		driver.switchTo().window(parentWindowId);
		// print out the "window" from the parent browser
		String textFromParent = driver.findElement(By.cssSelector("div[class='example'] h3")).getText().split("new")[1]
				.trim();
		System.out.println("Grabbed from child window: " + textFromParent);
		// close all the browsers;
		driver.quit();
	}
}
