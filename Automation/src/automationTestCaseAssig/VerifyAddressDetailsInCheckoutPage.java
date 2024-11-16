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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VerifyAddressDetailsInCheckoutPage {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));

		FileInputStream fis=new FileInputStream("./testdata/register.properties");
		Properties prop=new Properties();
		prop.load(fis);
		String url=prop.getProperty("url");
		driver.get(url);
		String title1 = driver.getTitle();
		String title = prop.getProperty("title");
		String password = prop.getProperty("password");
		String DOB = prop.getProperty("DOB");
		String firstname = prop.getProperty("firstname");
		String lastname = prop.getProperty("lastname");
		String company = prop.getProperty("company");
		String address=prop.getProperty("address");
		String address2 = prop.getProperty("address2");
		String country = prop.getProperty("country");
		String state = prop.getProperty("state");
		String zipcode = prop.getProperty("zipcode");
		String mobilenumber = prop.getProperty("mobilenumber");
		String city = prop.getProperty("city");
		String name = prop.getProperty("name");
		String email = prop.getProperty("email");
		
		System.out.println(title1);
		
		if(title1.contains("Automation Exercise")) {
			System.out.println("home page is visible successfully");
		}
		else {
			System.out.println("home page is not visible");
		}
		
		driver.findElement(By.linkText("Signup / Login")).click();
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys(name);
		driver.findElement(By.xpath("(//input[@placeholder='Email Address'])[2]")).sendKeys(email);
		driver.findElement(By.xpath("//button[text()='Signup']")).click();
		

		String accountInformation = driver.findElement(By.xpath("//b[text()='Enter Account Information']")).getText();
		System.out.println(accountInformation);

		driver.findElement(By.xpath("//input[@value='Mrs']/../../..//div[@class='radio']")).click(); //to title radio button

		driver.findElement(By.id("password")).sendKeys(password);

		WebElement days=driver.findElement(By.id("days"));
		Select daysSelect=new Select(days);
		daysSelect.selectByIndex(15);

		WebElement months=driver.findElement(By.id("months"));
		Select monthsSelect=new Select(months);
		monthsSelect.selectByIndex(11);

		WebElement year=driver.findElement(By.id("years"));
		Select yearSelect=new Select(year);
		yearSelect.selectByVisibleText("1996");

		driver.findElement(By.id("first_name")).sendKeys(firstname);
		driver.findElement(By.id("last_name")).sendKeys(lastname);
		driver.findElement(By.id("company")).sendKeys(company);
		driver.findElement(By.id("address1")).sendKeys(address);
		driver.findElement(By.id("address2")).sendKeys(address2);
		WebElement country1=driver.findElement(By.id("country"));
		Select countrySelect=new Select(country1);
		countrySelect.selectByVisibleText("India");

		driver.findElement(By.id("state")).sendKeys(state);
		driver.findElement(By.id("city")).sendKeys(city);
		driver.findElement(By.id("zipcode")).sendKeys(zipcode);
		driver.findElement(By.id("mobile_number")).sendKeys(mobilenumber);

		driver.findElement(By.xpath("//button[text()='Create Account']")).submit();

		String accountCreated = driver.findElement(By.xpath("//b[text()='Account Created!']")).getText();
		System.out.println(accountCreated);
		driver.findElement(By.linkText("Continue")).click();

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
		
		driver.findElement(By.linkText("Proceed To Checkout")).click();
		
		 WebElement deliveryAddressElement = driver.findElement(By.id("address_delivery"));
         String deliveryAddress = deliveryAddressElement.getText();
         
         WebElement deliveryAddress1=driver.findElement(By.xpath("(//li[@class='address_title'])[1]"));
         List<WebElement> address1= deliveryAddress1.findElements(By.tagName("li"));
         for(WebElement i:address1) {
        	 System.out.println(i.getText());
        	 }
         
        WebElement billingAddressElement  = driver.findElement(By.id("address_invoice"));
         String billingAddress = billingAddressElement.getText();
         
         WebElement deliveryAddress2=driver.findElement(By.xpath("(//li[@class='address_title'])[2]"));
         List<WebElement> address3 = deliveryAddress1.findElements(By.tagName("li"));
         for(WebElement i:address3) {
        	 System.out.println(i.getText());
        	 }
         

         if (address.equals(address2)) {
             System.out.println("The delivery address matches the billing address.");
         } else {
             System.out.println("The delivery address does not match the billing address.");
         }
			                
			                /*driver.findElement(By.partialLinkText("Delete Account")).click();
			                String accountDeleted = driver.findElement(By.xpath("//b[text()='Account Deleted!']")).getText();
			                System.out.println(accountDeleted);*/


		
	}


			
		
	}

