package p;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assig10 {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://www.freshersworld.com/");
		WebElement registerNow = driver.findElement(By.xpath("//span[text()='REGISTER NOW']"));
		System.out.println(registerNow.isDisplayed());
		driver.findElement(By.xpath("//span[text()='REGISTER NOW']")).click();
		
		WebElement city = driver.findElement(By.id("currentCity"));
		Select citySelect=new Select(city);
		citySelect.selectByVisibleText("Bangalore");
		
		WebElement course=driver.findElement(By.id("course"));
		Select courseSelect=new Select(course);
		courseSelect.selectByVisibleText("BE/B.Tech");
		
	}

}
