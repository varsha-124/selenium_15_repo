package miniproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(ListenerImplementation.class)
public class GiftCards extends BaseClass{
	//public WebElementPage wp;
	//public WebDriver driver;
	
	@Test
	public void testScript3() {
		wp=new WebElementPage(driver);
		wp.getGiftCardsLink().click();
		//driver.findElement(By.linkText("Gift Cards")).click();
		Assert.assertEquals(driver.getTitle(),"Demo Web Shop.","GiftCards page not displayed");
		Reporter.log("GiftCards page displayed",true);
	}

}
