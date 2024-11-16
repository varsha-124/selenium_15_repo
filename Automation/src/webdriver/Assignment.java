package webdriver;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://demowebshop.tricentis.com/");
		String title = driver.getTitle();
		System.out.println(title);
		
		if(title.equals("Demo Web Shop")) {
			System.out.println("Welcome page displayed");
		}
		
		driver.navigate().refresh();
		
		Thread.sleep(5000);
		driver.findElement(By.id("https://twitter.com/nopCommerce")).click();
		Set<String> windowIds = driver.getWindowHandles();
		System.out.println(windowIds);
		
		for(String id:windowIds)
		{
			System.out.println(id);
		}

	}

}
