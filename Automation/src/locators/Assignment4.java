package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment4 {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://demowebshop.tricentis.com/");
		String title = driver.getTitle();
		System.out.println(title);
		
		driver.findElement(By.linkText("Log in")).click();
		
		driver.findElement(By.cssSelector("input[class='email']")).sendKeys("juhi.kumari1511@gmail.com");
		driver.findElement(By.cssSelector("input[id='Password']")).sendKeys("Juhi@123");
		driver.findElement(By.cssSelector("input[value='Log in']")).click();
		

		driver.navigate().back();
		driver.navigate().back();
		if(title.equals("Demo Web Shop")) {
			System.out.println("home page is displayed");
		}
		else
			System.out.println("Home page is not displayed");

	}

}
