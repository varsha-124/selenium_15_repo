package p;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.logging.FileHandler;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Shopperstack {

	public static void main(String[] args) throws IOException {
WebDriver driver=new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
String time=LocalDateTime.now().toString().replace(":", "-");

driver.get("https://www.shoppersstack.com/products_page/23");
driver.findElement(By.id("compare")).click();

Set<String> allWindowIds = driver.getWindowHandles();
for(String id:allWindowIds) {
	driver.switchTo().window(id);
	String url = driver.getCurrentUrl();
	if(url.contains("amazon")) {
		break;
	}
}
Actions act=new Actions(driver);
act.scrollByAmount(0, 500).perform();
act.scrollByAmount(300, 0).perform();

TakesScreenshot ts=(TakesScreenshot)driver;
File temp=ts.getScreenshotAs(OutputType.FILE);
File dest=new File("./screenshots"+time+"image.png");
org.openqa.selenium.io.FileHandler.copy(temp, dest);
	}

}
