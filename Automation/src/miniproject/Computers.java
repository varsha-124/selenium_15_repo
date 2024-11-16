package miniproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import assertion.SoftAssert;
@Listeners(ListenerImplementation.class)
public class Computers extends BaseClass{
	//public WebElementPage wp;
	//public WebDriver driver;
	
	@Test
	public void testScript1() {
		wp=new WebElementPage(driver);
		wp.getComputersLink().click();
		//driver.findElement(By.linkText("Computers")).click();
		Assert.assertEquals(driver.getTitle(),"Demo Web Shop.","Computers page not displayed");
		Reporter.log("Computers page displayed",true);
	}

}
