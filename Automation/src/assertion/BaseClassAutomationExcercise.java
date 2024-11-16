package assertion;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseClassAutomationExcercise {
	public WebDriver driver;
	public Properties prop;
	public Workbook workbook;
	
	@BeforeTest
	public void objectCreation() throws IOException {
		FileInputStream fis=new FileInputStream("./testdata/loginusercorrect.properties");
		prop=new Properties();
		prop.load(fis);
		}
	
	@BeforeClass
	public void launchBrowser() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		String url = prop.getProperty("url");
		driver.get(url);
		
		Assert.assertEquals(driver.getTitle(), "Automation Exercise","home page is visible successfully");
		Reporter.log("home page is not visible",true);
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
	
	@BeforeMethod
	public void login() {
		driver.findElement(By.linkText(" Signup / Login")).click();
		
		Assert.assertEquals("driver.findElements(By.xpath(\"//h2[text()='Login to your account']\")).isDisplayed()", true);
		Reporter.log("'Login to your account' is not visible",true);
		
		String email = prop.getProperty("email");
		driver.findElement(By.xpath("(//input[@placeholder='Email Address'])[1]")).sendKeys(email);
		
		String password = prop.getProperty("password");
		driver.findElement(By.xpath("(//input[@placeholder='Password'])[1]")).sendKeys(password);
		
		driver.findElement(By.xpath("//button[text()='Login']")).click();
	}
	
	@AfterMethod
	public void logout() {
		driver.findElement(By.partialLinkText("Logout")).click();
	}

}
