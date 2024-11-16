package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage {
	//step1: Declaration: for Register
	
	@FindBy(linkText="Register")
	private WebElement registerLink;
	
	
	//Declaration of Login
	@FindBy(linkText="Log in")
	private WebElement loginLink;
	

	//Step2: Initialization:
	public WelcomePage(WebDriver driver) {
    PageFactory.initElements(driver, this);
	}

	//Step3: Getters

	public WebElement getRegisterLink() {
		return registerLink;
	}
	
	public WebElement getLoginLink() {
		return loginLink;
	}

	
	

}
