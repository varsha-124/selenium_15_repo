package demoappskillrary;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import pom.LoginPage;
import pom.WelcomePage;

public class BaseClass {
	public WebDriver driver;
	public Properties prop;
	public Workbook workbook;
	
	public LoginPage lp;
	public WelcomePage wp;
	
	@BeforeTest
	public void objectCreation() throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./testdata/demoappskillrary.properties");
		prop=new Properties();
		prop.load(fis);
		
		FileInputStream fis1=new FileInputStream("./testdata/TestscriptData.xlsx");
		workbook=WorkbookFactory.create(fis1);
	}
	
	
	@AfterTest
	public void objectEmpty() throws IOException {
		workbook.close();
	}
	@BeforeClass
	public void launchBrowser() {
		driver=new ChromeDriver();
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
		lp=new LoginPage(driver);
		driver.findElement(By.linkText("LOGIN")).click();
		
		String email=prop.getProperty("email");
		lp.getEmailTextField().sendKeys(email);
		
		String password=prop.getProperty("password");
		lp.getPasswordTextField().sendKeys(password);
		
		lp.getLoginButton().click();
	}
	
	@AfterMethod
	public void logout() {
		driver.findElement(By.xpath("//span[text()='SkillRary Admin']")).click();
		driver.findElement(By.linkText("Sign out")).click();
	}

}
