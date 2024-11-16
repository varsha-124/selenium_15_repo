package p;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Assig8 {

	public static void main(String[] args) throws IOException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		String time = LocalDateTime.now().toString().replace(":", "-");
		
		driver.get("https://demoapps.qspiders.com/");
		driver.findElement(By.xpath("//p[text()='UI Testing Concepts']")).click();
	
		driver.findElement(By.xpath("//section[text()='Web Table']")).click();
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		if(currentUrl.contains("https://demoapps.qspiders.com/ui")) {
			System.out.println("Web Table page is displayed");
		}
		else {
			System.out.println("Web Table page is not displayed");
		}
		
		driver.findElement(By.linkText("Dynamic Web Table")).click();
		String currentUrl1 = driver.getCurrentUrl();
		if(currentUrl1.contains("https://demoapps.qspiders.com/ui/table/dynamicTable")) {
			System.out.println("Dynamic Web Table page is displayed");
		}
		else {
			System.out.println("Dynamic Web Table page is not displayed");
		}
		String price = driver.findElement(By.xpath("//th[text()='Apple iPhone']/..//td[@class='px-6 py-4 font-bold text-black']")).getText();
		System.out.println(price);
		TakesScreenshot ts=(TakesScreenshot)driver;
		File temp=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("./screenshots"+time+".png");
		FileHandler.copy(temp, dest);

	}

}
