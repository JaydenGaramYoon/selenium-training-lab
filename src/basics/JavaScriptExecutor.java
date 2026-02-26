package basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class JavaScriptExecutor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		// instantiate Js executor
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// scroll a browser
		js.executeScript("window.scrollBy(0,500)");
		// scroll in a frame vertically
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
	}

}
