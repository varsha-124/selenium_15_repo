package automationTestCaseAssig;

import java.io.File;
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
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class A {

	public static void main(String[] args) throws IOException, InterruptedException {
		ChromeOptions options= new ChromeOptions();
		WebDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));

		FileInputStream fis=new FileInputStream("./testdata/register.properties");
		Properties prop=new Properties();
		prop.load(fis);
		String url=prop.getProperty("url");
		String name = prop.getProperty("name");
		String email = prop.getProperty("email");
		String password = prop.getProperty("password");
		
		driver.get(url);
		driver.findElement(By.partialLinkText("Signup / Login")).click();
		String text = driver.findElement(By.xpath("//h2[text()='Login to your account']")).getText();
		System.out.println(text);
		
		driver.findElement(By.xpath("//input[@placeholder='Email Address']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password);
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		
		driver.findElement(By.partialLinkText("Cart")).click();
		driver.findElement(By.linkText("Proceed To Checkout")).click();
		
		driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys("Products are good");
        driver.findElement(By.linkText("Place Order")).click();
        driver.findElement(By.xpath("//input[@name='name_on_card']")).sendKeys("Juhi Singh");
        driver.findElement(By.xpath("//input[@name=\"card_number\"]")).sendKeys("5678901234");
        driver.findElement(By.xpath("//input[@name='cvc']")).sendKeys("987");
        driver.findElement(By.xpath("//input[@name='expiry_month']")).sendKeys("12");
        driver.findElement(By.xpath("//input[@name='expiry_year']")).sendKeys("2030");
        driver.findElement(By.id("submit")).submit();
        String orderPlaced = driver.findElement(By.xpath("//p[text()='Congratulations! Your order has been confirmed!']")).getText();
        System.out.println(orderPlaced);
        
        driver.findElement(By.linkText("Download Invoice")).click();
        
        
        
      
        String downloadDir = "C:\\Users\\juhis\\Downloads";
        
        
        options.addArguments("download.default_directory", downloadDir);
        driver.findElement(By.linkText("Download Invoice")).click();
        
        String fileName = "invoice (1).txt";
        File file = new File(downloadDir + File.separator + fileName);
        int attempts = 0;
        while (!file.exists() && attempts < 10) {
            Thread.sleep(1000); // Wait for 1 second
            attempts++;
        }
        
        if (file.exists()) {
            System.out.println("Invoice downloaded successfully.");
        } else {
            System.out.println("Invoice download failed.");
        }
        
        driver.findElement(By.linkText("Continue")).click();
        
        
        
        
        
	}
}

		
		
		
		 