package com.cjs.qa.linkedin.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.cjs.qa.core.Environment;
import com.cjs.qa.core.QAException;
import com.cjs.qa.linkedin.LinkedInEnvironment;
import com.cjs.qa.selenium.ISelenium;
import com.cjs.qa.selenium.Page;

import cucumber.api.DataTable;

public class LoginPage extends Page
{
	public LoginPage(WebDriver webDriver)
	{
		super(webDriver);
	}

	// DOCUMENTATION
	// getEditEmail:
	// Gets the value of the [Email] Edit field.
	// setEditEmail:
	// Sets the value of the [Email] Edit field.
	// getEditPassword:
	// Gets the value of the [Password] Edit field.
	// setEditPassword:
	// Sets the value of the [Password] Edit field.
	// clickButtonSignIn:
	// Clicks the [Sign in] Button.
	// clickButtonSubmit:
	// Clicks the [Submit] Button.
	// populatePage:
	// Populates the value of the all of the fields.
	// validatePage:
	// Validates the value of the all of the fields.

	// INPUTS
	// |Email|Email|
	// |Password|Password|

	// TABLE DEF
	// DataTable dataTable = Convert.toDataTable(Arrays.asList(
	// Arrays.asList("Email", "Email"),
	// Arrays.asList("Password", "Password")));

	public By getByEditEmail()
	{
		return By.xpath(".//*[@id='login-email']");
	}

	public By getByEditPassword()
	{
		return By.xpath(".//*[@id='login-password']");
	}

	public By getByButtonSignIn()
	{
		return By.xpath(".//a[@data-tracking-will-navigate='Sign in']");
	}

	public By getByButtonSubmit()
	{
		return By.xpath(".//*[@id='login-submit']");
	}

	public String getEditEmail()
	{
		return getEdit(getByEditEmail());
	}

	public boolean isEditEmailDisplayed()
	{
		return isDisplayed(getByEditEmail());
	}

	public boolean isEditEmailEnabled()
	{
		return isEnabled(getByEditEmail());
	}

	public void setEditEmail(String value)
	{
		setEdit(getByEditEmail(), value);
	}

	public String getEditPassword()
	{
		return getEdit(getByEditPassword());
	}

	public boolean isEditPasswordDisplayed()
	{
		return isDisplayed(getByEditPassword());
	}

	public boolean isEditPasswordEnabled()
	{
		return isEnabled(getByEditPassword());
	}

	public void setEditPassword(String value)
	{
		setEditPassword(getByEditPassword(), value);
	}

	public void clickButtonSignIn()
	{
		clickObject(getByButtonSignIn());
	}

	public void clickButtonSubmit()
	{
		clickObject(getByButtonSubmit());
	}

	public boolean isButtonSubmitDisplayed()
	{
		return isDisplayed(getByButtonSubmit());
	}

	public boolean isButtonSubmitEnabled()
	{
		return isEnabled(getByButtonSubmit());
	}

	public void load() throws QAException
	{
		maximizeWindow();
		Environment.sysOut("Loading:[" + LinkedInEnvironment.URL_LOGIN + "]");
		webDriver.get(LinkedInEnvironment.URL_LOGIN);
	}

	public void loadAlternate() throws QAException
	{
		maximizeWindow();
		// https://www.linkedin.com/uas/login?trk=guest_homepage-basic_nav-header-signin
		String url = LinkedInEnvironment.URL_LOGIN + "uas/login?trk=guest_homepage-basic_nav-header-signin";
		Environment.sysOut("Loading:[" + url + "]");
		webDriver.get(url);
	}

	// SWITCHES POPULATE
	public void populatePage(DataTable dataTable)
	{
		List<List<String>> list = dataTable.raw();
		for (List<?> item : list)
		{
			String field = (String) item.get(0);
			String value = (String) item.get(1);
			if (!value.equals(""))
			{
				Environment.sysOut("{Field}" + field + ", {Value}" + value);
				switch (field.toLowerCase())
				{
					case "email":
						setEditEmail(value);
						break;
					case "password":
						setEditPassword(value);
						break;
					default:
						value = "[" + field + "]" + ISelenium.FIELD_NOT_CODED;
						Environment.sysOut("[" + field + "]" + ISelenium.FIELD_NOT_CODED);
						break;
				}
			}
		}
	}

	// SWITCHES VALIDATE
	public void validatePage(DataTable dataTable)
	{
		Map<String, String> expected = new HashMap<>();
		Map<String, String> actual = new HashMap<>();
		List<List<String>> list = dataTable.raw();
		for (List<?> item : list)
		{
			String field = (String) item.get(0);
			String value = (String) item.get(1);
			if (!value.equals(""))
			{
				Environment.sysOut("{Field}" + field + ", {Value}" + value);
				expected.put(field, value);
				switch (field.toLowerCase())
				{
					case "email":
						value = getEditEmail();
						break;
					case "password":
						value = getEditPassword();
						break;
					default:
						value = "[" + field + "]" + ISelenium.FIELD_NOT_CODED;
						Environment.sysOut("[" + field + "]" + ISelenium.FIELD_NOT_CODED);
						break;
				}
				actual.put(field, value);
			}
		}
		Assert.assertSame(this.getClass().getName() + "validatePage", expected.toString(), actual.toString());
	}

	public void login(LoginAlternatePage loginAlternatePage, String emailAddressUserName, String password)
			throws Throwable
	{
		load();
		if (!objectExists(getByEditEmail(), 3))
		{
			clearCookies();
			load();
		}
		if (objectExists(getByEditEmail(), 3))
		{
			setEditEmail(emailAddressUserName);
			setEditPassword(password);
			clickButtonSubmit();
		} else
		{
			loadAlternate();
			Environment.sysOut("Login Alternate Page Determined");
			loginAlternatePage.login(emailAddressUserName, password);
		}
	}
}