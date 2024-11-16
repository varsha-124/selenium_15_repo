package pom;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestScript {

	public static void main(String[] args) {
WebDriver driver=new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

driver.get("https://demowebshop.tricentis.com/");


WelcomePage wp=new WelcomePage(driver); //page class object creation
//wp.getRegisterLink().click();// calling getter() method of register element
wp.getLoginLink().click();// calling getter() method of login element


LoginPage lg=new LoginPage(driver); //Login page class object creation
lg.getEmailTextField().sendKeys("juhi.kumari1511@gmail.com");
lg.getPasswordTextField().sendKeys("Juhi@12");
lg.getLoginButton().click();

	
	
	}
	
	
	

}
