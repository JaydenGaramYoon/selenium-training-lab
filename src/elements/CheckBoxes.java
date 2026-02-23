package elements;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

//TestNG is one of the testing framework
public class CheckBoxes {

	public static void main(String[] args) throws InterruptedException {
		String searchInput = "ind";
		String targetCountry = "India";
		// 1.Open the browser
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		// 2. Select a checkbox
		System.out.println(driver.findElement(By.cssSelector("input[id*='Student']")).isSelected());
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='Student']")).isSelected());
		driver.findElement(By.cssSelector("input[id*='Student']")).click();
		System.out.println(driver.findElement(By.cssSelector("input[id*='Student']")).isSelected());
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='Student']")).isSelected());

		// 3. Count total checkboxes
		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
	}
}