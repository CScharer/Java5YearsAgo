package com.cjs.qa.pluralsight.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.cjs.qa.selenium.Page;
import com.cjs.qa.utilities.IExtension;

public class LoginPage extends Page
{
	public LoginPage(WebDriver webDriver)
	{
		super(webDriver);
	}

	public static final String	DEFAULT_URL		= "https://app.pluralsight" + IExtension.COM;
	private final By			editUserName	= By.id("Username");
	private final By			editPassword	= By.id("Password");
	private final By			buttonSignIn	= By.id("login");

	public void buttonSignInClick()
	{
		clickObject(buttonSignIn);
	}

	public void editUserNameSet(String value)
	{
		setEdit(editUserName, value);
	}

	public void editPasswordSet(String value)
	{
		setEditPassword(editPassword, value);
	}

	public void login()
	{
		webDriver.get(DEFAULT_URL);
		final String userName = Security.getUserName();
		final String password = Security.getPassword();
		editUserNameSet(userName);
		editPasswordSet(password);
		buttonSignInClick();
	}
}