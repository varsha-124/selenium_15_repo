package popups;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class javaScriptPopUp {

	public static void main(String[] args) {
WebDriver driver=new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));

	driver.get("https://demowebshop.tricentis.com/");
	driver.findElement(By.xpath("//input[@value='Search']")).click();
	
	Alert popup=driver.switchTo().alert();
	String popMsg = popup.getText();
	System.out.println(popMsg);
	popup.accept();
	}

}
