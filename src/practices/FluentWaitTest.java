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

public class FluentWaitTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		driver.findElement(By.cssSelector("#start > button")).click();
		// create a wait object of FluentWait class
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);
		WebElement fluentWait = wait.until(new Function<WebDriver, WebElement>() {
			int counter = 0;

			public WebElement apply(WebDriver driver) {
				counter++;
				if (driver.findElement(By.cssSelector("#finish > h4")).isDisplayed()) {
					System.out.println("Poll " + counter + ") Displayed: "
							+ driver.findElement(By.cssSelector("#finish > h4")).getText());
					return driver.findElement(By.cssSelector("#finish > h4"));
				} else {
					System.out.println("Poll " + counter + ") Not displayed yet.");
					return null;
				}
			}
		});
	}
}
