package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.SeleniumUtils;

public class TaskPage 
{

	@FindBy(xpath = "//div[text()='Add New']")public WebElement addNewBtn;
	@FindBy(xpath = "//div[contains(text(),'New Customer')]")public WebElement newCustomerBtn;
	@FindBy(xpath = "(//input[@placeholder='Enter Customer Name'])[2]")public WebElement customerNameTextBox;
	@FindBy(xpath = "//div[text()='Create Customer']")public WebElement createcustomerBtm;
	
	public void createCustomer(String customerName)
	{
		addNewBtn.click();
		newCustomerBtn.click();
		SeleniumUtils.waitTillElementVisible(customerNameTextBox);
		SeleniumUtils.enterValue(customerNameTextBox, customerName);
		createcustomerBtm.click();
	}

}
