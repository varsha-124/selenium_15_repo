package webelement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToLearnIsSelected {

	public static void main(String[] args) {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	
	driver.get("https://demowebshop.tricentis.com/");
	boolean radioButton = driver.findElement(By.xpath("//label[text()='Good']/..//input[@type='radio']")).isSelected();
	System.out.println("Befor Clicking");
	System.out.println(radioButton);//false
	
	WebElement radioButton1 = driver.findElement(By.xpath("//label[text()='Good']/..//input[@type='radio']"));
	radioButton1.click();
	System.out.println("After Clicking");
	System.out.println(radioButton1.isSelected());//true

	}

}
