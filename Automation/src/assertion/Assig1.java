package assertion;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Assig1{
	@Test
	public void testScript() {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://automationexercise.com/");
		
		Assert.assertEquals(driver.getTitle(), "Automation Exercise","home page is visible successfully");
		Reporter.log("home page is not visible");
		
		driver.findElement(By.partialLinkText("Signup / Login")).click();
	
		Assert.assertEquals(driver.findElement(By.xpath("//h2[text()='Login to your account']")).isDisplayed(), true);
		Reporter.log("'Login to your account' Displayed",true);
		

       driver.findElement(By.xpath("(//input[@placeholder='Email Address'])[1]")).sendKeys("juhi.kumari151996@gmail.com");
		
		driver.findElement(By.xpath("(//input[@placeholder='Password'])[1]")).sendKeys("Juhi@15");
		
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		
		
		Assert.assertEquals(driver.findElement(By.xpath("//a[text()=' Logged in as ']")).isDisplayed(), true);
		Reporter.log(" Logged in as user Displayed",true);
		
		//driver.findElement(By.partialLinkText("Delete Account")).click();
		
		/*Assert.assertEquals(driver.findElement(By.xpath("//b[text()='Account Deleted!']")).isDisplayed(), true);
		Reporter.log("'ACCOUNT DELETED!",true);*/
		
		
		
	}


}
