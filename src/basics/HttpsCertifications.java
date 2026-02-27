package basics;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class HttpsCertifications {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//below helps to automatically handle the browser security certifications
		ChromeOptions options = new ChromeOptions();
		FirefoxOptions options1 = new FirefoxOptions();
		EdgeOptions options2 = new EdgeOptions();
		
		options.setAcceptInsecureCerts(true);
		options1.setAcceptInsecureCerts(true);
		options2.setAcceptInsecureCerts(true);
		
		//initially open browser has no plugins, and etc.
		//add extension(plugin) - options.addExtensions(fileLocation);
		//options.method(key, value)
		//set proxy class first 
		Proxy proxy = new Proxy();
		//set a specific proxy
		proxy.setHttpProxy("ipadress:4444");
		//set proxy using : options.setCapability("prox", value);
		options.setCapability("proxy", proxy);
		//block pop-up windows
		//options.setExperimentalOption("excluseSwitches", Array.asList("disable-popup-blocking"));
		//download the file with setting the default download directory
		Map<String, Object> prefs = new HashMap <String,Object>();
		prefs.put("download.default_directory", "/directory/path"); //key, value pair
		options.setExperimentalOption("prefs", prefs);
		//pass the options value to the browser
		WebDriver driver = new ChromeDriver(options);
		WebDriver driver1 = new FirefoxDriver(options1);
		WebDriver driver2 = new EdgeDriver(options2);
		
		driver.get("https://expired.badssl.com/");
		driver1.get("https://expired.badssl.com/");
		driver2.get("https://expired.badssl.com/");

	}

}
