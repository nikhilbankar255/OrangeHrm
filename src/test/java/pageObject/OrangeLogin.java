package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.Waitutility;

public class OrangeLogin extends BasePage{

	Waitutility util;
	
	public OrangeLogin(WebDriver driver)
	{
		super(driver);
		util=new Waitutility();
	}
	
	@FindBy(xpath="//input[@name='username']")
	WebElement uname;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement pwd;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement submit;
	
	@FindBy(xpath = "//h6[text()='Dashboard']")
	WebElement dashboardtxt;
	
	public void orangeLogin(String username, String password)
	{
		util.waitforElementClickable(driver, uname);
		uname.sendKeys(username);
		pwd.sendKeys(password);
		submit.click();
	}
	
	public String validateHomepage() {
		System.out.println("On Homepage..");
		util.waitforElementVisiblity(driver, dashboardtxt);
		return dashboardtxt.getText();
	}
	
}
