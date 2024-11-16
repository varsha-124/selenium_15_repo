package p;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchDriverControlToWindow {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		String url="https://www.flipkart.com/";
		
		SwitchDriverControlToWindow.switchToWindow(driver,url);
		System.out.println(driver.getWindowHandle());
		
	}

	private static void switchToWindow(WebDriver driver, String url) {
		driver.get(url);
		System.out.println(driver.getTitle());
		
	}

}
