package elements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestive {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String searchInput = "ind";
		String targetCountry = "India";
		// 1.Open the browser
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		// 2.Enter the required search input in the search field
		driver.findElement(By.id("autosuggest")).sendKeys(searchInput);
		// 3.Get a list of three auto-suggested engines
		Thread.sleep(2000);
		List<WebElement> suggestedCountries = driver.findElements(By.cssSelector("li[class=\"ui-menu-item\"] a"));
		// 4.Click a suggestion that matches with the target country
		for (WebElement suggestedCountry : suggestedCountries) {
			if (suggestedCountry.getText().equalsIgnoreCase(targetCountry)) {
				suggestedCountry.click();
				break;
			}
		}
	}

}
