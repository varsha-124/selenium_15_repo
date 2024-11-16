package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToLearnGetTitle {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.instagram.com/");
		String title = driver.getTitle();
		System.out.println(title);
		if(title.equals("Instagram/")) {
			System.out.println("User navigated successfully");
		}
		else {
			System.out.println("User failed to navigate");
		}
	
	}

}
