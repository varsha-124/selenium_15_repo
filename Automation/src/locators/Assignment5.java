package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment5 {

	public static void main(String[] args) {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	
	driver.get("https://demowebshop.tricentis.com/");
	driver.findElement(By.xpath("//a[text()='Log in']")).click();
	driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("juhi.singh1996raj@gmail.com");
	driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("Juhi@123");
	driver.findElement(By.xpath("//input[@value='Log in']")).click();
	
	String title=driver.getTitle();
	System.out.println(title);
	if(title.equals("Demo Web Shop"))
		System.out.println("Homepage is displayed");
	else
		System.out.println("home is not displayed");

	}

}
