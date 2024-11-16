package testng;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseClass {
	public WebDriver driver;
	public Properties prop;
	public Workbook workbook;
	
	
	@BeforeTest
	public void createObject() throws IOException {
		FileInputStream fis=new FileInputStream("./testdata/demowebshop.properties");
		prop=new Properties();
		prop.load(fis);
		
		FileInputStream fis1=new FileInputStream("./testdata/TestScriptData.xlsx");
		workbook=WorkbookFactory.create(fis1);
	}
	
	@Parameters("Browser")
	@BeforeClass
	public void beforeClass(@Optional("chrome")String browsername) {
		if(browsername.equals("chrome")){
			driver=new ChromeDriver();
		}
	else if(browsername.equals("edge")) {
		driver=new EdgeDriver();
	}
	else if(browsername.equals("firefox")) {
		driver=new FirefoxDriver();
	}
		//driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		String url=prop.getProperty("url");
		driver.get(url);
	}
	
	@BeforeMethod
	public void beforeMethod() {
		driver.findElement(By.linkText("Log in")).click();
		String email=prop.getProperty("email");
		driver.findElement(By.id("Email")).sendKeys(email);
		String password=prop.getProperty("password");
		driver.findElement(By.id("Password")).sendKeys(password);
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
	}
	
	@AfterMethod
	public void afterMethod() {
		driver.findElement(By.linkText("Log out")).click();
	}
	
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	@AfterTest
	public void closeObject() throws IOException {
		workbook.close();
	}

}
