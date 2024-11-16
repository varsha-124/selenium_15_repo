package testng;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestScript extends BaseClass{
	@Test
	public void testScript() {
		driver.findElement(By.partialLinkText("Books")).click();
		String actualTitle=driver.getTitle();
		String expectedTitle=workbook.getSheet("Sheet1").getRow(1).getCell(7).getStringCellValue();
		if(actualTitle.equals(expectedTitle)) {
			Reporter.log("Books page is dispalyed",true);
		}
		else {
			Reporter.log("Books page is not displayed",true);
		}
	}

}
