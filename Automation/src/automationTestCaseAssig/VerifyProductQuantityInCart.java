package automationTestCaseAssig;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VerifyProductQuantityInCart {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(50));

		FileInputStream fis=new FileInputStream("./testdata/register.properties");
		Properties prop=new Properties();
		prop.load(fis);
		String url = prop.getProperty("url");

		driver.get(url);
		String title=driver.getTitle();
		System.out.println(title);
		if(title.contains("Automation Exercise")) {
			System.out.println("home page is visible successfully");
		}
		else {
			System.out.println("home page is not visible");
		}
		
		String blueTop="Blue Top";
		String viewProduct="View Product";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("(//p[text()='"+blueTop+"'])[1]/../../..//a[text()='"+viewProduct+"']"));
		js.executeScript("arguments[0].click()", element);


String productName=driver.findElement(By.xpath("//h2[text()='Blue Top']")).getText();
System.out.println(productName+  "dispaled");

String categoryName=driver.findElement(By.xpath("//p[contains(text(),'Tops')]")).getText();
System.out.println(categoryName+  "dispaled");

String price=driver.findElement(By.xpath("//span[contains(text(),'Rs. 500')]")).getText();
System.out.println(price+  "dispaled");

String availability=driver.findElement(By.xpath("//b[contains(text(),'Availability:')]")).getText();
System.out.println(availability+  "displayed");

String condition=driver.findElement(By.xpath("//b[contains(text(),'Condition:')]")).getText();
System.out.println(condition+  "displayed");

String brand=driver.findElement(By.xpath("//b[contains(text(),'Brand:')]")).getText();
System.out.println(brand+" displayed");

String product="quantity";
WebElement quantity = driver.findElement(By.id(""+product+""));
//js.executeScript("arguments[0].scrollIntoView(quantity).click()", quantity);
quantity.clear();
Actions act=new Actions(driver);
act.moveToElement(quantity).click().sendKeys("4").perform();

driver.findElement(By.xpath("//button[@class='btn btn-default cart']")).click();

String continueShopping="Continue Shopping";
WebElement element1 = driver.findElement(By.xpath("//button[contains(text(),'"+continueShopping+"')]"));
Thread.sleep(2000);
element1.click();

driver.findElement(By.partialLinkText("Cart")).click();

String top = driver.findElement(By.linkText("Blue Top")).getText();
System.out.println(top+"  is displayed in cart page");

String quantity1=driver.findElement(By.xpath("//button[text()='4']")).getText();
System.out.println(quantity1+" quantity added into the cart");


	}

}
