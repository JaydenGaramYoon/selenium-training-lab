package practices;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CalenderUIHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
		// open browser
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

		// test data
		String targetMonthByText = "March";
		String targetMonthByNum = "3";
		String targetDay = "7";
		String targetYear = "2130";

		// static element
		WebElement datePicker = driver.findElement(By.className("react-date-picker"));

		// click delieveryDateInput
		datePicker.click();
		WebElement reactCalendar = driver.findElement(By.cssSelector("div[class='react-calendar']"));
		// wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy((By)
		// reactCalendar));

		// click year to open year range
		WebElement yearLbl = reactCalendar
				.findElement(By.cssSelector("button[class='react-calendar__navigation__label']"));
		// to spread years
		yearLbl.click();
		// to spread decade years
		yearLbl.click();

		// click next 2 buttons
		reactCalendar.findElement(By.cssSelector("button[class*='next2-button']")).click();

		// click target year
		reactCalendar.findElement(By.xpath("//button[text()='" + targetYear + "']")).click();

		// click target month
		// 1-by month name
//		reactCalendar.findElement(By.xpath("//button/abbr[text()='" + targetMonthByText + "']")).click();
		// 2- by months index
		List<WebElement> months = reactCalendar.findElements(By.cssSelector("button[class*='months']"));
		// index starts from 0 -> 6th month's index : 5
		months.get(Integer.parseInt(targetMonthByNum) - 1).click();
		// click the day
		if (!reactCalendar.findElement(By.xpath("//button/abbr[text()='" + targetDay + "']")).getAttribute("aria-label")
				.contains("neighboringMonth")) {
			reactCalendar.findElement(By.xpath("//button/abbr[text()='" + targetDay + "']")).click();
		}

		// get the selected date
		String selectedDay = datePicker.findElement(By.cssSelector("input[name='day']")).getAttribute("value");
		String selectedMonth = datePicker.findElement(By.cssSelector("input[name='month']")).getAttribute("value");
		String selectedYear = datePicker.findElement(By.cssSelector("input[name='year']")).getAttribute("value");
		
		// compare the output and target data
		System.out.println(selectedDay + selectedMonth + selectedYear);
		System.out.println(selectedDay.equals(targetDay) && selectedMonth.equals(targetMonthByNum)
				&& selectedYear.equals(targetYear));
		// assert
		Assert.assertEquals(selectedDay, targetDay);
		Assert.assertEquals(selectedMonth, targetMonthByNum);
		Assert.assertEquals(selectedYear, targetYear);
	}
}
