package webdriver;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Myntra {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().fullscreen();
		driver.get("https://www.myntra.com/");
		
		Point pos = driver.manage().window().getPosition();
		System.out.println("X "+pos.getX());
		System.out.println("Y "+pos.getY());
		driver.quit();

	}

}
