package webelement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToLearnGetCssValue {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://demowebshop.tricentis.com/login");
		driver.findElement(By.cssSelector("input[value='Log in']")).click();
		WebElement cssProperties = driver.findElement(By.cssSelector("input[value='Log in']"));
		String color=cssProperties.getCssValue("color");
		String fontFamily=cssProperties.getCssValue("font-family");
		String fontSize=cssProperties.getCssValue("font-size");
		String fontWeight=cssProperties.getCssValue("font-weight");
		
		System.out.println(color);
		System.out.println(fontFamily);
		System.out.println(fontSize);
		System.out.println( fontWeight);
		
		String register=driver.findElement(By.linkText("Register")).getCssValue("fontWeight");
		String register1=driver.findElement(By.linkText("Register")).getCssValue("fontSize");
		String register2=driver.findElement(By.linkText("Register")).getCssValue("fontFamily");
		String register3=driver.findElement(By.linkText("Register")).getCssValue("color");
		
		System.out.println(register);
		System.out.println(register1);
		System.out.println(register2);
		System.out.println(register3);
				

	}

}
