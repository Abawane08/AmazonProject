package Pages;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;


import Utils.BaseClass;

public class SearchPage extends BaseClass {
	
	private static Logger logger = LogManager.getLogger(SearchPage.class);	
	static JavascriptExecutor js = (JavascriptExecutor) driver;

    //private static final By SelectediPhone_xpath = By.xpath("//img[@alt='New Apple iPhone 12 (128GB) - Blue']");
	private static final By SelectediPhone_xpath = By.xpath("//*[text()='New Apple iPhone 12 (128GB) - Blue']");

	public static void ProductSelection() throws InterruptedException {
		WebElement iPhoneSelected = BaseClass.getDriver().findElement(SelectediPhone_xpath);
		js.executeScript("arguments[0].scrollIntoView();", iPhoneSelected);		
		softAssert.assertEquals(iPhoneSelected.getText(), "New Apple iPhone 12 (128GB) - Blue");
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		iPhoneSelected.click();
		logger.info("Product is selected");
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		logger.info("New tab is launched");
		

	}
}