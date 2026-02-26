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
		WebElement table = driver.findElement(By.xpath("//table[@name=\"courses\"]"));
		//get the number of rows
		List <WebElement> rows = table.findElements(By.tagName("tr"));
		System.out.println("Table has " + rows.size() + " row(s)");
		//get the number of columns
		int rowNum = 0;
		for(WebElement row : rows) {
			rowNum = rowNum + 1;
			List <WebElement> columns = row.findElements(By.tagName("td"));
			int columnNum = 0;
			for (WebElement column: columns) {
				columnNum = columnNum + 1;
			}
			System.out.println("Row " + rowNum + " has " + columnNum + " column(s)");
		}
		//get the second row values
		List <WebElement> cellsInSecondRow = table.findElements(By.cssSelector("tr:nth-child(3) td"));
		for(WebElement cell : cellsInSecondRow) {
			System.out.println(cell.getText());
		}
	}

}
