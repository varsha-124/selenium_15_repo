package listbox;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ToSelectMonth {

	public static void main(String[] args) {
WebDriver driver=new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

driver.get("https://www.facebook.com/reg/?next=%2FnopCommerce");
WebElement month = driver.findElement(By.id("month"));

Select monthSelect=new Select(month);
List<WebElement> allSelectedOption = monthSelect.getOptions();
System.out.println(allSelectedOption.size());

/*for(int i=0;i<=allSelectedOption.size();i++) {
monthSelect.selectByIndex(i);
String text=allSelectedOption.get(i).getText();
monthSelect.selectByVisibleText(text);
}*/

for(WebElement i:allSelectedOption) {
	monthSelect.selectByVisibleText(i.getText());
	if(i.isSelected()) {
		System.out.println(i.getText()+"--->Selected");
	}

}


	}

}
