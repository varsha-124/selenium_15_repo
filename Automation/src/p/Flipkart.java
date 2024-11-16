package p;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Flipkart {

	public static void main(String[] args) throws IOException {
WebDriver driver=new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
String time=LocalDateTime.now().toString().replace(":", "-");

driver.get("https://www.flipkart.com/");
List<WebElement> topMenu = driver.findElements(By.xpath("//div[@class=\"_3sdu8W emupdz\"]"));
//List<WebElement> img = topMenu.findElements(By.tagName("img"));
for(WebElement i:topMenu) {
	TakesScreenshot ts=(TakesScreenshot)driver;
    File temp=ts.getScreenshotAs(OutputType.FILE);
	File dest=new File("./screenshots"+time+"image.png");
	FileHandler.copy((File) ts, dest);
	
	String text = i.getText();


	
}


	}

}
