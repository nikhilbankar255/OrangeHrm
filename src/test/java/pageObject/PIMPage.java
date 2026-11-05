package pageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.Actionsutility;
import utilities.FakerUtility;
import utilities.Waitutility;

public class PIMPage extends BasePage{

	Waitutility util;
	public PIMPage(WebDriver driver)
	{
		super(driver);
		 util= new Waitutility();
	}
	
	@FindBy(xpath = "//span[text()='PIM']")
	WebElement pimBtn;

	@FindBy(xpath = "//h5[text()='Employee Information']")
	WebElement pimPage;

	@FindBy(xpath = "//div[@class='orangehrm-header-container']//button")
	WebElement addBtn;
	
	@FindBy(xpath = "//input[@name='firstName']")
	WebElement nameField;

	@FindBy(xpath = "//input[@name='lastName']")
	WebElement lastnameField;
	
	@FindBy(xpath = "//label[text()='Employee Id']//parent::div//following-sibling::div//input")
	WebElement empField;
	
	@FindBy(xpath = "//button[text()=' Save ']")
	WebElement saveBtn;
	
	@FindBy(xpath = "//p[text()='Successfully Saved']")
	WebElement successMsg;

	public String validatePim()
	{
		util.waitforElementClickable(driver, pimBtn);
		pimBtn.click();
		util.waitforElementVisiblity(driver, pimPage);
		return pimPage.getText();
	}
	
	public void addEmployee(String name, String lastName)
	{
		util.waitforElementClickable(driver, addBtn);
		addBtn.click();
		
		util.waitforElementClickable(driver, nameField);
		nameField.sendKeys(name);
		
		lastnameField.sendKeys(lastName);
		util.waitforElementVisiblity(driver, empField);
//		empField.sendKeys(Keys.CONTROL + "a");
//		empField.sendKeys(Keys.BACK_SPACE);		

		util.waitforElementClickable(driver, saveBtn);
		saveBtn.click();
	}
	
	public String validateSuccessMsg()
	{
		util.waitforElementVisiblity(driver, successMsg);
		return successMsg.getText();
	}
	
	
}
