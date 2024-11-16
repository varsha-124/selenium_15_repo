package listbox;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ToLearnSingleSelect {

	public static void main(String[] args) {
WebDriver driver=new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

driver.get("https://www.facebook.com/reg/?next=%2FnopCommerce");
WebElement month = driver.findElement(By.id("month"));

Select monthSelect=new Select(month);
monthSelect.selectByIndex(10);
//monthSelect.selectByValue("11");
//monthSelect.selectByVisibleText("Nov");

WebElement year=driver.findElement(By.id("year"));

Select yearSelect=new Select(year);
//yearSelect.selectByIndex();
//yearSelect.selectByValue("1996");
yearSelect.selectByVisibleText("1996");


WebElement day=driver.findElement(By.id("day"));
Select daySelect=new Select(day);
//daySelect.selectByIndex(14);
//daySelect.selectByValue("15");
daySelect.selectByVisibleText("15");

	}

}
