package pom;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyRegistrationDemoWebShop {

	public static void main(String[] args) throws IOException {
WebDriver driver=new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

FileInputStream fis=new FileInputStream("./testdata/commonData1.properties");
Properties prop=new Properties();
prop.load(fis);
String url=prop.getProperty("url");

driver.get(url);

FileInputStream fis1=new FileInputStream("./testdata/TestScriptData1.xlsx");
Workbook workbook=WorkbookFactory.create(fis1);
String firstname=workbook.getSheet("sheet1").getRow(1).getCell(0).getStringCellValue();
String lastname=workbook.getSheet("Sheet1").getRow(1).getCell(1).getStringCellValue();
String email=workbook.getSheet("Sheet1").getRow(1).getCell(2).getStringCellValue();
String password=workbook.getSheet("Sheet1").getRow(1).getCell(3).getStringCellValue();
String confirmPassword=workbook.getSheet("Sheet1").getRow(1).getCell(4).getStringCellValue();

WelcomePage1 wp=new WelcomePage1(driver);
wp.getRegisterLink().click();

RegisterPage lg=new RegisterPage(driver);
lg.getGenderRadioButton().click();
lg.getFirstNameTextField().sendKeys(firstname);
lg.getLastNameTextField().sendKeys(lastname);
lg.getEmailTextField().sendKeys(email);
lg.getPassowrdTextField().sendKeys(password);
lg.getConfirmPasswordTextField().sendKeys(confirmPassword);
lg.getRegisterButton().click();



	}

}
