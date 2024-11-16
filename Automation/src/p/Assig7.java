package p;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Assig7 {

	public static void main(String[] args) throws IOException {
		String time=LocalDateTime.now().toString().replace(":", "-");
WebDriver driver=new ChromeDriver();
driver.manage().window().maximize();

driver.get("https://www.flipkart.com/");
String title=driver.getTitle();
System.out.println(title);
if(title.contains("Online Shopping Site ")) {
	System.out.println("Flipkart app is displayed");
}
else {
	System.out.println("Flipkart app is not displayed");
}

driver.findElement(By.cssSelector("input[title='Search for Products, Brands and More']")).sendKeys("mobiles",Keys.ENTER);

TakesScreenshot ts=(TakesScreenshot)driver;
File temp=ts.getScreenshotAs(OutputType.FILE);
File dest=new File("./screenshots/"+time+".png");
FileHandler.copy(temp,dest);


	}

}
