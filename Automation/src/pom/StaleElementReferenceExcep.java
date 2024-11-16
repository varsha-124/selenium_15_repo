package pom;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaleElementReferenceExcep {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://demoapp.skillrary.com/");
		
	WebElement searchTF=driver.findElement(By.id("navbar-search-input"));
		searchTF.sendKeys("Selenium",Keys.ENTER);
		Thread.sleep(1000);
		searchTF.sendKeys("Testng");//getting StaleElementReferenceException here as we are using the same webelement
		
		/*SkillraryPage sp=new SkillraryPage(driver); //avoid the StaleElementException by using POM
		sp.getSearchTF().sendKeys("Selenium",Keys.ENTER);
		sp.getSearchTF().sendKeys("Testng");*/
		
		

	}

}
