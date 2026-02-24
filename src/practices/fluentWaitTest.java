package practices;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class fluentWaitTest {
	public static void main(String[] args) { 
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		driver.findElement(By.cssSelector("[id='start'] button")).click();
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);
		WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				//check whether the element is displayed or not
				if (driver.findElement(By.cssSelector("[id='finish'] h4")).isDisplayed()) {
					//if found, return the element to stop waiting
					return driver.findElement(By.cssSelector("[id='finish'] h4"));
				} else
					//if not, return null to be ignored to wait till the element is found
					return null;
			}
//			public WebElement apply(WebDriver driver) {
//				return driver.findElement(By.cssSelector("[id='finish'] h4")); //this triggers the wait to stop immediately since this element is already there
//			}
			
		});
	}
}
