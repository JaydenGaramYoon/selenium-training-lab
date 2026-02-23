package practices;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FormSubmission {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		// test data
		String name = "garam";
		String email = "garam@gmail.com";
		String password = "garam123";
		String targetGender = "Female";
		String targetEmploymentStatus = "Employed";
		String dateOfBirth = "3111998";
		String successMessage = "Success! The Form has been submitted successfully!.";
		// enter name
		driver.findElement(By.cssSelector("div[class=\"form-group\"] input[name=\"name\"]")).sendKeys(name);
		// enter email
		driver.findElement(By.cssSelector("div[class=\"form-group\"] input[name=\"email\"]")).sendKeys(email);
		// enter password
		driver.findElement(By.id("exampleInputPassword1")).sendKeys(password);
		// check checkbox
		WebElement exCheckBox = driver.findElement(By.id("exampleCheck1"));
		exCheckBox.click();
		Assert.assertTrue(exCheckBox.isSelected());
		// select a gender
		WebElement genderSelect = driver.findElement(By.id("exampleFormControlSelect1"));
		Select genderOption = new Select(genderSelect);
		genderOption.selectByContainsVisibleText(targetGender);
		// click a radio button
		List<WebElement> empOptGroup = driver.findElements(By.xpath("//div[@class=\"form-check form-check-inline\"]"));
		System.out.println(empOptGroup.size());
		for (WebElement empOptDiv : empOptGroup) {
			String empLblText = empOptDiv.findElement(By.xpath("./label")).getText();
			if (empLblText.equalsIgnoreCase(targetEmploymentStatus)) {
				System.out.println(empLblText);
				WebElement empRadioBtn = empOptDiv.findElement(By.xpath("./input"));
				empRadioBtn.click();
				Assert.assertTrue(empRadioBtn.isSelected());
				break;
			}
		}
		// enter date of birth
		driver.findElement(By.cssSelector("input[name=\"bday\"]")).sendKeys(dateOfBirth);
		// click submit button
		driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
		// wait until alert appears
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement alert = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert")));
		// check the form submission message
		if (driver.findElement(By.className("alert")).getText().contains(successMessage)) {
			Assert.assertTrue(true);
			System.out.println(driver.findElement(By.className("alert")).getText());
		} else {
			Assert.assertTrue(false);
		}

		driver.quit();
	}
}
