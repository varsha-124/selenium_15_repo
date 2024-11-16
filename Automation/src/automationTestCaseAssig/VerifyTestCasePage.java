package automationTestCaseAssig;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyTestCasePage {

	public static void main(String[] args) throws IOException {
FileInputStream fis=new FileInputStream("./testdata/register.properties");
Properties prop=new Properties();
prop.load(fis);
String url=prop.getProperty("url");

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

driver.findElement(By.xpath("(//button[text()='Test Cases'])[1]")).click();
String currentUrl = driver.getCurrentUrl();
System.out.println(currentUrl);
if(currentUrl.contains("test_cases")) {
	System.out.println("user is navigated to test cases page successfully");
}
else {
	System.out.println("user is not navigated to test cases page");
}
	}

}
