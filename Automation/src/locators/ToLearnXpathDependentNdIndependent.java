package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToLearnXpathDependentNdIndependent {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		//driver.get("https://demowebshop.tricentis.com/");
	//driver.findElement(By.xpath("//a[text()='Simple Computer']/../..//input[@value='Add to cart']")).click();
		driver.get("https://www.dunzo.com/search");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[contains(@placeholder,'Search for item or a store')]")).sendKeys("apple Kashmiri");
		driver.findElement(By.xpath("(//p[contains(text(),'Apple - Kashmiri')])[1]/../..//p[contains(text(),'₹')]")).click();

	}

}
