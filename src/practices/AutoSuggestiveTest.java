package practices;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AutoSuggestiveTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
		JavascriptExecutor js = (JavascriptExecutor) driver;

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		// test data
		String testInput = "ko";
		// get the text box -> enter test input
		WebElement textBox = driver.findElement(By.id("autocomplete"));
		textBox.sendKeys(testInput);
		// click the suggested option : korea, republic of
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#ui-id-1 li")));
		// print out all the suggested option values
		List<WebElement> suggestedOptions = driver.findElements(By.cssSelector("#ui-id-1 li"));
		for (WebElement option : suggestedOptions) {
			//using getAttribute
			textBox.sendKeys(Keys.DOWN);
			option.findElement(By.tagName("div")).getText();
			System.out.println(textBox.getAttribute("value"));
			//using js executor
			String optionText = "return document.getElementById('autocomplete').value;";
			String returnedText = (String) js.executeScript(optionText);
			System.out.println(returnedText);
		}
	}

}
