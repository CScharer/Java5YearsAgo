package com.cjs.qa.iadhs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.cjs.qa.core.Environment;
import com.cjs.qa.core.QAException;
import com.cjs.qa.iadhs.IaDhsEnvironment;
import com.cjs.qa.selenium.Page;

public class SignInPage extends Page
{
	public SignInPage(WebDriver webDriver)
	{
		super(webDriver);
	}

	final By	editUserName	= By.xpath(".//*[@id='userId']");
	final By	editPassword	= By.xpath(".//*[@id='xyz']");
	final By	buttonSignIn	= By.xpath(".//*[@id='signInBtn']");

	public void buttonSignInClick() throws QAException
	{
		clickObject(buttonSignIn);
	}

	public void editUserNameSet(String value) throws QAException
	{
		setEdit(editUserName, value);
	}

	public void editPasswordSet(String value) throws QAException
	{
		setEditPassword(editPassword, value);
	}

	public void load() throws QAException
	{
		maximizeWindow();
		Environment.sysOut("Loading:[" + IaDhsEnvironment.URL_LOGIN + "]");
		webDriver.get(IaDhsEnvironment.URL_LOGIN);
	}

	public void signIn(String userName, String password) throws QAException
	{
		do
		{
			load();
		} while (!objectExists(editUserName, 1));
		editUserNameSet(userName);
		editPasswordSet(password);
		buttonSignInClick();
	}
}