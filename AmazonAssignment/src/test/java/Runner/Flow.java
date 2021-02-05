package Runner;
import java.io.IOException;

import org.testng.annotations.Test;

import Utils.BaseClass;

public class Flow extends BaseClass {
	
	@Test
	public static void demo1() throws InterruptedException, IOException {
		Pages.HomePage.PageTitle();
		System.out.println("page title verified");
		
		Pages.HomePage.SearchFunctional();
		System.out.println("Search functionality is verified");
		
		Pages.SearchPage.ProductSelection();
		System.out.println("Product selection functionality is verified");
		
		Pages.ProductPage.BuyNowFunctional();
		System.out.println("buy Now button functionality is verified");

	}
	

}
