package automationTestCaseAssig;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddProductsInCart {

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

driver.findElement(By.partialLinkText("Products")).click();

String blueTop="Blue Top";
String cart1="Add to cart";
JavascriptExecutor js = (JavascriptExecutor) driver;
WebElement element0 = driver.findElement(By.xpath("//p[text()='"+blueTop+"']/..//a[text()='"+cart1+"']"));
js.executeScript("arguments[0].click()", element0);

String continueShopping="Continue Shopping";
WebElement element1 = driver.findElement(By.xpath("//button[contains(text(),'"+continueShopping+"')]"));
Thread.sleep(2000);
element1.click();

String tshirt="Men Tshirt";
String cart="Add to cart";
WebElement element = driver.findElement(By.xpath("//p[text()='"+tshirt+"']/..//a[text()='"+cart+"']"));
js.executeScript("arguments[0].click()", element);

String continueShopping1="Continue Shopping";
WebElement element2 = driver.findElement(By.xpath("//button[contains(text(),'"+continueShopping1+"')]"));
Thread.sleep(2000);
element2.click();

driver.findElement(By.partialLinkText("Cart")).click();

String top = driver.findElement(By.linkText("Blue Top")).getText();
System.out.println(top+  "added to the cart");

String price=driver.findElement(By.xpath("(//p[text()='Rs. 500'])[1]")).getText();
System.out.println(price+  "of Blue Top");


String priceT=driver.findElement(By.xpath("(//p[text()='Rs. 500'])[2]")).getText();
System.out.println(priceT+  "of Blue Top");

String quantity=driver.findElement(By.xpath("(//button[text()='1'])[1]")).getText();
System.out.println(quantity+  "of Blue Top");


String shirt = driver.findElement(By.linkText("Men Tshirt")).getText();
System.out.println(shirt+  "added to the cart");

String price1=driver.findElement(By.xpath("(//p[text()='Rs. 400'])[1]")).getText();
System.out.println(price1+  "of Blue Top");

String priceT1=driver.findElement(By.xpath("(//p[text()='Rs. 400'])[2]")).getText();
System.out.println(priceT1+  "of Blue Top");


String quantity1=driver.findElement(By.xpath("(//button[text()='1'])[2]")).getText();
System.out.println(quantity+  "Men Tshirt");


}
}
 



