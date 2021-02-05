package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;



public class BaseClass {
	
	private static Logger logger = LogManager.getLogger(BaseClass.class);
	public static SoftAssert softAssert = new SoftAssert();
	public static String browserName;
	public static String URL;
	public static WebDriver driver;
	private static File file;
	private static FileInputStream fileInput = null;
	public static Properties prop;

	@BeforeSuite
	public void setupDriver() {
		readPropertiesfile();
		browserName = prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", prop.getProperty("Chromedriverpath"));
			driver = new ChromeDriver();
			System.out.println("chromedriver is launched");
			logger.info("chromedriver is launched");
			
		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", prop.getProperty("FirefoxdriverPath"));
			driver = new FirefoxDriver();
			System.out.println("Firefoxdriver is launched");
			logger.info("Firefoxdriver is launched");
		}}
		
		@BeforeTest
		public void Launch() {
		
			URL = prop.getProperty("url");
			driver.get(URL);
			//Reporter.log("Ämazon Url is launched");
			System.out.println("Ämazon Url is launched");
			logger.info("Ämazon Url is launched");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			logger.info("driver loading....");
		}
		
		public void readPropertiesfile() {
			file = new File("C:/Users/DELL/eclipse-workspace/AmazonAssignment/src/main/resources/AmazonProperties/config.properties");
			try {
				fileInput = new FileInputStream(file);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			prop = new Properties();

			// load properties file
			try {
				prop.load(fileInput);
			} catch (IOException e) {
				e.printStackTrace();

			}
		}
		public static WebDriver getDriver() {
			return driver;
		}

		@AfterSuite
		public void closeDriver() {
			logger.debug("closeDriver - Attempting to close the driver");
			if (driver != null) {
				try {
					driver.quit();
					driver = null;
				} catch (Exception e) {
				}
			}
		}}

