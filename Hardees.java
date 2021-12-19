package com.cjs.qa.hardees.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.cjs.qa.core.Environment;
import com.cjs.qa.core.QAException;
import com.cjs.qa.hardees.HardeesEnvironment;
import com.cjs.qa.selenium.Page;
import com.cjs.qa.utilities.Constants;

public class SurveyPage extends Page
{
	public SurveyPage(WebDriver webDriver)
	{
		super(webDriver);
	}

	private final String	NODE_ROOT		= ".//*[@id='surveyQuestions']";
	final By				editCN1			= By.xpath(".//*[@id='CN1']");
	final By				editCN2			= By.xpath(".//*[@id='CN2']");
	final By				editCN3			= By.xpath(".//*[@id='CN3']");
	final By				editCN4			= By.xpath(".//*[@id='CN4']");
	final By				editCN5			= By.xpath(".//*[@id='CN5']");
	final By				editCN6			= By.xpath(".//*[@id='CN6']");
	final By				buttonStart		= By.xpath(".//*[@id='NextButton']");
	final By				buttonNext		= buttonStart;							// By.xpath(".//*[@id='NextButton']");
	final By				CheckboxAgree	= By.xpath("");
	final By				labelThankYou	= By.xpath("");

	public void editCN1Set(String value) throws QAException
	{
		setEdit(editCN1, value);
	}

	public void editCN2Set(String value) throws QAException
	{
		setEdit(editCN2, value);
	}

	public void editCN3Set(String value) throws QAException
	{
		setEdit(editCN3, value);
	}

	public void editCN4Set(String value) throws QAException
	{
		setEdit(editCN4, value);
	}

	public void editCN5Set(String value) throws QAException
	{
		setEdit(editCN5, value);
	}

	public void editCN6Set(String value) throws QAException
	{
		setEdit(editCN6, value);
	}

	public void optionDidYouVisistTheMcDonaldsLocatedAtSelect(String value) throws QAException
	{
		String xPath = NODE_ROOT;
		switch (value)
		{
			case "No":
				xPath += "//td[contains(text()," + Constants.QUOTE_DOUBLE + "Did you visit the McDonald's located at"
						+ Constants.QUOTE_DOUBLE + ")]/../td[@class='Opt2 inputtyperbloption']/span";
				break;
			case "Yes":
			default:
				xPath += "//td[contains(text()," + Constants.QUOTE_DOUBLE + "Did you visit the McDonald's located at"
						+ Constants.QUOTE_DOUBLE + ")]/../td[@class='Opt1 inputtyperbloption']/span";
				break;
		}
		final By optionDidYouVisit = By.xpath(xPath);
		clickObject(optionDidYouVisit);
	}

	public void optionOrderTypeSelect(String value) throws QAException
	{
		String xPath = NODE_ROOT;
		// By optionOrderType = By.xpath(NODE_ROOT);
		switch (value)
		{
			case "Carry out:":
			case "Dine-in":
			case "Drive-thru":
			default:
				xPath += "//label[.='" + value + "']";
				break;
		}
		final By optionOrderType = By.xpath(xPath);
		clickObject(optionOrderType);
	}

	public void optionOverallSatisfactionSelect(String value) throws QAException
	{
		String xPath = NODE_ROOT;
		// By optionOverallSatisfaction = By.xpath(NODE_ROOT);
		switch (value)
		{
			case "Highly Satisfied":
				xPath += ".//td[contains(text(),'Please rate your overall satisfaction with your experience at this')]/../td[@class='Opt5 inputtyperbloption']/span";
				break;
			case "Satisfied":
				xPath += ".//td[contains(text(),'Please rate your overall satisfaction with your experience at this')]/../td[@class='Opt4 inputtyperbloption']/span";
				break;
			case "Neither Satisfied nor Dissatisfied":
				xPath += ".//td[contains(text(),'Please rate your overall satisfaction with your experience at this')]/../td[@class='Opt3 inputtyperbloption']/span";
				break;
			case "Dissatisfied":
				xPath += ".//td[contains(text(),'Please rate your overall satisfaction with your experience at this')]/../td[@class='Opt2 inputtyperbloption']/span";
				break;
			case "Highly Dissatisfied":
				xPath += ".//td[contains(text(),'Please rate your overall satisfaction with your experience at this')]/../td[@class='Opt1 inputtyperbloption']/span";
				break;
			default:
				xPath += ".//td[contains(text(),'Please rate your overall satisfaction with your experience at this')]/../td[@class='Opt3 inputtyperbloption']/span";
				break;
		}
		final By optionOverallSatisfaction = By.xpath(xPath);
		clickObject(optionOverallSatisfaction);
	}

	public void optionsSatisfactionSelect() throws QAException
	{
		final String xPath = "//td[@class='Opt4 inputtyperbloption']";
		final By optionsSatisfaction = By.xpath(xPath);
		final List<WebElement> webElements = webDriver.findElements(optionsSatisfaction);
		for (final WebElement webElement : webElements)
		{
			clickObject(webElement);
		}
	}

	public void optionDidYouExerienceAProblemDuringYourVisitSelect(String value) throws QAException
	{
		String xPath = NODE_ROOT;
		switch (value)
		{
			case "No":
				xPath += "//td[contains(text(),'Did you experience a problem during your visit')]/../td[@class='Opt2 inputtyperbloption']/span";
				break;
			case "Yes":
			default:
				xPath += "//td[contains(text(),'Did you experience a problem during your visit')]/../td[@class='Opt1 inputtyperbloption']/span";
				break;
		}
		final By optionDidYouExerienceAProblemDuringYourVisit = By.xpath(xPath);
		clickObject(optionDidYouExerienceAProblemDuringYourVisit);
	}

	public void optionWereYouAskedToPullForwardSelect(String value) throws QAException
	{
		String xPath = NODE_ROOT;
		switch (value)
		{
			case "No":
				xPath += "//td[contains(text(),'Did you experience a problem during your visit')]/../td[@class='Opt2 inputtyperbloption']/span";
				break;
			case "Yes":
			default:
				xPath += "//td[contains(text(),'Did you experience a problem during your visit')]/../td[@class='Opt1 inputtyperbloption']/span";
				break;
		}
		final By optionWereYouAskedToPullForward = By.xpath(xPath);
		clickObject(optionWereYouAskedToPullForward);
	}

	public void setCheckboxAgree(String value) throws QAException
	{
		setCheckbox(CheckboxAgree, value);
	}

	public void buttonStartClick() throws QAException
	{
		clickObject(buttonStart);
	}

	public void buttonNextClick() throws QAException
	{
		clickObject(buttonNext);
	}

	public void load() throws QAException
	{
		maximizeWindow();
		Environment.sysOut("Loading:[" + HardeesEnvironment.URL_LOGIN + "]");
		webDriver.get(HardeesEnvironment.URL_LOGIN);
	}

	public void populate() throws QAException
	{
		load();
		editCN1Set("00398");
		editCN2Set("13430");
		editCN3Set("40217");
		editCN4Set("12099");
		editCN5Set("00153");
		editCN6Set("4");
		buttonStartClick();
		optionDidYouVisistTheMcDonaldsLocatedAtSelect("Yes");
		buttonNextClick();
		optionOrderTypeSelect("Drive-thru");
		buttonNextClick();
		// optionOverallSatisfactionSelect("Satisfied");
		optionsSatisfactionSelect();
		buttonNextClick();
		optionsSatisfactionSelect();
		buttonNextClick();
		optionsSatisfactionSelect();
		buttonNextClick();
		optionDidYouExerienceAProblemDuringYourVisitSelect("No");
		buttonNextClick();
		optionsSatisfactionSelect();
		buttonNextClick();
		buttonNextClick();
		optionWereYouAskedToPullForwardSelect("No");
		buttonNextClick();
	}
}