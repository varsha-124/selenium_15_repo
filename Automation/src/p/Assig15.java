package p;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assig15 {

	public static void main(String[] args) throws InterruptedException {
WebDriver driver=new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));


driver.get("https://petdiseasealerts.org/forecast-map/#/");
driver.switchTo().frame(1);
driver.findElement(By.cssSelector("path[id='region-27']")).click();

driver.switchTo().parentFrame();
driver.findElement(By.xpath("//a[text()='Sign up']")).click();
driver.findElement(By.id("user")).sendKeys("juhi.singh1996raj@gmail.com");
driver.findElement(By.id("pass")).sendKeys("Juhi@1234");
driver.findElement(By.id("cpass")).sendKeys("Juhi@1234");
driver.findElement(By.id("firstName")).sendKeys("Juhi");
driver.findElement(By.id("lastName")).sendKeys("Singh");
driver.findElement(By.id("phone")).sendKeys("7827860643");

WebElement userType = driver.findElement(By.id("user-type"));
Select userTypeSelect=new Select(userType);
userTypeSelect.selectByIndex(0);

driver.findElement(By.id("accept-tou")).click();
Thread.sleep(2000);
driver.findElement(By.xpath("//button[text()='Sign Up']")).click();
Thread.sleep(8000);
String text = driver.findElement(By.xpath("//b[contains(text(),'Thank you for registering!')]")).getText();
System.out.println(text);

	}

}
