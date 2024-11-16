package crossbrowser;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestScriptDemoSkillrary extends BaseClassDemoSKillrary {
	@Test
	public void salesLink() {
		driver.findElement(By.xpath("//span[text()='Sales']")).click();
		
		Assert.assertEquals(driver.findElement(By.xpath("//h1[contains(text(),'Sales History')]")).isDisplayed(), true);
		
		Reporter.log("User is able to click on Sales link successfully",true);

		
	}

}
