package locators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment6 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.instagram.com/");
		Thread.sleep(5800);
		 driver.findElement(By.xpath("//span[contains(text(),'Contact')]")).click();
	List<WebElement> heading = driver.findElements(By.tagName("h1"));
	List<WebElement> heading1 = driver.findElements(By.tagName("h2"));
	for(WebElement i:heading) {
		System.out.println(i.getText());
	}
	for(WebElement i:heading1) {
		System.out.println(i.getText());
	}
	}

}
