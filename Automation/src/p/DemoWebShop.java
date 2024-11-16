package p;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoWebShop {

	public static void main(String[] args) {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	
	driver.get("https://demowebshop.tricentis.com/");
	String title=driver.getTitle();
	System.out.println(title);
	
	if(title.equals("Demo Web Shop")) {
		System.out.println("Home is displayed");
	}
	else {
		System.out.println("Home page is not displayed");
	}
	
	driver.findElement(By.linkText("Twitter")).click();
	Set<String> allWindowIds=driver.getWindowHandles();
	System.out.println(allWindowIds);

	}

}
