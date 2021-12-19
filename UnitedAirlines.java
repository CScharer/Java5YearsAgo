package com.cjs.qa.united.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.cjs.qa.core.QAException;
import com.cjs.qa.selenium.Page;

public class LoginPage extends Page
{
	public LoginPage(WebDriver webDriver)
	{
		super(webDriver);
	}

	final By	editMileagePlusNumber	= By.xpath(".//*[@id='loginFormModel.login']");
	final By	editPassword			= By.xpath(".//*[@id='loginFormModel.password']");
	final By	CheckboxRememberMe		= By.xpath(".//*[@id='loginFormModel']//input[@id='saveCredentials']");
	// loginFormModel.rememberMe
	final By	buttonSignIn			= By.xpath(".//*[@id='loginFormModel']/button");

	public void editMileagePlusNumberSet(String value) throws QAException
	{
		setEdit(editMileagePlusNumber, value);
	}

	public void editPasswordSet(String value) throws QAException
	{
		setEditPassword(editPassword, value);
	}

	public void CheckboxRememberMeSet(String value) throws QAException
	{
		setCheckbox(CheckboxRememberMe, value);
	}

	public void buttonSignInClick() throws QAException
	{
		clickObject(buttonSignIn);
	}

	public void login(String mileagePlusNumber, String password, String rememberMe) throws QAException
	{
		editMileagePlusNumberSet(mileagePlusNumber);
		editPasswordSet(password);
		// CheckboxRememberMeSet(rememberMe);
		buttonSignInClick();
	}
}