package crossbrowser;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseClassDemoSKillrary {
	public WebDriver driver;
	public Properties prop;
	
	@BeforeTest
	public void objectCreation() throws IOException {
		FileInputStream fis=new FileInputStream("./testdata/demoappskillrary.properties");
		prop=new Properties();
		prop.load(fis);
	}
	
	@Parameters("Browser")
	@BeforeClass
	public void launchBrowser(@Optional("chrome") String browsername) {
		if(browsername.equals("chrome")) {
			driver=new ChromeDriver();
		}
		else if(browsername.equals("edge")) {
			driver=new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		String url=prop.getProperty("url");
		driver.get(url);
		
		}
	@BeforeMethod
	public void login() {
		driver.findElement(By.linkText("LOGIN")).click();
		
		String email=prop.getProperty("email");
		driver.findElement(By.id("email")).sendKeys(email);
		
		String password=prop.getProperty("password");
		driver.findElement(By.id("password")).sendKeys(password);
		
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		
	}
	
	@AfterMethod
	public void logout() {
		driver.findElement(By.xpath("//span[text()='SkillRary Admin']")).click();
		driver.findElement(By.linkText("Sign out")).click();
	}
	
	
	
	@AfterClass
	public void closeBrowser() {
		driver.quit();
		}
	

}
