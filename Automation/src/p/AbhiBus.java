package p;

import java.time.Duration;
import java.time.LocalDateTime;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbhiBus {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		String time = LocalDateTime.now().toString().replace(":", "-");

		driver.get("https://www.abhibus.com/");
		//driver.findElement(By.xpath("(");)
		driver.findElement(By.xpath("//input[@placeholder='Onward Journey Date']")).click();
		int count=0;
		while(true) {
			
			
		}
	}

}
