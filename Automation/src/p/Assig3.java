package p;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assig3 {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.flipkart.com/");
		String title=driver.findElement(By.name("q")).getAttribute("title");
		System.out.println(title);
		if(title.contains("Search for Products, Brands and More")){
			System.out.println("Tooltip is present");
		}
		else {
			System.out.println("Tootip is not present");
		}

	}


}
