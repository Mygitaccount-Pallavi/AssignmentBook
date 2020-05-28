package com.goodreads.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.goodreads.qa.base.TestBase;

public class LoginPage extends TestBase {

	@FindBy(id="userSignInFormEmail")
	WebElement userName;
	
	@FindBy(id="user_password")
	WebElement  password;
	
	@FindBy(xpath="//div[@class='formBox']//input[@type='submit']")
	WebElement loginButton;
	
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validatLoginPage() {
		return driver.getTitle();
	}
	
	public HomePage login(String uname, String pword) {
		userName.sendKeys(uname);
		password.sendKeys(pword);
		
		loginButton.click(); 
		
		return new HomePage();
		
	}
}
