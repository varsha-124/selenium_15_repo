package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment2 {

	public static void main(String[] args) {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	
	driver.navigate().to("https://demoapp.skillrary.com/");
	driver.findElement(By.partialLinkText("SIGNUP")).click();
	
	
	String currenturl = driver.getCurrentUrl();
	if(currenturl.equals("https://demoapp.skillrary.com/login.php?type=register")) {
		
	System.out.println("Register page is displayed");
	}
	else
			System.out.println("Register page not displayed");
	
	
	driver.findElement(By.name("firstname")).sendKeys("Juhi");
	driver.findElement(By.name("lastname")).sendKeys("Singh");
	driver.findElement(By.xpath("(//input[@name='email'])[2]")).sendKeys("juhi.kumari1511@gmail.com");
	driver.findElement(By.xpath("(//input[@name='repassword'])[1]")).sendKeys("Juhi@1511");
	driver.findElement(By.xpath("(//input[@type='password'])[2]")).sendKeys("Juhi@1511");  
	driver.findElement(By.cssSelector("input[name='signup']")).click();
	
	driver.navigate().back();
	
	String title = driver.getTitle();
	if(title.equals("SkillRary Courses")) {
		System.out.println("welcome page displayed");
	}
	else {
		System.out.println("welcome page not displayed");
	}
	
	
	}
}
