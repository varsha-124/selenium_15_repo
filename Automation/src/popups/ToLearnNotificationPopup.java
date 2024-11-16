package popups;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ToLearnNotificationPopup {

	public static void main(String[] args) {
ChromeOptions option=new ChromeOptions();
option.addArguments("--disable-notifications");

WebDriver driver=new ChromeDriver(option);
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

driver.get("https://www.myntra.com/");
driver.findElement(By.partialLinkText("MEN")).click();
	}

}
