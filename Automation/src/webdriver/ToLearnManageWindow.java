package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToLearnManageWindow {

	public static void main(String[] args) {
		
				WebDriver driver=new ChromeDriver();
				driver.manage().window().maximize();
				//driver.manage().window().minimize();
				//driver.manage().window().fullScreen();
				driver.get("https://www.instagram.com/");
			}
		}

	