package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage1 {
	//Declaration
	
	@FindBy(linkText="Register")
	private WebElement registerLink;
	
	
	//Initialization
	public WelcomePage1(WebDriver driver) {
    PageFactory.initElements(driver, this);
	}

	//Getters

	public WebElement getRegisterLink() {
		return registerLink;
	}
	
	
	}
