package p;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ToSelectLastOptionOfYearDropdown {

	public static void main(String[] args) {
WebDriver driver=new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

driver.get("https://www.facebook.com/reg/?next=%2FnopCommerce");

WebElement yearOption=driver.findElement(By.id("year"));
Select selectedYearOption=new Select(yearOption);
List<WebElement> allSelectedYearOption = selectedYearOption.getOptions();
System.out.println(allSelectedYearOption.size());
selectedYearOption.selectByIndex(119);


/*for(WebElement i:allSelectedYearOption) {
	selectedYearOption.selectByIndex(119);
}*/





	}
}


