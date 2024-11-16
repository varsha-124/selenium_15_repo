package p;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assig19 {

	public static void main(String[] args) {
WebDriver driver=new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));

driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
driver.switchTo().frame("iframeResult");

driver.findElement(By.xpath("//button[text()='Try it']")).click();
Alert popup=driver.switchTo().alert();
System.out.println(popup.getText());
popup.sendKeys("Juhu");
popup.accept();

WebElement text = driver.findElement(By.xpath("//p[@id='demo']"));
System.out.println(text.getText());
	}

}