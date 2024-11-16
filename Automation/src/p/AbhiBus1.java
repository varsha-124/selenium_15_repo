package p;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AbhiBus1 {

	public static void main(String[] args) throws IOException {
		 WebDriver driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		String time = LocalDateTime.now().toString().replace(":", "-");
		 
		 driver.get("https://www.abhibus.com/");
		 WebElement busBooking = driver.findElement(By.xpath("//h2[text()='Online Bus Booking Services']"));
		 
		 JavascriptExecutor js=(JavascriptExecutor) driver;
		 js.executeScript("arguments[0].scrollIntoView(true)", busBooking);
		 
		 TakesScreenshot ts=(TakesScreenshot)driver;
		 File temp=ts.getScreenshotAs(OutputType.FILE);
		 File dest=new File("./screenshots"+time+"image.png");
		 org.openqa.selenium.io.FileHandler.copy(temp, dest);
	}

}
