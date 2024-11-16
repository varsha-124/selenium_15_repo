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

public class RemoveProductsFromCart {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
FileInputStream fis=new FileInputStream("./testdata/loginusercorrect.properties");
		
		Properties prop=new Properties();
		prop.load(fis);
		String url = prop.getProperty("url");
		String email = prop.getProperty("email");
		String name = prop.getProperty("name");
		String password = prop.getProperty("password");
		
		driver.get(url);
		driver.findElement(By.partialLinkText("Signup / Login")).click();
		String text = driver.findElement(By.xpath("//h2[text()='Login to your account']")).getText();
		System.out.println(text);
		
		driver.findElement(By.xpath("//input[@placeholder='Email Address']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password);
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		String juhi = driver.findElement(By.partialLinkText("Logged in as")).getText();
		System.out.println(juhi);
		
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
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		if(currentUrl.contains("view_cart")) {
			System.out.println("cart page is displayed");
		}
		else {
			System.out.println("cart page is not displayed");
		}
		
		driver.findElement(By.xpath("(//i[@class=\"fa fa-times\"])[1]")).click();
		driver.findElement(By.xpath("(//i[@class=\"fa fa-times\"])[2]")).click();
		String cart2="Cart is empty!";
		String emptyCart = driver.findElement(By.xpath("//b[text()='"+cart2+"']")).getText();
		System.out.println(emptyCart);
		if(emptyCart.contains("Cart is empty")) {
			System.out.println("product is removed from the cart");
		}
		else {
			System.out.println("product is not removed from the cart");
		}
		

	}

}
