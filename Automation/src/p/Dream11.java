package p;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Dream11 {

	public static void main(String[] args) throws InterruptedException {
WebDriver driver=new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

driver.get("https://www.dream11.com/");
Thread.sleep(2000);
driver.findElement(By.xpath("//input[@placeholder='Enter Mobile Number']")).sendKeys("7562948741");
	}

}
