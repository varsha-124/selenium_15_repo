package listeners;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ListenerImplementationClass.class)
public class TestScript {
	@Test
	public void login() {
		Reporter.log("Launce the browser",true);
		Reporter.log("Navigate to url",true);
		Reporter.log("Click on login link",true);
		Reporter.log("Enter valid credentials",true);
		Reporter.log("Click on login button",true);
		//Assert.assertEquals(true, false);
		
		Assert.assertEquals(true, true);

}
}
