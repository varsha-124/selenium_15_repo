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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assig20 {

	public static void main(String[] args) throws IOException {
WebDriver driver=new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
String time = LocalDateTime.now().toString().replace(":", "-");

driver.get("https://www.abhibus.com/");
//driver.findElement(By.xpath("//div[@class='skip-now']")).click();
driver.findElement(By.xpath("//input[@placeholder='Onward Journey Date']")).click();
String month="January";
int year=2025;
int date=2;

while(true) {
	try {
		//driver.findElement(By.xpath("//span[text()='Januray']")).click();
		driver.findElement(By.xpath("//span[text()='"+month+"']/..//span[text()='"+year+"']/../../..//span[text()='"+date+"']")).click();
		break;
	} catch (Exception e) {
		driver.findElement(By.xpath("(//div[@class=' col auto'])[3]")).click();
	}
}
TakesScreenshot ts=(TakesScreenshot)driver;
File temp=ts.getScreenshotAs(OutputType.FILE);
File dest=new File("./screenshots"+time+"image.png");
org.openqa.selenium.io.FileHandler.copy(temp, dest);

	}

}
