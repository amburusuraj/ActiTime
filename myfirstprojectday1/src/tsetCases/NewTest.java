package tsetCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.TaskPage;
import utilities.BaseClass;
import utilities.ExcelLib;
import utilities.Screenshots;

@Listeners(Screenshots.class)
public class NewTest extends BaseClass
{
  @Test
  public void createCustomerTest() throws Exception
	{
		HomePage hp=PageFactory.initElements(BaseClass.driver, HomePage.class);
		hp.navigateToTasksTab();
		Reporter.log("Navigation to Tasks Tab is Success",true);
		ExcelLib exe=new ExcelLib();
		String customerName=exe.readStringData("customer", 4, 0);
		TaskPage tp=PageFactory.initElements(BaseClass.driver, TaskPage.class);
		tp.createCustomer(customerName);
		Reporter.log("Customer Created Success",true);
	}
}
