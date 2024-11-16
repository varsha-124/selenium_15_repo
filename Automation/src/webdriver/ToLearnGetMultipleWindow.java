package webdriver;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToLearnGetMultipleWindow {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://demoapps.qspiders.com/ui/browser/multipleWindow?sublist=2");
		Thread.sleep(5000);
		driver.findElement(By.id("browserButton3")).click();
		
		Set<String> windowAll = driver.getWindowHandles();
		System.out.println(windowAll);
		
		for(String id:windowAll) {
			System.out.println(id);
		}
		
		driver.quit();

	}

}
