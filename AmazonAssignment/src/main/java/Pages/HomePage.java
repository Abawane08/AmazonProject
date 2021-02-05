package Pages;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import Utils.BaseClass;
import Utils.ExcelUtils;



public class HomePage extends BaseClass {
	private static Logger logger = LogManager.getLogger(HomePage.class);
	
	//object repository
	private static final By SearchField_xpath = By.xpath("//*[@id='twotabsearchtextbox']");
	private static final By SearchBtn_xpath = By.xpath("//input[@id='nav-search-submit-button']");
	
			
	public static void PageTitle() {
		String ExpectedTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";	
		String ActualTitle= driver.getTitle();
		//System.out.println(ActualTitle);
		logger.info("Actual Page Title is:" +ActualTitle);
		softAssert.assertEquals(ActualTitle, ExpectedTitle);
	}
	
		
	public static void SearchFunctional() throws IOException {
//		String SearchProduct_Expected = ExcelUtils.getExcelValue("Sheet1", "SearchProductName","Value");
//		System.out.println("SearchProduct_Expected" +SearchProduct_Expected);
		
		WebElement SearchField = BaseClass.getDriver().findElement(SearchField_xpath);
		SearchField.sendKeys("iPhone 12");
		
		WebElement SearchButton = BaseClass.getDriver().findElement(SearchBtn_xpath);
		SearchButton.click();
		
		
	}
}
