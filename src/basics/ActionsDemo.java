package basics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		Actions actions = new Actions(driver);
		driver.get("https://www.amazon.com/");
		// click "continue shopping button"
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='a-button-text']")));
		if (driver.findElement(By.xpath("//button[@class='a-button-text']")).isDisplayed()) {
			driver.findElement(By.xpath("//button[@class='a-button-text']")).click();
		}
		// create Actions class and pass driver -> Action can handle driver now
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-link-accountList")));
		// moves to specific element: building the action and then perform
		actions.moveToElement(driver.findElement(By.id("nav-link-accountList"))).build().perform();
		// search item with pressing shift keys, double click
		actions.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
		//right clicking
		actions.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).contextClick().build().perform();
	}
}
