package basics;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;

public class Miscellaneous {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		// maximizing window before redirecting to the address
		driver.manage().window().maximize();
		driver.get("http://google.com");
		// deleting all the cookies - to block elements pre-populating
		driver.manage().deleteAllCookies();
		// deleting only one cookie
//		driver.manage().deleteCookieNamed("abc");
//		// when delete sessions id or cookies, session should logout(sometimes)
//		driver.manage().deleteCookieNamed("sessionKey");
		//taking screenshots
		//casting the driver first
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		//get the file - but browser cannot access to the C driver
		FileUtils.copyFile(src, new File("C:\\Users\\rkfka\\screenshot.png"));
	}

}
