package practices;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.openqa.selenium.support.ui.Select;

public class FormSubmission {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		//test data
		String name = "garam";
		String email = "garam@gmail.com";
		String password = "garam123";
		String targetGender = "Female";
		String targetEmploymentStatus = "Employed";
		String dateOfBirth = "3111998";
		String successMessage = "Success! The Form has been submitted successfully!.";
		//enter name
		driver.findElement(By.cssSelector("div[class=\"form-group\"] input[name=\"name\"]")).sendKeys(name);
		//enter email
		driver.findElement(By.cssSelector("div[class=\"form-group\"] input[name=\"email\"]")).sendKeys(email);
		//enter password
		driver.findElement(By.id("exampleInputPassword1")).sendKeys(password);
		//check checkbox
		driver.findElement(By.id("exampleCheck1")).click();
		Assert.assertTrue(driver.findElement(By.id("exampleCheck1")).isSelected());
		//select a gender
		WebElement genders = driver.findElement(By.id("exampleFormControlSelect1"));
		Select gender = new Select(genders);
		gender.selectByContainsVisibleText(targetGender);
		//click a radio button
		List<WebElement> empDivs = driver.findElements(By.xpath("//div[@class=\"form-check form-check-inline\"]"));
		System.out.println(empDivs.size());
		for (WebElement empDiv : empDivs) {
			if(empDiv.findElement(By.xpath("./label")).getText().equalsIgnoreCase(targetEmploymentStatus)) {
				System.out.println(empDiv.findElement(By.xpath("./label")).getText());
				empDiv.findElement(By.xpath("./input")).click();
				Assert.assertTrue(empDiv.findElement(By.xpath("./input")).isSelected());
			}
		}
		//enter date of birth
		driver.findElement(By.cssSelector("input[name=\"bday\"]")).sendKeys(dateOfBirth);
		//click submit button
		driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
		//check the form submission message
		Thread.sleep(2000);
		if(driver.findElement(By.className("alert")).getText().contains(successMessage)){
			Assert.assertTrue(true);
			System.out.println(driver.findElement(By.className("alert")).getText());
		}
		else {
			Assert.assertTrue(false);
		}
	}
}
