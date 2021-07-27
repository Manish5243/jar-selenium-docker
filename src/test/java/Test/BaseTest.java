package Test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
	
	protected WebDriver driver;
	
	
	@BeforeTest
	public void setupDriver() throws MalformedURLException {
		
		String host = "localhost";
		DesiredCapabilities dc;
		
		if(System.getProperty("BROWSER") != null && System.getProperty("BROWSER").equalsIgnoreCase("firefox")) {
			dc = DesiredCapabilities.firefox();
		}
		else {
			dc = DesiredCapabilities.chrome();
		}
		
		if(System.getProperty("HUB_HOST") != null) {
			host = System.getProperty("HUB_HOST");
		}
		
		//System.setProperty("webdriver.chrome.driver", "H:/DSandALGO/Selenium/chromedriver_win32/chromedriver.exe");
		//this.driver = new ChromeDriver();
		
		String completeUrl = "http://" +host+ ":4444/wd/hub";
		this.driver = new RemoteWebDriver(new URL(completeUrl), dc);
		
		driver.manage().window().maximize();
	}
	
	
	@AfterTest
	public void closeDriver() {
		driver.quit();
	}
}
