
package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import pageObject.HomePage;
import pageObject.LoginPage;



public class BaseClass 
{
	public static WebDriver driver;
	@Parameters({"browser"})
	@BeforeClass
	public void launchBrowser(String browser)
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\ambur\\OneDrive\\Desktop\\myfirstprojectday1\\Drivers\\chromedriver.exe");
			driver=new ChromeDriver(); 
		}
		else if(browser.equalsIgnoreCase("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\ambur\\OneDrive\\Desktop\\myfirstprojectday1\\Drivers\\chromedriver.exe");
			driver=new FirefoxDriver(); 
		}
		else if(browser.equalsIgnoreCase("Edge"))
		{
			System.setProperty("webdriver.edge.driver", "C:\\Users\\ambur\\OneDrive\\Desktop\\myfirstprojectday1\\Drivers\\chromedriver.exe");
			driver=new EdgeDriver(); 
		}
		else
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\ambur\\OneDrive\\Desktop\\myfirstprojectday1\\Drivers\\chromedriver.exe");
			driver=new ChromeDriver(); 
		}
		driver.get(Constants.URL);
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.manage().deleteAllCookies();
		driver.quit();
	}
	
	@BeforeMethod
	public void loginToApp() throws Exception
	{
		LoginPage lp=PageFactory.initElements(driver, LoginPage.class);
		lp.login();
		Reporter.log("Login Success",true); 
		
		
	}
	
	@AfterMethod
	public void logOutFromApp()
	{
		HomePage hp=PageFactory.initElements(driver, HomePage.class);
		hp.logout();
		Reporter.log("Logout is Success",true);
	}

}
