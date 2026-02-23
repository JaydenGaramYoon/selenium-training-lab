package elements;

import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CheckBoxes2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		// A.Check the first Checkbox and verify if it is successfully checked and
		// Uncheck it again to verify if it is successfully Unchecked
		WebElement chkBoxOne = driver.findElement(By.id("checkBoxOption1"));
		// 1.Check and assert true
		chkBoxOne.click();
		Assert.assertTrue(chkBoxOne.isSelected());
		// 2.Uncheck and assert false
		Thread.sleep(2000);
		chkBoxOne.click();
		Assert.assertFalse(chkBoxOne.isSelected());

		// B.How to get the Count of number of check boxes present in the page
		// 1. get the checkboxes
		System.out.println(driver.findElements(By.cssSelector("div[id*='checkbox'] fieldset label")).size());
	}

}
