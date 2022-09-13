package utilities;

import java.awt.List;
import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumUtils 
{
	public static void pageload(long time)
	{
		BaseClass.driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
	
	public static void selectOptionByIndex(WebElement element,int index)
	{
		Select s=new Select(element);
		s.selectByIndex(index);
	}
	
	public static void selectOptionByText(WebElement element,String text)
	{
		Select s=new Select(element);
		s.selectByVisibleText(text);
	}
	
	public static void mouseHovering(WebElement element)
	{
		Actions act=new Actions(BaseClass.driver);
		act.moveToElement(element).perform();
	}
	
	public static void enterValue(WebElement element,String value)
	{
		if(element.isDisplayed() && element.isEnabled())
		{
			element.sendKeys(value);
		}
	}
	
	public static void pressEnter()
	{
		Actions act=new Actions(BaseClass.driver);
		act.sendKeys(Keys.ENTER).perform();
	}
	
	public static void acceptAlert()
	{
		Alert alt=BaseClass.driver.switchTo().alert();
		alt.accept();
	}
	
	public static void dismissAlert()
	{
		Alert alt=BaseClass.driver.switchTo().alert();
		alt.dismiss();
	}
	
	public static String getAlertMsg()
	{
		Alert alt=BaseClass.driver.switchTo().alert();
		
		return alt.getText();
	}
	
	public static void waitForVisibilityAndClick(int time,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(BaseClass.driver, time);
		wait.until(ExpectedConditions.visibilityOf(element)).click();
	}
	
	public static void dragAndDrop(WebElement src,WebElement des)
	{
		Actions act=new Actions(BaseClass.driver);
		act.dragAndDrop(src, des).perform();
	}
	
	public static void rightClick(WebElement wb)
	{
		Actions act=new Actions(BaseClass.driver);
		act.contextClick(wb).perform();
	}
	
	public static void deselectAll(WebElement element)
	{
		Select s=new Select(element);
		s.deselectAll();
	}
	
	public static java.util.List<WebElement> fetchAllOptions(WebElement wb)
	{
		Select sel=new Select(wb);
		
		return sel.getOptions();
	}
	
	public static WebElement fetchFirstSelectedOption(WebElement element)
	{
		Select sel=new Select(element);
		
		return sel.getFirstSelectedOption();
	}
	
	public static java.util.List<WebElement> fetchAllSelectedOptions(WebElement wb)
	{
		Select sel=new Select(wb);
		
		return sel.getAllSelectedOptions();
	}
	
	public static Point fetchLocation(WebElement element)
	{
		Point p=element.getLocation();
		
		return p;
	}
	
	public static String fetchAttribute(WebElement element,String attribute)
	{
		String value=element.getAttribute(attribute);
		
		return value;
	}
	
	public static String fetchCssValue(WebElement wb,String name)
	{
		String result=wb.getCssValue(name);
		
		return result;
	}
	
	public static void switchFrameUsingIndex(int index)
	{
		BaseClass.driver.switchTo().frame(index);
	}
	
	public static void switchFrameUsingName(String name)
	{
		BaseClass.driver.switchTo().frame(name);
	}
	
	public static void switchFrameUsingWebElement(WebElement element)
	{
		BaseClass.driver.switchTo().frame(element);
	}
	
	public static void switchFrameByDefault()
	{
		BaseClass.driver.switchTo().defaultContent();
	}
	
	public static String fetchText(WebElement wb)
	{
		return wb.getText();
	}
	
	public static Dimension fetchSize(WebElement element)
	{
		Dimension size=element.getSize();
		return size;
	}
	
	public static String fetchTitle()
	{
		return BaseClass.driver.getTitle();
	}
	
	public static String fetchTagName(WebElement wb)
	{
		return wb.getTagName();
	}
	
	public static void doubleClick(WebElement wb)
	{
		Actions act=new Actions(BaseClass.driver);
		act.doubleClick(wb);
	}
	
	public static void implicitWait(long time)
	{
		BaseClass.driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
	
	public static void javaWait(long time) throws Exception
	{
		Thread.sleep(time);
	}
	
	public static void waitTillElementVisible(WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(BaseClass.driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
}
