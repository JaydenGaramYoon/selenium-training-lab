package basics;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;

public class SelIntroduction {

	public static void main(String[] args) {
		// Invoking Browser
		//Chrome - ChromeDriver(class) has methods to automate the chrome browser
		//All browser have the same methods across the browsers
		//But needs WebDriver to use the same methods that the browsers have
		//WebDriver: interface, a group of related methods with empty bodies; all the browserdrivers agreed with this interface
		//WebDriver: interface for the methods' name = blueprint
		//Browsers: takes the implementation for the methods = actual body
		//1. Create the object the class
		//Browsers don't just implement WebDriver, they implement their own class methods
		//an object initialized in the WebDriver interface can access to all the methods of ChromeDriver
		//BrowserDrivers have methods that can implement the methods that are in the WebDriver interface.
		//WebDriver Interface's methods are empty. So, BrowserDrivers can implement the methods in the WebDriver interface.
		//		리모컨
		//		= WebDriver 인터페이스
		//
		//		TV 내부 시스템
		//		= ChromeDriver + 브라우저 엔진
		// => polymorphism
		// 동일한 테스트 코드를 유지함으로써 유지보수 비용을 줄인다.
		//새로운 브라우저를 쉽게 추가할 수 있어 확장성이 높다.
		//
		//W3C 표준을 따르기 때문에 구조가 표준화되어 있다.
		//
		//여러 브라우저에서 동시에 실행할 수 있어 실행 시간이 단축된다.
		//
		//TestNG, JUnit, CI/CD 도구와 쉽게 통합된다.
		//
		//대규모 프로젝트와 기업 환경에 적합하다.
		//Start by invoking Chromedriver.exe
		//or manually invoke chromedriver.exe. why?
//		자동이 되는데 왜 수동 방식을 알아야 하냐면,
//
//		회사 보안 정책 때문에 자동 다운로드가 막힐 수 있고
//
//		CI/CD 환경에서 드라이버 버전을 고정해야 할 수 있고
//
//		특정 브라우저 버전으로 테스트해야 하는 경우가 있고
//
//		드라이버 문제를 디버깅할 때 직접 통제가 필요하기 때문이야
//
//		정리하면,
//
//		자동은 편리하고
//		수동은 통제 가능하다.
		//System.setProperty("webdriver.chrome.driver", "C:/Users/rkfka/Documents/Job/Certifications/Selenium/chromedriver.exe");
		//WebDriver driver = new ChromeDriver();//Chromebrowser will be automatically invoked by Selenium manger.
		
		//Firefox Launch
		//geckodriver invokes firefox browser
		
//		WebDriver driver = new FirefoxDriver();
//		System.setProperty("webdriver.gecko.driver", "C:/Users/rkfka/Documents/Job/Certifications/Selenium/geckodriver.exe");
		
		//msdriver
		WebDriver driver = new EdgeDriver();
		System.setProperty("webdriver.gecko.driver", "C:/Users/rkfka/Documents/Job/Certifications/Selenium/msedgedriver.exe");
		
		driver.get("https://unistyle-main.onrender.com/");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.close(); //close only the current open browser
		driver.quit(); //close all related/associated browser
	}

}
