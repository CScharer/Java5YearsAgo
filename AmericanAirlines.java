package com.cjs.qa.bts.pages;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.cjs.qa.core.Environment;
import com.cjs.qa.jdbc.SQL;
import com.cjs.qa.selenium.ISelenium;
import com.cjs.qa.selenium.Page;

import cucumber.api.DataTable;

public class LoginPage extends Page
{
	public LoginPage(WebDriver webDriver)
	{
		super(webDriver);
	}

	private final By	editUserName	= By.id("username");
	private final By	editPassword	= By.id("password");
	private final By	buttonSubmit	= By.id("//button[.='Submit']");
	public final String	PAGE_TITLE		= "LoginPage";
	public final String	LOGIN_TITLE		= "Login";

	public void verifyPage()
	{
		verifyTitle(PAGE_TITLE);
	}

	public void setEditUserName(String value)
	{
		setEdit(editUserName, value);
	}

	public String getEditUserName()
	{
		return getEdit(editUserName);
	}

	public void setEditPassword(String value)
	{
		setEditPassword(editPassword, value);
	}

	public String getEditPassword()
	{
		return getEdit(editPassword);
	}

	public void clickButtonSubmit()
	{
		clickObject(buttonSubmit);
		// getWebElement(editPassword).sendKeys(Keys.ENTER);
	}

	public void populatePageCuke(DataTable table)
	{
		populatePage(table);
		clickButtonSubmit();
	}

	public void populatePage(DataTable table)
	{
		final List<List<String>> data = table.raw();
		for (final List<?> item : data)
		{
			final String field = (String) item.get(0);
			final String value = (String) item.get(1);
			if (!value.equals(""))
			{
				if (Environment.isLogAll())
				{
					Environment.sysOut(field + ": [" + value + "]");
				}
				switch (field.toLowerCase())
				{
					case "username":
						setEditUserName(value);
						break;
					case "password":
						setEditPassword(value);
						break;
					default:
						Environment.sysOut("[" + field + "]" + ISelenium.FIELD_NOT_CODED);
						break;
				}
			}
		}
	}

	public void validatePage(DataTable table)
	{
		final Map<String, String> expected = new HashMap<>();
		final Map<String, String> actual = new HashMap<>();
		final List<List<String>> data = table.raw();
		for (final List<?> item : data)
		{
			final String field = (String) item.get(0);
			final String value = (String) item.get(1);
			if (!value.equals(""))
			{
				expected.put(field, value);
				switch (field.toLowerCase())
				{
					case "username":
						actual.put(field, getEditUserName());
						break;
					case "password":
						actual.put(field, getEditPassword());
						break;
					default:
						Environment.sysOut("[" + field + "]" + ISelenium.FIELD_NOT_CODED);
						break;
				}
			}
		}
		Assert.assertSame(PAGE_TITLE + " validatePage", expected, actual);
	}
}