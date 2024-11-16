package synchronisation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ToLearnExplicitWait {

	public static void main(String[] args) {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
	
	driver.get("https://www.shoppersstack.com/products_page/18");
	driver.findElement(By.id("Check Delivery")).sendKeys("560010");
	WebElement checkButton = driver.findElement(By.id("Check"));
    
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(1));
	wait.until(ExpectedConditions.elementToBeClickable(checkButton));
	checkButton.click();
	
	}

}
