package automationTestCaseAssig;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginUserCorrect {
	public static void main(String[]args) throws IOException {
	FileInputStream fis=new FileInputStream("./testdata/loginusercorrect.properties");
	
	Properties prop=new Properties();
	prop.load(fis);
	String url = prop.getProperty("url");
	String email = prop.getProperty("email");
	String password = prop.getProperty("password");
	
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	
	driver.get(url);
	String title = driver.getTitle();
	System.out.println(title);
	
	if(title.contains("Automation Exercise")) {
		System.out.println("home page is visible successfully");
	}
	else {
		System.out.println("home page is not visible");
	}
	
	driver.findElement(By.partialLinkText("Signup / Login")).click();
	String text = driver.findElement(By.xpath("//h2[text()='Login to your account']")).getText();
	System.out.println(text);
	
	driver.findElement(By.xpath("//input[@placeholder='Email Address']")).sendKeys(email);
	driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password);
	driver.findElement(By.xpath("//button[text()='Login']")).click();
	String juhi = driver.findElement(By.partialLinkText("Logged in as")).getText();
	System.out.println(juhi);
	
/*driver.findElement(By.partialLinkText("Delete Account")).click();
String accountDeleted = driver.findElement(By.xpath("//b[text()='Account Deleted!']")).getText();
System.out.println(accountDeleted);*/

}
}
