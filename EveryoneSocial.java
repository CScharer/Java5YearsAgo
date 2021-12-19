package com.cjs.qa.everyonesocial.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.cjs.qa.core.Environment;
import com.cjs.qa.core.QAException;
import com.cjs.qa.everyonesocial.EveryoneSocialEnvironment;
import com.cjs.qa.selenium.ISelenium;
import com.cjs.qa.selenium.Page;

import cucumber.api.DataTable;

public class SignInPage extends Page
{
	public SignInPage(WebDriver webDriver)
	{
		super(webDriver);
	}

	// DOCUMENTATION
	// getEditEmail:
	// Gets the value of the [Email] Edit field.
	// setEditEmail:
	// Sets the value of the [Email] Edit field.
	// clickButtonLogin:
	// Clicks the [Login] Button.
	// getEditPassword:
	// Gets the value of the [Password] Edit field.
	// setEditPassword:
	// Sets the value of the [Password] Edit field.
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
		return By.xpath(".//*[@id='email']");
	}

	public By getByEditPassword()
	{
		return By.xpath(".//*[@id='password']");
	}

	public By getByButtonLogin()
	{
		return By.xpath(".//input[@value='Log in']");
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

	public void clickButtonLogin()
	{
		clickObject(getByButtonLogin());
		By byEndTour = By.xpath(".//button[.='End Tour']");
		if (objectExists(byEndTour, new Page(webDriver).TIMEOUT_ELEMENT))
			;
		{
			clickObject(byEndTour);
		}
	}

	public boolean isButtonLoginDisplayed()
	{
		return isDisplayed(getByButtonLogin());
	}

	public boolean isButtonLoginEnabled()
	{
		return isEnabled(getByButtonLogin());
	}

	public void load() throws QAException
	{
		maximizeWindow();
		Environment.sysOut("Loading:[" + EveryoneSocialEnvironment.URL_LOGIN + "]");
		webDriver.get(EveryoneSocialEnvironment.URL_LOGIN);
		captureScreenshot();
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

	public void login(String emailAddress, String password) throws Throwable
	{
		load();
		setEditEmail(emailAddress);
		setEditPassword(password);
		clickButtonLogin();
	}
}