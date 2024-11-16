package miniproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(ListenerImplementation.class)
public class Electronics extends BaseClass{
	//public WebElementPage wp;
	//public WebDriver driver;
	
	@Test
	public void testScript2() {
	wp=new WebElementPage(driver);
	wp.getElectronicsLink().click();
		//driver.findElement(By.linkText("Electronics")).click();
		Assert.assertEquals(driver.getTitle(),"Demo Web Shop. Electronics","Electronics page not displayed");
		Reporter.log("Electronics page displayed",true);
	}

}
