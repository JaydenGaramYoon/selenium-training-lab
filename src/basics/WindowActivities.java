package basics;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WindowActivities {

	public static void main(String[] args) {
		//WebDriver driver = new ChromeDriver();
		//WebDriver driver = new EdgeDriver();
		WebDriver driver = new FirefoxDriver();

		driver.manage().window().maximize();
		driver.get("http://google.com");
		driver.navigate().to("https://rahulshettyacademy.com");
		driver.navigate().back();
		driver.navigate().forward();
	}
}
