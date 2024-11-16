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

public class ViewCategoryProducts {

	public static void main(String[] args) throws IOException {
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
		String category = driver.findElement(By.xpath("//h2[text()='Category']")).getText();
		System.out.println(category);
		if(category.contains("CATEGORY")) {
			System.out.println("categories are visible on left side bar");
		}
		else {
			System.out.println("categories are not visible on left side bar");
		}
			String women="Women";
			WebElement women1 = driver.findElement(By.id(""+women+""));
			JavascriptExecutor js=(JavascriptExecutor) driver;
			js.executeScript("arguments[0].click()",women1);
			WebElement featureItem = driver.findElement(By.xpath("//h2[text()='Features Items']"));
			Actions act=new Actions(driver);
			act.scrollToElement(featureItem).perform();
			
			String dress="Dress";
			WebElement dress1 = driver.findElement(By.xpath("(//a[contains(text(),'"+dress+"')])[1]"));
			js.executeScript("arguments[0].click()", dress1);
			
			String currentUrl = driver.getCurrentUrl();
			if(currentUrl.contains("https://automationexercise.com/category_products/1")) {
				System.out.println("category page is displayed ");
			}
			else {
				System.out.println("category page is not displayed ");
			}
			String confirmation = driver.findElement(By.xpath("//h2[@class=\"title text-center\"]")).getText();
			System.out.println(confirmation);
			
			String men="Men";
			WebElement men1 = driver.findElement(By.id(""+men+""));
			js.executeScript("arguments[0].click()",men1);
			
		
			String tshirt="Tshirts";
			WebElement tshirt1 = driver.findElement(By.xpath("(//a[contains(text(),'"+tshirt+"')])[1]"));
			js.executeScript("arguments[0].click()", tshirt1);
			String currentUrl1 = driver.getCurrentUrl();
			System.out.println(currentUrl1);
			if(currentUrl1.contains("https://automationexercise.com/category_products/3")) {
				System.out.println("Men category page is displayed ");
			}
			else {
				System.out.println("Men category page is not displayed ");
			}
		}
		
	}


