package webdriver;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.WebDriver;
public class ToLearnGet {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		//driver.get("https://www.instagram.com/");
		//driver.get("https://www.flipkart.com/");
		//driver.get("https://www.amazon.in/");
		//WebDriver driver1=new EdgeDriver();
		//driver.get("https://www.amazon.in/");
		driver.get("www.flipkart.com/"); //InvalidArgumentException
		

	}

}
