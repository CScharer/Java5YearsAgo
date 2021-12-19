package com.cjs.qa.dropbox.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.cjs.qa.core.Environment;
import com.cjs.qa.core.QAException;
import com.cjs.qa.core.security.EPasswords;
import com.cjs.qa.dropbox.DropboxEnvironment;
import com.cjs.qa.selenium.Page;
import com.cjs.qa.utilities.CJSConstants;

public class SignInPage extends Page
{
	public SignInPage(WebDriver webDriver)
	{
		super(webDriver);
	}

	By			checkboxRememberMeInput	= By.xpath(".//*[@name='remember_me']");
	final By	checkboxRememberMe		= By.xpath(".//*[@name='remember_me']/..");
	final By	editEmail				= By.xpath(".//*[@name='login_email']");
	final By	editPassword			= By.xpath(".//*[@name='login_password']");
	final By	buttonNext				= By.xpath(".//input[@value='Next']");
	final By	buttonSignIn			= By.xpath(".//button[@id='sign-up-in']");
	final By	buttonSignInRegular		= By.xpath(".//button[contains(@class,'signin-button')][@type='submit']");
	final By	buttonSignInWithGoogle	= By.xpath(".//button[contains(@class,'auth-google')][@type='button']");

	public void buttonNextClick() throws QAException
	{
		if (objectExists(buttonNext))
		{
			clickObject(buttonNext);
		}
	}

	public void buttonSignInClick() throws QAException
	{
		if (objectExists(buttonSignIn))
		{
			clickObject(buttonSignIn);
		}
	}

	public void buttonSignInRegularClick() throws QAException
	{
		if (objectExists(buttonSignInRegular))
		{
			clickObject(buttonSignInRegular);
		}
	}

	public void buttonSignInWithGoogleClick() throws QAException
	{
		if (objectExists(buttonSignInWithGoogle))
		{
			clickObject(buttonSignInWithGoogle);
		}
	}

	public void CheckboxRememberMeSet(String value) throws QAException
	{
		if (objectExists(checkboxRememberMe))
		{
			setCheckbox(checkboxRememberMeInput, value);
		}
	}

	@Override
	protected void setCheckbox(By by, String value)
	{
		if (Environment.isLogAll())
		{
			Environment.sysOut("({Field}" + checkboxRememberMe.toString() + ", {Value}" + value + ");");
		}
		switch (value.toLowerCase())
		{
			case "checked":
				if (getCheckbox(checkboxRememberMeInput) != value)
				{
					getWebDriver().findElement(checkboxRememberMe).click();
				}
				break;
			case "unchecked":
				if (getCheckbox(checkboxRememberMeInput) != value)
				{
					getWebDriver().findElement(checkboxRememberMe).click();
				}
				break;
			default:
				Environment.sysOut("The value [" + value + "] is not supported for a Checkbox.");
				break;
		}
		if (getCheckbox(checkboxRememberMeInput) != value)
		{
			Environment.sysOut(
					"The value [" + value + "] was not selected for Checkbox [" + checkboxRememberMe.toString() + "].");
		}
	}

	@Override
	protected String getCheckbox(By by)
	{
		String value;
		value = getWebDriver().findElement(by).getAttribute("aria-checked");
		if (value.equals("false"))
		{
			value = "unchecked";
		} else
		{
			value = "checked";
		}
		if (Environment.isLogAll())
		{
			Environment.sysOut("({Field}" + by.toString() + ", {Value}" + value + ");");
		}
		return value;
	}

	public void editEmailSet(String value) throws QAException
	{
		if (objectExists(editEmail))
		{
			setEdit(editEmail, value);
		}
	}

	public void editPasswordSet(String value) throws QAException
	{
		if (objectExists(editPassword))
		{
			setEdit(editPassword, value);
		}
	}

	public void load() throws QAException
	{
		maximizeWindow();
		Environment.sysOut("Loading:[" + DropboxEnvironment.URL_LOGIN + "]");
		webDriver.get(DropboxEnvironment.URL_LOGIN);
	}

	public void signIn(String value) throws QAException
	{
		editEmailSet(value);
		buttonNextClick();
	}

	public void signInToVerifyActiveAccount(String eMail) throws QAException
	{
		load();
		buttonSignInClick();
		editEmailSet(eMail);
		editPasswordSet(EPasswords.DROPBOX.getValue());
		if (eMail.equalsIgnoreCase(CJSConstants.EMAIL_ADDRESS_DROPBOX))
		{
			CheckboxRememberMeSet("checked");
		} else
		{
			CheckboxRememberMeSet("unchecked");
		}
		// buttonSignInRegularClick();
	}

	public void solveCaptcha() throws QAException
	{
		// ...
	}
}