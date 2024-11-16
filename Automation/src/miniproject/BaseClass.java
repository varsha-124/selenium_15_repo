package miniproject;

import java.io.FileInputStream;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseClass {
	public static WebDriver driver;
	public static Properties prop;
	public  WebElementPage wp;
	
	@BeforeTest
	public void objectCreation() throws IOException {
	FileInputStream fis=new FileInputStream("./testdata/demowebshop.properties");
	prop=new Properties();
	prop.load(fis);
}
	
	@Parameters("Browser")
	@BeforeClass
	public void launchBrowser(String browsername) {
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
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
	
	@BeforeMethod
	public void login() {
		wp=new WebElementPage(driver);
		wp.getLoginLink().click();
		
		String email=prop.getProperty("email");
		wp.getEmailTextField().sendKeys(email);
		
		String password=prop.getProperty("password");
		wp.getPasswordTextField().sendKeys(password);
		
		wp.getLoginButton().click();
		
	}
	
	@AfterMethod
	public void logout() {
		wp=new WebElementPage(driver);
		wp.getLogoutLink();
		
	}
	
}
