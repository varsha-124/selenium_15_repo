package listbox;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ToLearnGetAllSelectedOptions {

	public static void main(String[] args) {
WebDriver driver=new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

driver.get("https://demoapp.skillrary.com/");
WebElement priceListBox = driver.findElement(By.id("cars"));

Select allSelected=new Select(priceListBox);
allSelected.selectByIndex(0);
allSelected.selectByIndex(1);
allSelected.selectByIndex(2);

List<WebElement> allSelectedOption = allSelected.getAllSelectedOptions();
System.out.println(allSelectedOption.size());
for(WebElement i:allSelectedOption) {
	System.out.println(i.getText());
	
}
	}

}
