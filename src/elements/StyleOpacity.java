package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class StyleOpacity {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		// default state: one way - selected, return date opacity - 0.5
		// when round trip checked: round trip - selected, return date opacity - 1
		// when one way checked: one way - selected, return date opacity - 0.5

		// 1.get the test buttons and the opacity of return date
		// note: return date style is dynamic value. non-static;
		WebElement rbtnOneWay = driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0"));
		WebElement rbtnRoundTrip = driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1"));
		// 2.validate default states
		rbtnOneWay.click();
		if (driver.findElement(By.id("Div1")).getDomAttribute("style").contains("0.5")) {
			Assert.assertTrue(true);
			rbtnRoundTrip.click();
			Thread.sleep(3000);
			if (driver.findElement(By.id("Div1")).getDomAttribute("style").contains("1")) {
				Assert.assertTrue(true);
				rbtnOneWay.click();
				Thread.sleep(3000);
				if (driver.findElement(By.id("Div1")).getDomAttribute("style").contains("0.5")) {
					Assert.assertTrue(true);
				} else {
					Assert.assertTrue(false, "default return date opacity didn't revert to 0.5");
				}
			} else {
				Assert.assertTrue(false, "return date opacity didn't change to 1");
			}
		} else {
			Assert.assertTrue(false, "default return date opacity is not 0.5");
		}
	}

}
