package baseClasses;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	public static WebDriver driver;
	
	//Constructor to initialize the variables
			public TestBase(){
				
			}

			public static void initialization() {
				String browserVersion = "initVal";
				String browserName = "chrome";
			
				if(browserName.equals("chrome")){
					HashMap<String, Object> chromePref = new HashMap<>();
					chromePref.put("profile.default_content_settings.popups", 0);
					chromePref.put("download.default_directory", System.getProperty("user.dir")+ File.separator + "tempDownloads");
					WebDriverManager.chromedriver().setup();
					ChromeOptions options = new ChromeOptions();
					options.setExperimentalOption("prefs", chromePref);
					options.addArguments("start-maximized");
					options.addArguments("--disable-gpu");
					options.setProxy(null);
					options.setPageLoadStrategy(PageLoadStrategy.NONE);
					DesiredCapabilities cap = DesiredCapabilities.chrome();
					cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
					cap.setCapability(ChromeOptions.CAPABILITY, options);
					

					
						//System.setProperty("webdriver.chrome.driver", filePath.concat(prop.getProperty("chromeExeLoc")))
					
					
					driver = new ChromeDriver(options);
					browserVersion = cap.getVersion();
				}
				
				driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.get("https://www.google.com");
			}

	
}