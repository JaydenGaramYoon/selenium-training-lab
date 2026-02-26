package practices;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTablesHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		//get the table
		WebElement table = driver.findElement(By.xpath("//table[@name='courses']"));
		//get the number of rows
		System.out.println(table.findElements(By.xpath(".//tr")).size());
		//get the number of columns
		System.out.println(table.findElements(By.xpath(".//tr/th")).size());
		//get the second row values
		List <WebElement> cellsInSecondRow = table.findElements(By.cssSelector("tr:nth-child(3) td"));
		for(WebElement cell : cellsInSecondRow) {
			System.out.println(cell.getText());
		}
	}

}
