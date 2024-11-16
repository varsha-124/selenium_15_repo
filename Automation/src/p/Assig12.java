package p;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.logging.FileHandler;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Assig12 {

	public static void main(String[] args) throws IOException {
WebDriver driver=new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
String time = LocalDateTime.now().toString().replace(":", "-");

driver.get("https://demoapps.qspiders.com/ui/button/buttonDouble?sublist=2");
WebElement doubleClick = driver.findElement(By.id("btn20"));

Actions act=new Actions(driver);
act.doubleClick(doubleClick).perform();

TakesScreenshot ts=(TakesScreenshot)driver;
File temp=ts.getScreenshotAs(OutputType.FILE);
File dest=new File("./screenshots"+time+"image.png");
org.openqa.selenium.io.FileHandler.copy(temp, dest);
	}

}
