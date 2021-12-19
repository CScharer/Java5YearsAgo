package com.cjs.qa.marlboro.pages;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.cjs.qa.core.Environment;
import com.cjs.qa.core.QAException;
import com.cjs.qa.core.security.EPasswords;
import com.cjs.qa.marlboro.MarlboroEnvironment;
import com.cjs.qa.selenium.Page;

public class SignInPage extends Page
{
	public SignInPage(WebDriver webDriver)
	{
		super(webDriver);
	}

	final By	editUserName				= By.xpath(".//*[@id='UserName']");
	final By	editPassword				= By.xpath(".//*[@id='Password']");
	final By	editDateOfBirthMonth		= By.xpath(".//*[@id='DateOfBirthMonth']");
	final By	editDateOfBirthDay			= By.xpath(".//*[@id='DateOfBirthDay']");
	final By	editDateOfBirthYear			= By.xpath(".//*[@id='DateOfBirthYear']");
	final By	CheckboxRememberUsername	= By.xpath(".//*[@id='rememberUsername']");
	final By	buttonEnter					= By.xpath(".//*[@id='loginBtn']");
	final By	imageAccount				= By.xpath(".//a[@data-dtmtext='Account Logo']");
	final By	linkLogOut					= By.xpath(".//a[contains(text(),'LOG OUT')]");

	public void buttonEnterClick() throws QAException
	{
		clickObject(buttonEnter);
	}

	public void CheckboxRememberUsernameSet(String value) throws QAException
	{
		setCheckbox(CheckboxRememberUsername, value);
	}

	public void editUserNameSet(String value) throws QAException
	{
		setEdit(editUserName, value);
	}

	public void editPasswordSet(String value) throws QAException
	{
		setEditPassword(editPassword, value);
	}

	public void editDateOfBirthMonthSet(String value) throws QAException
	{
		setEdit(editDateOfBirthMonth, value);
	}

	public void editDateOfBirthDaySet(String value) throws QAException
	{
		setEdit(editDateOfBirthDay, value);
	}

	public void editDateOfBirthYearSet(String value) throws QAException
	{
		setEdit(editDateOfBirthYear, value);
	}

	public void imageAccountClick() throws QAException
	{
		// webDriver.get(MarlboroEnvironment.URL_BASE +
		// "/pages/my-account/profile-page"
		// + IExtension.HTML);
		final List<WebElement> webElements = webDriver.findElements(imageAccount);
		final WebElement imageAccount = webElements.get(1);
		clickObject(imageAccount);
	}

	public void linkLogOutClick() throws QAException
	{
		final List<WebElement> webElements = webDriver.findElements(linkLogOut);
		final WebElement linkLogOut = webElements.get(0);
		clickObject(linkLogOut);
	}

	public void populate(Map<String, String> mapUser) throws QAException
	{
		do
		{
			load();
		} while (!objectExists(editUserName, 1));
		editUserNameSet(mapUser.get("UserName"));
		editPasswordSet(EPasswords.MARLBORO.getValue());
		// editDateOfBirthMonthSet(mapUser.get("Month"));
		// editDateOfBirthDaySet(mapUser.get("Day"));
		// editDateOfBirthYearSet(mapUser.get("Year"));
		// CheckboxRememberUsernameSet("unchecked");
		buttonEnterClick();
	}

	public void load() throws QAException
	{
		maximizeWindow();
		Environment.sysOut("Loading:[" + MarlboroEnvironment.URL_LOGIN + "]");
		webDriver.get(MarlboroEnvironment.URL_LOGIN);
	}

	public void wrapUp() throws QAException
	{
		imageAccountClick();
		linkLogOutClick();
	}
}