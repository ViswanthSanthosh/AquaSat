package com.aquasat.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aqua.baseclass.TestBase;

public class LoginPage extends TestBase {

	public LoginPage() throws IOException {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "email")
	WebElement email;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(id = "mui-1")
	WebElement loginbtn;

	@FindBy(xpath = "//*[@id=\"__next\"]/div/div/section/div/div/div[2]/div/div[1]/h1")
	WebElement titletext;

	public void enterEmail(String un) {
		email.sendKeys(un);

	}

	public void enterPassword(String pwd) {
		password.sendKeys(pwd);
	}

	public void clickLoginButton() {
		loginbtn.click();

	}

	public void titletext() {
		titletext.isDisplayed();

	}

}
