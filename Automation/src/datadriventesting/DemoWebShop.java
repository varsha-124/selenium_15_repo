package datadriventesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoWebShop {
	public static void main(String[]args) throws IOException {
	FileInputStream fis=new FileInputStream("./testdata/demowebshop.properties");
	
	Properties prop=new Properties();
	
	prop.load(fis);
	String url = prop.getProperty("url");
	String email = prop.getProperty("email");
	String password = prop.getProperty("password");
	
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	
	driver.get(url);
	driver.findElement(By.id("Email")).sendKeys(email);
	driver.findElement(By.id("Password")).sendKeys(password);
	
	driver.findElement(By.xpath("//input[@value=\"Log in\"]")).click();
	}

}
