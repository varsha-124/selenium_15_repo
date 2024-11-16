package javascriptexecutor;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ToLearnWindowScrolling {

	public static void main(String[] args) throws InterruptedException {
WebDriver driver=new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));

driver.get("https://demowebshop.tricentis.com/");

JavascriptExecutor js=(JavascriptExecutor) driver;
// js.executeScript("window.scrollBy(0,500)");

js.executeScript("window.scrollTo(0,800)");
Thread.sleep(2000);
js.executeScript("window.scrollTo(0,document.body.scrollHeight)"); //to scroll till bottom of the web page
js.executeScript("history.go()"); //to refresh the web page
js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
js.executeScript("window.history.go()", args);
	}
}
