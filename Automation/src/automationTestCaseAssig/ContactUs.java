package automationTestCaseAssig;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ContactUs {

	public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream("./testdata/contactus.properties");

		Properties prop=new Properties();
		prop.load(fis);
		String url = prop.getProperty("url");
		String email = prop.getProperty("email");
		String subject = prop.getProperty("subject");
		String message = prop.getProperty("message");
		String name = prop.getProperty("name");

		
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
		driver.findElement(By.linkText("Contact us")).click();
		String text2 = driver.findElement(By.xpath("//h2[text()='Get In Touch']")).getText();
		System.out.println(text2);
		
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys(name);
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@placeholder='Subject']")).sendKeys(subject);
		driver.findElement(By.id("message")).sendKeys(message);
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys("C:\\Users\\juhis\\OneDrive\\Documents\\Juhi_Resume.docx");
		driver.findElement(By.xpath("//input[@value='Submit']")).submit();
		
		Alert popup=driver.switchTo().alert();
		popup.accept();
		
		String text3 = driver.findElement(By.xpath("(//div[text()='Success! Your details have been submitted successfully.'])[1]")).getText();
		System.out.println(text3);
		
		driver.findElement(By.linkText("Home")).click();
		if(title1.contains("Automation Exercise")) { //home page verification
			System.out.println("home page is visible successfully");
		}
		else {
			System.out.println("home page is not visible");
		}
	}

}
