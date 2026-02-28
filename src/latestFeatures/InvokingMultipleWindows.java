package latestFeatures;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class InvokingMultipleWindows {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		// capture a text from a browser
		driver.switchTo().newWindow(WindowType.TAB); // blank tap
		// driver.switchTo().newWindow(WindowType.WINDOW);
		Set<String> Handles = driver.getWindowHandles(); // Handle Set
		Iterator<String> currentHandle = Handles.iterator(); // currentHandle (right before the first id index)
		String parentId = currentHandle.next(); // assigning id to the tab/browser handle
		String childId = currentHandle.next();
		driver.switchTo().window(childId);
		// enter the text another browser
		driver.get("https://rahulshettyacademy.com/");
	}

}
