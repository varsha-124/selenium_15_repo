package p;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Assig13 {

	public static void main(String[] args) {
WebDriver driver=new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

driver.get("https://demoapp.skillrary.com/");
driver.findElement(By.id("navbar-search-input")).sendKeys("Selenium",Keys.ENTER);
driver.findElement(By.linkText("Selenium")).click();


WebElement plus = driver.findElement(By.xpath("//i[@class='fa fa-plus']"));

Actions act=new Actions(driver);
act.moveToElement(plus).perform();
act.doubleClick(plus).perform();

	}

}
