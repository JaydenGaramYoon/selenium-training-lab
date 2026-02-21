package basics;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Locators2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String name = "garam";
		
		System.setProperty("webdriver.chrome.driver", "C:/Users/rkfka/Documents/Job/Certifications/Selenium/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String pwd = getPassword(driver);

		//synchronize the codes
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys(name);
		driver.findElement(By.name("inputPassword")).sendKeys(pwd);
		driver.findElement(By.className("submit")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.tagName("p")).getText();
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class=\"login-container\"]/h2")).getText(),"Hello " + name + ",");
		driver.findElement(By.xpath("//button[text()='Log Out']")).click();
	}
	
	public static String getPassword(WebDriver driver) throws InterruptedException {
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		String passwordText = driver.findElement(By.xpath("//p[@class=\"infoMsg\"]")).getText();
		String pwd = passwordText.split("'")[1].split("'")[0];

		return pwd;
	}

}
