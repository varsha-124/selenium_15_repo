package iframe;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ToLearnIframe {
//class is modified
	public static void main(String[] args) {
WebDriver driver=new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
//wait.until(ExpectedConditions.expectedToBeClickable());

driver.get("https://www.dream11.com/");
//driver.switchTo().frame(0);//index based

//driver.switchTo().frame("send-sms-iframe");//value of id or name of <iframe> tag

WebElement iframe=driver.findElement(By.xpath("//iframe[@title='Iframe Example']"));
driver.switchTo().frame(iframe);//using WebElement

driver.findElement(By.id("regEmail")).sendKeys("12345667788");
driver.findElement(By.id("regUser")).click();

driver.switchTo().defaultContent();
driver.findElement(By.id("hamburger")).click();
	


	}

}
