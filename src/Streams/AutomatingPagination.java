package Streams;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AutomatingPagination {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// test data
		String targetItem = "Apple";
		// open browser
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		// instantiate variables
		List<String> items;
		List<String> itemPrices;
		// automating the pagination
		do {
			// get displayed item elements
			List<WebElement> elementItems = driver.findElements(By.xpath("//tr/td[1]"));
			// get price of the item
			itemPrices = elementItems.stream().filter(name -> name.getText().contains(targetItem))
					.map(item -> getPrice(item)).collect(Collectors.toList());
			// check if the list has target item by using .contains()
			if (itemPrices.size() < 1) {
				// move to next page
				driver.findElement(By.cssSelector("a[aria-label='Next']")).click();
				// restart the loop
			}
		} while (itemPrices.size() < 1);
		itemPrices.forEach(price -> System.out.println(targetItem + "'s price : " + price));
	}

	public static String getPrice(WebElement item) {
		String price = item.findElement(By.xpath("following-sibling::td[1]")).getText();
		return price;
	}
}
