package webdriver;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RedBus {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		
		
		driver.get("https://www.redbus.in/");
		String title = driver.getTitle();
		System.out.println(title);
		if(title.equals("Bus Ticket Booking Online made Easy, Secure with Top Bus Operators - redBus"))
			System.out.println("Welcomepage displayed");
		else
			System.out.println("Welcome page not displayed");
		
		driver.manage().window().maximize();
		
	Dimension size=driver.manage().window().getSize();
	System.out.println(size.getHeight());
	System.out.println(size.getWidth());


	}

}
