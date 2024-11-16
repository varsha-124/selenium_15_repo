package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	//Declare
	
	@FindBy(id="email")
	private WebElement emailTextField;
	
	@FindBy(id="password")
	private WebElement passwordTextField;
	
	@FindBy(xpath ="//button[text()='Login']")
	private WebElement loginButton;
	
	//Initialization
	public LoginPage(WebDriver driver) {
PageFactory.initElements(driver, this);


//getters

	
	}

	public WebElement getEmailTextField() {
		return emailTextField;
	}

	public void setEmailTextField(WebElement emailTextField) {
		this.emailTextField = emailTextField;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

}
