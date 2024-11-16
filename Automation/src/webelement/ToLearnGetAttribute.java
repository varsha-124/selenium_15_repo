package webelement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToLearnGetAttribute {

	public static void main(String[] args) {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	
	/*driver.get("https://demowebshop.tricentis.com/login");
	
	WebElement searchTF=driver.findElement(By.id("small-searchterms"));
	String value=searchTF.getAttribute("value");
	System.out.println(value);*/
	
	driver.get("https://flipkart.com/");
	/*WebElement name=driver.findElement(By.name("q"));
	String value=name.getAttribute("placeholder");
	System.out.println(value);*/
	
	System.out.println(driver.findElement(By.name("q")).getAttribute("placeholder"));
	

	}

}
