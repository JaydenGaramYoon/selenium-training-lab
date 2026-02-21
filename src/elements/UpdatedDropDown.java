package elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class UpdatedDropDown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		int totalPassengers = 6;
		//1.Open the browser
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		//2.Click the element where dropdown is
		driver.findElement(By.id("divpaxinfo")).click();
		//3.Click the + button to increment the passengers
		Thread.sleep(2000);
		for(int i = 1; i < totalPassengers; i++ ) //required passenger number: 6
		{
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		//4.Check if the incremented total passenger number equals with the expected number
		Assert.assertEquals(Integer.parseInt(driver.findElement(By.id("divpaxinfo")).getText().split(" ")[0]), totalPassengers);
		//5.Close the browser
		driver.findElement(By.id("btnclosepaxoption"));
	}

}
