package automationTestCaseAssig;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Register {

	public static void main(String[] args) throws IOException {
FileInputStream fis=new FileInputStream("./testdata/register.properties");

Properties prop=new Properties();
prop.load(fis);
String url = prop.getProperty("url");
String name = prop.getProperty("name");
String email = prop.getProperty("email");
String title = prop.getProperty("title");
String password = prop.getProperty("password");
String DOB = prop.getProperty("DOB");
String firstname = prop.getProperty("firstname");
String lastname = prop.getProperty("lastname");
String company = prop.getProperty("company");
String address=prop.getProperty("address");
String address2 = prop.getProperty("address2");
String country = prop.getProperty("country");
String state = prop.getProperty("state");
String zipcode = prop.getProperty("zipcode");
String mobilenumber = prop.getProperty("mobilenumber");
String city = prop.getProperty("city");


WebDriver driver=new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

driver.get(url);
String title1=driver.getTitle(); //for title
System.out.println(title1); 

if(title1.contains("Automation Exercise")) { //home page verification
	System.out.println("Verify that home page is visible successfully");
}
else {
	System.out.println("Verify that home page is not visible");
}

driver.findElement(By.linkText("Signup / Login")).click();//click on signup/login

String currentUrl = driver.getCurrentUrl(); //capture the current url

if(currentUrl.contains("login")) {//login page verification
	System.out.println("'New User Signup!' is visible");
}
else {
	System.out.println("'New User Signup!' is not visible");
}

driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys(name);
driver.findElement(By.xpath("(//input[@placeholder='Email Address'])[2]")).sendKeys(email);
driver.findElement(By.xpath("//button[text()='Signup']")).click();

String accountInformation = driver.findElement(By.xpath("//b[text()='Enter Account Information']")).getText();
System.out.println(accountInformation);

driver.findElement(By.xpath("//input[@value='Mrs']/../../..//div[@class='radio']")).click(); //to title radio button

driver.findElement(By.id("password")).sendKeys(password);

WebElement days=driver.findElement(By.id("days"));
Select daysSelect=new Select(days);
daysSelect.selectByIndex(15);

WebElement months=driver.findElement(By.id("months"));
Select monthsSelect=new Select(months);
monthsSelect.selectByIndex(11);

WebElement year=driver.findElement(By.id("years"));
Select yearSelect=new Select(year);
yearSelect.selectByVisibleText("1996");

WebElement checkbox=driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
JavascriptExecutor js=(JavascriptExecutor) driver;
js.executeScript("arguments[0].click()",checkbox);

WebElement checkbox1=driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
js.executeScript("arguments[0].click()",checkbox1);


driver.findElement(By.id("first_name")).sendKeys(firstname);
driver.findElement(By.id("last_name")).sendKeys(lastname);
driver.findElement(By.id("company")).sendKeys(company);
driver.findElement(By.id("address1")).sendKeys(address);
driver.findElement(By.id("address2")).sendKeys(address2);
WebElement country1=driver.findElement(By.id("country"));
Select countrySelect=new Select(country1);
countrySelect.selectByVisibleText("India");

driver.findElement(By.id("state")).sendKeys(state);
driver.findElement(By.id("city")).sendKeys(city);
driver.findElement(By.id("zipcode")).sendKeys(zipcode);
driver.findElement(By.id("mobile_number")).sendKeys(mobilenumber);

driver.findElement(By.xpath("//button[text()='Create Account']")).submit();

String accountCreated = driver.findElement(By.xpath("//b[text()='Account Created!']")).getText();
System.out.println(accountCreated);
driver.findElement(By.linkText("Continue")).click(); 

/*driver.findElement(By.linkText("Signup / Login")).click();//click on signup/login
driver.findElement(By.xpath("//input[@placeholder='Email Address']")).sendKeys(email);
driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password);
driver.findElement(By.xpath("//button[text()='Login']")).click();


String juhi = driver.findElement(By.partialLinkText("Logged in as")).getText();
System.out.println(juhi);

driver.findElement(By.partialLinkText("Delete Account")).click();
String accountDeleted = driver.findElement(By.xpath("//b[text()='Account Deleted!']")).getText();
System.out.println(accountDeleted);*/
}
}
