package p;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assig14 {

	public static void main(String[] args) throws IOException {
WebDriver driver=new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
//wait.until(ExpectedConditions.elementToBeClickable(null));
String time = LocalDateTime.now().toString().replace(":", "-");

driver.get("https://www.myntra.com/");
WebElement kids = driver.findElement(By.partialLinkText("KIDS"));

Actions act=new Actions(driver);
act.moveToElement(kids).perform();

WebElement ethnicWear = driver.findElement(By.linkText("Ethnic Wear"));
ethnicWear.click();
String currentUrl = driver.getCurrentUrl();
if(currentUrl.contains("https://www.myntra.com/ki-etnhc?f=Gender%3Aboys%2Cboys%20girls&plaEnabled=false")){
System.out.println("Ethnic wear webpage is displayed");
	}
else {
	System.out.println("Ethnic wear webpage is not displayed");
}
TakesScreenshot ts=(TakesScreenshot)driver;
File temp=ts.getScreenshotAs(OutputType.FILE);
File dest=new File("./screenshots"+time+"image.png");
FileHandler.copy(temp, dest);



	}
}
	


