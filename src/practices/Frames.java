package practices;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/nested_frames");
		// get the frames
		// count framesets : 1
		System.out.println(driver.findElements(By.tagName("frameset")).size());
		// count frames inside the frameset
		System.out.println(driver.findElements(By.cssSelector("frameset frame")).size());
		
		//1st way: hard-coding
		driver.switchTo().frame("frame-top");
		driver.switchTo().frame("frame-middle");
		System.out.println(driver.findElement(By.id("content")).getText());
		
		//get out from the middle frame to the first frameset
		driver.switchTo().defaultContent();
		driver.switchTo().defaultContent();
		
		// 2nd way: accessing the target by looping through the frames
		List<WebElement> frames = driver.findElements(By.cssSelector("frameset frame"));
		for (WebElement frame : frames) {
			System.out.println(frame.getAttribute("name"));
			if (frame.getAttribute("name").contains("frame-top")) {
				driver.switchTo().frame(frame);
				System.out.println(driver.findElements(By.cssSelector("frameset frame")).size());
				List<WebElement> innerFrames = driver.findElements(By.cssSelector("frameset frame"));
				for (WebElement innerFrame : innerFrames) {
					if (innerFrame.getAttribute("name").contains("frame-middle")) {
						driver.switchTo().frame(innerFrame);
						System.out.println(driver.findElement(By.id("content")).getText());
						break;
					}
				}
				break;
			}
		}
	}

}
