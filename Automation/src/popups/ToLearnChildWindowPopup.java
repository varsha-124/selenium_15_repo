package popups;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToLearnChildWindowPopup {

	public static void main(String[] args) {
WebDriver driver=new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

driver.get("https://www.shoppersstack.com/products_page/23");
driver.findElement(By.id("compare")).click();

Set<String> allWindowIds = driver.getWindowHandles(); //capture all child window ids

for(String id:allWindowIds) {
	driver.switchTo().window(id); //switch to any window
	String currentUrl = driver.getCurrentUrl(); // capture url
	if(currentUrl.contains("Flipkart")) { //compare Url
		break;
	}
}
driver.manage().window().maximize();
driver.close();
	}

}
