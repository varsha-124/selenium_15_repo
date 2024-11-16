package demoappskillrary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestScript extends BaseClass{
	@Test
	public void demoApp() {
		driver.findElement(By.linkText("Sales")).click();
		String actualText = driver.findElement(By.xpath("//h1[contains(text(),'Sales History')]")).getText();
		String expectedText=workbook.getSheet("Sheet1").getRow(1).getCell(7).getStringCellValue();
		if(actualText.contains(expectedText)){
			Reporter.log("Sales History is displayed",true);
		}
		else {
			Reporter.log("Sales History is not displayed",true);
		}
	}

}
