package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToLearnXpathByAxes {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///C:/Users/juhis/OneDrive/Desktop/HTML/table.html");
		String collection=driver.findElement(By.xpath("//td[text()='KGF']/following-sibling::td[1]")).getText();
		System.out.println(collection);
		
		String collection1=driver.findElement(By.xpath("//td[text()='KGF']/following-sibling::td[2]")).getText();
		System.out.println(collection1);
		
	String	position=driver.findElement(By.xpath("//td[text()='KGF']/preceding-sibling::td")).getText();
System.out.println(position);
	}

}
