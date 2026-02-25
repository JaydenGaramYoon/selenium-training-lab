package practices;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.WebElement;

public class OptionSelectAlertInteraction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));

		// open the browser
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		// static elements
		WebElement optionSelect = driver.findElement(By.id("dropdown-class-example"));
		Select optionDropDown = new Select(optionSelect);
		WebElement textBox = driver.findElement(By.cssSelector("fieldset[class=\"pull-right\"] input[type=\"text\"]"));
		WebElement alertBtn = driver.findElement(By.id("alertbtn"));

		// get the all option inputs
		List<WebElement> optionLbls = driver.findElements(By.cssSelector("div[id='checkbox-example'] fieldset label"));
		for (WebElement optionLbl : optionLbls) {
			// clear the textBox
			textBox.clear();
			System.out.println(optionLbl.getText());
			// get the option text from label
			String optionText = optionLbl.getText();
			// click the option button
			optionLbl.findElement(By.cssSelector("input[type='checkbox']")).click();
			// click an option dropdown
			optionSelect.click();
			optionDropDown.selectByVisibleText(optionText);
			// send option text to the textbox
			textBox.sendKeys(optionText);
			// click alert button
			alertBtn.click();
			// get the text from the alert
			String alertText = driver.switchTo().alert().getText();
			// compare the formattedtext with option text
			if (alertText.contains(optionText)) {
				Assert.assertTrue(alertText.contains(optionText));
				System.out.println("formatted alert text is corresponding with the selected option text");
			}
			// accept the alert
			driver.switchTo().alert().accept();
		}
	}

}
