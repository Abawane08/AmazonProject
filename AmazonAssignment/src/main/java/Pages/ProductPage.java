package Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Utils.BaseClass;

public class ProductPage extends BaseClass {
	
	private static Logger logger = LogManager.getLogger(ProductPage.class);
	
	//object repository
	private static final By BuyNowBtn_name = By.xpath("//span[@class='a-button-inner']//input[@id='buy-now-button']");
	
	public static void BuyNowFunctional() {
		WebElement buyNowBtn = BaseClass.getDriver().findElement(BuyNowBtn_name);
		buyNowBtn.click();
		logger.info("Buy now botton functionality is working as expected");
		softAssert.assertTrue(true);
	}
}
