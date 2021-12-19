package com.cjs.qa.wellmark.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.cjs.qa.core.Environment;
import com.cjs.qa.core.QAException;
import com.cjs.qa.core.security.EPasswords;
import com.cjs.qa.selenium.Page;
import com.cjs.qa.utilities.CJSConstants;
import com.cjs.qa.utilities.JavaHelpers;
import com.cjs.qa.wellmark.WellmarkEnvironment;

public class LogInPage extends Page
{
	public LogInPage(WebDriver webDriver)
	{
		super(webDriver);
	}

	final By	editUserID		= By.xpath(".//*[@id='ctl00_body_userid']");
	final By	editPassword	= By.xpath(".//*[@id='ctl00_body_password']");
	final By	buttonOK		= By.xpath(".//*[@id='ctl00_body_btnOk']");

	public void buttonOKClick() throws QAException
	{
		clickObject(buttonOK);
	}

	public void editUserIDSet(String value) throws QAException
	{
		setEdit(editUserID, value);
	}

	public void editPasswordSet(String value) throws QAException
	{
		setEditPassword(editPassword, value);
	}

	public void login(String userID, String password) throws QAException
	{
		editUserIDSet(userID);
		editPasswordSet(password);
		buttonOKClick();
	}

	public boolean load() throws QAException
	{
		maximizeWindow();
		Environment.sysOut("Loading:[" + WellmarkEnvironment.URL_LOGIN + "]");
		webDriver.get(WellmarkEnvironment.URL_LOGIN);
		return true;
	}

	public void waitPageLoad() throws QAException
	{
		final By byButtonContinue = By.xpath(".//*[@id='SSOForm']//input[@value='Continue']");
		do
		{
		} while (objectExists(byButtonContinue));
	}

	public void login() throws QAException
	{
		load();
		login(CJSConstants.USERID_MY_WELLMARK, EPasswords.MY_WELLMARK.getValue());
		waitPageLoad();
		JavaHelpers.sleep(5);
	}
}