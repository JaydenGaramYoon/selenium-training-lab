package elements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class e2e {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		int totalPassengers = 6;
		// 1.Open the browser
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		// check the trip
		WebElement rbtnOneWay = driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0"));
		rbtnOneWay.click();
		if (driver.findElement(By.id("Div1")).getDomAttribute("style").contains("0.5")) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
		// 2.Click a country in 'From'
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@value='BHO']")).click();
		// 3.Click a destination in 'To'
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
		// 4.choose a departure date
		driver.findElement(By.id("ctl00_mainContent_view_date1")).click();
		Thread.sleep(1000);
		List<WebElement> dates = driver.findElements(By.cssSelector("a[class=\"ui-state-default\"]"));
		for (WebElement date : dates) {
			if (date.getText().equalsIgnoreCase("8")) {
				date.click();
				break;
			}
		}
		// 5.Click the passengers
		Thread.sleep(1000);
		driver.findElement(By.id("divpaxinfo")).click();
		// 6.Click the + button to increment the passengers
		Thread.sleep(2000);
		for (int i = 1; i < totalPassengers; i++) // required passenger number: 6
		{
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		// 7.Check if the incremented total passenger number equals with the expected
		// number
		Assert.assertEquals(Integer.parseInt(driver.findElement(By.id("divpaxinfo")).getText().split(" ")[0]),
				totalPassengers);
		// 9.Create an object to save the element where Currency is
		Thread.sleep(2000);
		WebElement dropDownListCurrency = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		// 10.Create Select object for the element
		dropDownListCurrency.click();
		Select dropDownCurrency = new Select(dropDownListCurrency);
		// The argument in new Select() should be the <select> tag that has <option> as
		// child.
		// 11. Select the object by index
		Thread.sleep(1000);
		dropDownCurrency.selectByIndex(3);
		// 12. Select a checkbox
		System.out.println(driver.findElement(By.cssSelector("input[id*='Student']")).isSelected());
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='Student']")).isSelected());
		driver.findElement(By.cssSelector("input[id*='Student']")).click();
		System.out.println(driver.findElement(By.cssSelector("input[id*='Student']")).isSelected());
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='Student']")).isSelected());
		// 13. submit
		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
	}

}
