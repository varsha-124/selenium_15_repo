package automationTestCaseAssig;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class RegisterUserExistingEmail {

	public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream("./testdata/register.properties");

		Properties prop=new Properties();
		prop.load(fis);
		String url = prop.getProperty("url");
		String name = prop.getProperty("name");
		String email = prop.getProperty("email");
	
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
String text1 = driver.findElement(By.xpath("//p[text()='Email Address already exist!']")).getText();
System.out.println(text1);
		
	}

}
