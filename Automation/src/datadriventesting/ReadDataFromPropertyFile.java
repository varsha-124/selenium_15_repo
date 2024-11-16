package datadriventesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadDataFromPropertyFile {

	public static void main(String[] args) throws IOException {
		
		
       //Step1: create object for FileInputSTream
		FileInputStream fis=new FileInputStream("./testdata/demoappskillrary.properties");
		
		//step2: create respective file type object
		Properties prop=new Properties();
		
		//step3: call read methods
		prop.load(fis);
		
		String url = prop.getProperty("url");
		System.out.println(url);
		
		String username = prop.getProperty("username");
		System.out.println(username);
		
		String password = prop.getProperty("password");
		System.out.println(password);
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get(url);
		driver.findElement(By.id("email")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		
		
	}

}
