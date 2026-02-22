package elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StaticDropdown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1.Open the browser
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		//2.Create an object to save the element where the dropdown is
		WebElement dropDownListCurrency = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		//3.Create Select object for the element
		Select dropDownCurrency = new Select(dropDownListCurrency);
		// The argument in new Select() should be the <select> tag that has <option> as child.
		//4. Select the object by index
		dropDownCurrency.selectByIndex(3);
		//Check the selected value
		System.out.println(dropDownCurrency.getFirstSelectedOption().getText());
		//4-2. Select the object by text
		dropDownCurrency.selectByVisibleText("AED");
		//Check the selected value
		System.out.println(dropDownCurrency.getFirstSelectedOption().getText());
		//4-3. Select the object by value
		dropDownCurrency.selectByValue("USD");
		//Check the selected value
		System.out.println(dropDownCurrency.getFirstSelectedOption().getText());

	}

}
