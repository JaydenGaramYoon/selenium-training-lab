package practices;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddingItemsIntoCart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//how to get the text of an element using xpath: //tagname[text()='']
		//how to change array to arrayList: Arrays.asList(array);
		//products to add
		String [] testProducts= {"Brocolli", "Pomegranate", "Walnuts"};
		//open browser
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		//compare the productName with testProduct
		List<WebElement> productList = driver.findElements(By.cssSelector("div.products div.product"));
		for (WebElement product : productList) {
			String[] productName = product.findElement(By.cssSelector("h4.product-name")).getText().split("-");
			String trimmedProductName = productName[0].trim();
			WebElement button = product.findElement(By.cssSelector("div.product-action button"));
			//change array to arrayList
			List<String> testProductsList = Arrays.asList(testProducts);
			//check if the productName is same with testProductName
			if(testProductsList.contains(trimmedProductName))
			{
				//click the button
				button.click();
			}
		}
		
	}

}
