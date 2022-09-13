package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.Constants;
import utilities.SeleniumUtils;

public class LoginPage 
{
	@FindBy(id="username")public WebElement userNameTXtBox;
	@FindBy(name="pwd")public WebElement passwordTXtBox;
	@FindBy(id="loginButtonContainer")public WebElement loginButton;
	@FindBy(xpath ="(//div[text()='Switch to actiPLANS'])[1]")public WebElement loginIdentifer;
	

	
	public void login()
	{
		SeleniumUtils.enterValue(userNameTXtBox, Constants.USERNAME);
		SeleniumUtils.enterValue(passwordTXtBox, Constants.PASSWORD);
		loginButton.click();
		SeleniumUtils.waitTillElementVisible(loginIdentifer);
	}
}
