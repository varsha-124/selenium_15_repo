package actions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ToLearnScrollByAmount {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		
		driver.get("https://demowebshop.tricentis.com/");
	//	WebElement searchLink = driver.findElement(By.linkText("Search"));
		
		Actions act=new Actions(driver);
	act.scrollByAmount(0, 1000).perform(); //to come down
	act.scrollByAmount(0, -200).perform(); //to go up
		//act.scrollByAmount(500, 0).perform();
	}

}
