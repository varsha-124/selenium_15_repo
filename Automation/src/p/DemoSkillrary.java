package p;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoSkillrary {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.navigate().to("https://demoapp.skillrary.com/");
		driver.findElement(By.partialLinkText("SIGNUP")).click();
		String currentURL = driver.getCurrentUrl();
		System.out.println(currentURL);
		if(currentURL.contains("register"))
		{
			System.out.println("Register page is displayed");
		}
		else {
			System.out.println("Register page is not displayed");
		}
		driver.findElement(By.name("firstname")).sendKeys("Juhi");
		driver.findElement(By.xpath("(//input[@name='email'])[2]")).sendKeys("juhi.kumari151996@gmail.com");
		driver.findElement(By.xpath("//input[@name='repassword']")).sendKeys("Juhi123@");
		driver.findElement(By.name("lastname")).sendKeys("Singh");
		driver.findElement(By.xpath("(//input[@name='password'])[2]")).sendKeys("Juhi123@");
		driver.findElement(By.name("signup")).click();
		driver.navigate().back();
		Thread.sleep(3000);
		String title = driver.getTitle();
		System.out.println(title);
		if(title.equals("SkillRary Course"))
			System.out.println("Welcome page is displayed");
		else
			System.out.println("Welcome page is not displayed");
	}

}
