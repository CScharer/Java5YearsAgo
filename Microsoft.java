package com.cjs.qa.microsoft.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.cjs.qa.core.security.EPasswords;
import com.cjs.qa.selenium.Page;
import com.cjs.qa.utilities.CJSConstants;

public class SignInPage extends Page
{
	final By	CheckboxKeepMeSignedIn	= By.xpath(".//input[@name='KMSI']");
	final By	editEmail				= By.xpath(".//input[@name='loginfmt']");
	final By	editPassword			= By.xpath(".//input[@name='passwd']");
	final By	buttonNext				= By.xpath(".//input[@value='Next']");
	final By	buttonSignIn			= By.xpath(".//input[@value='Sign in']");

	/**
	 * @param webDriver
	 */
	public SignInPage(WebDriver webDriver)
	{
		super(webDriver);
	}

	public void buttonNextClick()
	{
		if (objectExists(buttonNext))
		{
			clickObject(buttonNext);
		}
	}

	public void buttonSignInClick()
	{
		if (objectExists(buttonSignIn))
		{
			clickObject(buttonSignIn);
		}
	}

	/**
	 * @param value
	 */
	public void CheckboxKeepMeSignedInSet(String value)
	{
		if (objectExists(CheckboxKeepMeSignedIn))
		{
			setCheckbox(CheckboxKeepMeSignedIn, value);
		}
	}

	/**
	 * @param value
	 */
	public void editEmailSet(String value)
	{
		if (objectExists(editEmail))
		{
			setEdit(editEmail, value);
		}
	}

	/**
	 * @param value
	 */
	public void editPasswordSet(String value)
	{
		if (objectExists(editPassword))
		{
			setEdit(editPassword, value);
		}
	}

	public void login()
	{
		editEmailSet(CJSConstants.EMAIL_ADDRESS_MSN);
		buttonNextClick();
		editPasswordSet(EPasswords.EMAIL_MSN.getValue());
		CheckboxKeepMeSignedInSet("checked");
		buttonSignInClick();
	}

	/**
	 * @param value
	 */
	public void signIn(String value)
	{
		editEmailSet(value);
		buttonNextClick();
	}
}