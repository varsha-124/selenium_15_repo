package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	//Declaration
	@FindBy(xpath="//input[@name='Gender']/../..//label[text()='Male']")
	private WebElement genderRadioButton;
	
	@FindBy(id="FirstName")
	private WebElement firstNameTextField;
	
	@FindBy(id="LastName")
	private WebElement lastNameTextField;
	
	@FindBy(id="Email")
	private WebElement emailTextField;
	
	@FindBy(id="Password")
	private WebElement passowrdTextField;
	
	@FindBy(id="ConfirmPassword")
	private WebElement confirmPasswordTextField;
	
	@FindBy(id="register-button")
	private WebElement registerButton;
	
	
	//Initialization
	public RegisterPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}
	
	
	public WebElement getGenderRadioButton() {
		return genderRadioButton;
	}


	public WebElement getFirstNameTextField() {
		return firstNameTextField;
	}


	public WebElement getLastNameTextField() {
		return lastNameTextField;
	}


	public WebElement getEmailTextField() {
		return emailTextField;
	}


	public WebElement getPassowrdTextField() {
		return passowrdTextField;
	}


	public WebElement getConfirmPasswordTextField() {
		return confirmPasswordTextField;
	}


	public WebElement getRegisterButton() {
		return registerButton;
	}



	

	
	

}
