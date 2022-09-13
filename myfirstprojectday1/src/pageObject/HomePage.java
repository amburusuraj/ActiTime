package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.SeleniumUtils;

public class HomePage 
{
	@FindBy(xpath = "//div[text()='Tasks']")public WebElement tasksTab;
	@FindBy(xpath = "(//div[text()='All Customers'])[2]")public WebElement allCustomers;
	@FindBy(xpath = "//a[text()='Logout']")public WebElement logOutLink;
	
	
	public void logout()
	{
		if(logOutLink.isDisplayed() && logOutLink.isEnabled())
		{
			logOutLink.click();
		}
	}
	
	
	public void navigateToTasksTab()
	{
		tasksTab.click();
		SeleniumUtils.waitTillElementVisible(allCustomers);
	
	}

}
