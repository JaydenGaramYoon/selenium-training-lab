package practices;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginToCheckout {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");

		// test data
		String name = "rahulshettyacademy";
		String password = "Learning@830$3mK2";
		String role = "user";
		String status = "Consultant";
		boolean consent = true;
		String location = "Toronto";
		String message = "success";

		// login to the website
		login(driver, wait, name, password, role, status, consent);

		// add items into the cart
		addItems(driver, wait);

		// go to checkout page
		goToCheckOut(driver);

		// proceed to checkout
		checkOut(driver, location);
	
		//check submission
		checkSubmission(driver, message);
	}

	public static void login(WebDriver driver, WebDriverWait wait, String name, String password, String role,
			String status, boolean consent) {
		driver.findElement(By.id("username")).sendKeys(name);
		driver.findElement(By.id("password")).sendKeys(password);
		List<WebElement> radioBtns = driver.findElements(By.cssSelector("label.customradio"));
		for (WebElement radioBtn : radioBtns) {
			String radioBtnText = radioBtn.findElement(By.cssSelector("span.radiotextsty")).getText();
			if (radioBtnText.equalsIgnoreCase(role)) {
				radioBtn.click();
				Assert.assertTrue(radioBtn.findElement(By.cssSelector("input[type='radio']")).isSelected());
				break;
			}
		}
		// handle terms and condition modal
		handleModal(driver, wait, consent);
		WebElement statusDropDowns = driver.findElement(By.cssSelector("select.form-control"));
		Select statusDropDown = new Select(statusDropDowns);
		statusDropDown.selectByVisibleText(status);
		driver.findElement(By.id("terms")).click();
		Assert.assertTrue(driver.findElement(By.id("terms")).isSelected());
		driver.findElement(By.id("signInBtn")).click();
	}

	public static void handleModal(WebDriver driver, WebDriverWait wait, boolean consent) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
		if (consent) {
			driver.findElement(By.id("okayBtn")).click();
		} else {
			driver.findElement(By.id("cancelBtn")).click();
		}
	}

	public static void addItems(WebDriver driver, WebDriverWait wait) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.btn-info")));
		List<WebElement> addBtns = driver.findElements(By.cssSelector("button.btn-info"));
		for (WebElement addBtn : addBtns) {
			addBtn.click();
		}
	}

	public static void goToCheckOut(WebDriver driver) {
		driver.findElement(By.className("btn-primary")).click();
	}

	public static void checkOut(WebDriver driver, String location) {
		driver.findElement(By.cssSelector("button.btn-success")).click();
		driver.findElement(By.id("country")).sendKeys(location);
		driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
	}
	
	public static void checkSubmission(WebDriver driver, String message) {
		if(driver.findElement(By.className("alert-success")).getText().equalsIgnoreCase(message)) {
			Assert.assertTrue(driver.findElement(By.className("alert-success")).getText().equalsIgnoreCase(message));
		}
	}
}
