package dataprovider;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class ToUseDataProviderFromDifferentClass {
	@Test(dataProviderClass=DataStorage.class,dataProvider="loginData")
	public void login(String[] cred) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://demoapp.skillrary.com/");
		
	    driver.findElement(By.linkText("LOGIN")).click();
	    
	    driver.findElement(By.id("email")).sendKeys(cred[0]);
	    driver.findElement(By.id("password")).sendKeys(cred[1]);
	    
	    driver.findElement(By.xpath("//button[@name='login']")).click();
	    
	    Assert.assertEquals(driver.getTitle(), "Skillrary Ecommerce","User is failed to login");
	    
	    Reporter.log("User logged in succesfully",true);
	    
}


}
