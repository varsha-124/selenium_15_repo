package miniproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebElementPage{
	@FindBy(linkText="Log in")
	private WebElement loginLink;
	
	@FindBy(id="Email")
	private WebElement emailTextField;
	
	@FindBy(id="Password")
    private WebElement passwordTextField;
	
	@FindBy(xpath="//input[@value='Log in']")
	private WebElement loginButton;
	
	@FindBy(linkText="Log out")
	private WebElement logoutLink;
	
	@FindBy(linkText="Books")
	private WebElement booksLink;
	
	@FindBy(linkText="Computers")
	private WebElement computersLink;
	
	@FindBy(linkText="Electronics")
	private WebElement electronicsLink;
	
	@FindBy(linkText="Gift Cards")
	private WebElement giftCardsLink;
	
	public WebElementPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getLoginLink() {
		return loginLink;
	}

	public WebElement getEmailTextField() {
		return emailTextField;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	public WebElement getLogoutLink() {
		return logoutLink;
	}

	public WebElement getBooksLink() {
		return booksLink;
	}

	public WebElement getComputersLink() {
		return computersLink;
	}

	public WebElement getElectronicsLink() {
		return electronicsLink;
	}

	public WebElement getGiftCardsLink() {
		return giftCardsLink;
	}

	
	
	
	
	

}
