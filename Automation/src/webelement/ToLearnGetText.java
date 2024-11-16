package webelement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToLearnGetText {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://demowebshop.tricentis.com/login");
		driver.findElement(By.cssSelector("input[value='Log in']")).click();
		String errorMsg = driver.findElement(By.cssSelector("div[class='validation-summary-errors']")).getText();
		System.out.println(errorMsg);
		
		if(errorMsg.contains("Login was unsuccessful")) {
			System.out.println("Error msg is displayed");
		}
		else {
			System.out.println("Error msg is not displayedor incorrect");
		}
		

	}

}
