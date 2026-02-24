package basics;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WIndowHandles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
		// open child window
		driver.findElement(By.cssSelector(".blinkingText")).click();
		// get both childwindow and parentwindow as a set<String> windows = getW:
		// [parentid, childid]
		Set<String> windows = driver.getWindowHandles();
		// get the id from the set using Iterator<String> it = iterator()
		Iterator<String> window = windows.iterator();
		// it.next() : to get the first index : String parentId
		String parentWindowId = window.next();
		// it.next() again : to get the second index : String childId
		String childWindowId = window.next();
		// switch to window(the id of the target window)
		driver.switchTo().window(childWindowId);
		// get the text including emadriver.switchTo().window(childId);il from the
		// childwwindow
		System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());
		driver.findElement(By.cssSelector(".im-para.red")).getText();
		// trim the email from the text
		String emailId = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim()
				.split(" ")[0];
		// reswitch to the parent window again
		driver.switchTo().window(parentWindowId);
		// send the email into the textbox
		driver.findElement(By.id("username")).sendKeys(emailId);

	}

}
