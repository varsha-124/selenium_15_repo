package p;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assig {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://demowebshop.tricentis.com/");
		String currentUrl=driver.getCurrentUrl();
		if(currentUrl.contains("demowebshop")) {
			System.out.println("demowebshop is displayed");
		}
		else {
			System.out.println("Demowebshop is not displayed");
		}
		driver.findElement(By.linkText("Facebook")).click();
		Assig.switchToWindow(driver,"facebook");
		System.out.println("Facebook welcome page is displayed");
		driver.findElement(By.xpath("//span[text()='Create new account']")).click();
		Assig.switchToWindow(driver,"reg");
		Thread.sleep(3000);
		System.out.println("Sign up page is displayed");
		driver.findElement(By.cssSelector("input[name='firstname']")).sendKeys("Juhi");
		driver.findElement(By.name("lastname")).sendKeys("Singh");
		
	}	
		
		public static void switchToWindow(WebDriver driver, String url) {
			Set<String> allWindowIds= driver.getWindowHandles();
			for(String id:allWindowIds) {
			driver.switchTo().window(id);
			String actUrl=driver.getCurrentUrl();
			if(actUrl.contains(url)) {
				break;
		}

	}

}
	}
