package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class FramesTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		driver.get("https://jqueryui.com/droppable/");
		// tell selenium that there is/are frame: iframe
		System.out.println(driver.findElements(By.tagName("iframe")).size());
		// enter into the frame
		// 1.passing iframe id or 2. or the locator
		// manually
		// driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));
		// using index
		driver.switchTo().frame(0);
		// drag and drop -using Actions
		Actions action = new Actions(driver);
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));

		action.dragAndDrop(source, target).build().perform();
		// for any other actions outside of the frame
		driver.switchTo().defaultContent();
	}

}
