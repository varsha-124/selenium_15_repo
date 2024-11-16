package popups;

import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ScannerAndAddingVariableToXpath {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		 WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		 
		 driver.get("https://www.makemytrip.com/");
		 driver.findElement(By.xpath("//span[@data-cy='closeModal']")).click(); //to close hidden division
		 driver.findElement(By.xpath("//p[@data-cy='departureDate']")).click(); //to click on calendar
		 Scanner s=new Scanner(System.in);
		 System.out.println("Enter the Month");
		 String month=s.next();
		 System.out.println("Enter the Year");
		 int year=s.nextInt();
		 System.out.println("Enter the Date");
		 int date=s.nextInt();
		 
		 while(true) { //for infinite loop
			 try {
				driver.findElement(By.xpath("//div[text()='"+month+" "+year+"']/../..//p[text()='"+date+"']")).click();// to click on January 2025
				break;
			} catch (Exception e) {
				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click(); // to click on arrow 
			}
		 
		 		
	}

	}
}
