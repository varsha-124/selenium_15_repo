package listbox;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ToLearnGetFirstSelectedOption {

	public static void main(String[] args) {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	
	driver.get("https://demoapp.skillrary.com/");
	
	WebElement priceListBox = driver.findElement(By.id("cars"));
	Select selectedOption=new Select(priceListBox);
	selectedOption.selectByIndex(0);
	selectedOption.selectByIndex(1);
	selectedOption.selectByIndex(2);
	selectedOption.selectByIndex(3);
	
	WebElement selectedOption1 = selectedOption.getFirstSelectedOption();

	System.out.println(selectedOption1.getText());

	}

}
