package p;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assig16 {

	public static void main(String[] args) throws IOException {
WebDriver driver=new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
String time = LocalDateTime.now().toString().replace(":", "-");

driver.get("https://globalsqa.com/demo-site/draganddrop/");
WebElement photoFrame = driver.findElement(By.xpath("//iframe[@class='demo-frame lazyloaded']"));
driver.switchTo().frame(photoFrame);

Actions act=new Actions(driver);

WebElement img1 = driver.findElement(By.xpath("//img[@alt='The peaks of High Tatras']"));
WebElement img2 = driver.findElement(By.xpath("//img[@alt='The chalet at the Green mountain lake']"));

WebElement trash = driver.findElement(By.id("trash"));

act.dragAndDrop(img1, trash).perform();
act.dragAndDrop(img2, trash).perform();

driver.switchTo().defaultContent();

driver.findElement(By.xpath("//a[text()='CheatSheets'][1]")).click();


WebElement dismiss = driver.findElement(By.xpath("//iframe[@id='aswift_5']"));
driver.switchTo().frame(dismiss);
driver.findElement(By.id("dismiss-button")).click();

driver.switchTo().defaultContent();
driver.findElement(By.xpath("//a[text()='SQL Cheat Sheet']")).click();

Set<String> id = driver.getWindowHandles();
for(String i:id) {
	driver.switchTo().window(i);
	String currentUrl=driver.getCurrentUrl();
	if(currentUrl.contains("Sql")) {
		break;
	}
}
WebElement sql = driver.findElement(By.xpath("(//img[@loading='lazy'])[2]"));
act.scrollToElement(sql).perform();

TakesScreenshot ts=(TakesScreenshot)driver;
File temp=ts.getScreenshotAs(OutputType.FILE);
File dest=new File("./screenshots"+time+"image.png");
FileHandler.copy(temp, dest);


	}

}
