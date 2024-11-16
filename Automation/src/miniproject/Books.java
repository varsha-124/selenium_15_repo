package miniproject;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
@Listeners(ListenerImplementation.class)
public class Books extends BaseClass{
	
	@Test
	public void testScript() {
	 wp=new WebElementPage(driver);
		wp.getBooksLink().click();
		Assert.assertEquals(driver.getTitle(),"Demo Web Shop. Books","Books page not displayed");
		Reporter.log("Books page displayed",true);
	}
	
}
