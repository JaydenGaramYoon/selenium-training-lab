package stream;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SortingWebTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// variables
		List<String> sortedOriginalNameTexts;
		List<String> afterClickNameTexts;
		
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

		driver.findElement(By.id("page-menu")).click();
		Select pageSizeSelect = new Select(driver.findElement(By.id("page-menu")));
		pageSizeSelect.selectByValue("20");
		
		//click the sorting header
		WebElement sortingHeader = driver.findElement(By.xpath("//th[@role='columnheader'][1]"));
		List<WebElement> originalNames = driver.findElements(By.cssSelector("tr td:nth-child(1)"));
		Stream<WebElement> originalStreamNames = originalNames.stream();
		sortedOriginalNameTexts = originalStreamNames.map(name->name.getText()).sorted().collect(Collectors.toList());
	
		sortingHeader.click();
		wait.until(ExpectedConditions.attributeToBe(sortingHeader, "aria-sort", "descending"));
		System.out.println(sortingHeader.getAttribute("aria-sort"));
	
		List<WebElement> afterClickNames = driver.findElements(By.cssSelector("tr td:nth-child(1)"));
		Stream<WebElement> afterClickStreamNames = afterClickNames.stream();
		afterClickNameTexts = afterClickStreamNames.map(name->name.getText()).collect(Collectors.toList());
		Assert.assertEquals(afterClickNameTexts, sortedOriginalNameTexts);
	}

}
