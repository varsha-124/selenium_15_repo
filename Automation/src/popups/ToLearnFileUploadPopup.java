package popups;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class ToLearnFileUploadPopup {

	public static void main(String[] args) {
WebDriver driver=new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

driver.get("https://www.naukri.com/registration/createAccount");
WebElement scroll = driver.findElement(By.partialLinkText(" Terms and Conditions "));
Actions act=new Actions(driver);
act.scrollToElement(scroll);

driver.findElement(By.xpath("//p[@class='main-2']")).click();
driver.findElement(By.xpath("(//input[@type='file'])[1]")).sendKeys("C:\\Users\\juhis\\OneDrive\\Documents\\Juhi_Resume.docx");


	}

}
