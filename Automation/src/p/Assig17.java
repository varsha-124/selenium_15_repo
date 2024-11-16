package p;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assig17 {

	public static void main(String[] args) {
WebDriver driver=new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));

driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_alert");
driver.switchTo().frame("iframeResult");

driver.findElement(By.xpath("//button[text()='Try it']")).click();

Alert popUp=driver.switchTo().alert();
System.out.println(popUp.getText());
popUp.accept();
	}

}
