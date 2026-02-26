package basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TableGrids {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		// get nth column in a table => By.cssSelector(td:nth-child(index))
		List<WebElement> lastColumn = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		// add all values in the last column
		int sum = 0;
		for (WebElement rowInLastColumn : lastColumn) {
			System.out.println(Integer.parseInt(rowInLastColumn.getText()));
			sum = sum + Integer.parseInt(rowInLastColumn.getText());
			System.out.println(sum);
		}
		// compare sum with number from the screen
		int total = Integer.parseInt(driver.findElement(By.className("totalAmount")).getText().split(":")[1].trim());
		Assert.assertEquals(total, sum);
	}

}
