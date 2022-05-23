package com.crm.autodesk.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * This class contains web elements of login page
 * @author Omprakash
 *
 */
public class LoginPage {
	//initialization
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//Declaration
	@FindBy(name="user_name")
	private WebElement usernameTB;
	
	@FindBy(name="user_password")
	private WebElement passwordTB;
	
	@FindBy(id="submitButton")
	private WebElement loginButton;

	public WebElement getUsernameTB() {
		return usernameTB;
	}

	public WebElement getPasswordTB() {
		return passwordTB;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	/**
	 * this method is used to perform login action
	 * @param username
	 * @param password
	 */
	public void login(String username, String password) {
		usernameTB.sendKeys(username);
		passwordTB.sendKeys(password);
		loginButton.click();
	}
}
