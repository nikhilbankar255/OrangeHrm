package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.FakerUtility;
import utilities.Waitutility;

public class PIMEmployeeContactDetails extends BasePage{

	Waitutility util;
	public PIMEmployeeContactDetails(WebDriver driver) {
		super(driver);
		util= new Waitutility();
	}

	@FindBy(xpath = "//a[text()='Contact Details']")
	WebElement contactDetailsBtn;
	
	@FindBy(xpath = "//h6[text()='Contact Details']")
	WebElement contactDetailsPage;
	
	@FindBy(xpath = "//label[text()='Street 1']//parent::div//following-sibling::div//input")
	WebElement addressField;
	
	@FindBy(xpath = "//label[text()='City']//parent::div//following-sibling::div//input")
	WebElement cityField;
	
	@FindBy(xpath = "//label[text()='Mobile']//parent::div//following-sibling::div//input")
	WebElement MobileField;
	
	@FindBy(xpath = "//label[text()='Work Email']//parent::div//following-sibling::div//input")
	WebElement emailField;
	
	@FindBy(xpath = "//div[@class='oxd-form-actions']//button")
	WebElement saveBtn;
	
	@FindBy(xpath = "//p[text()='Successfully Updated']")
	WebElement successMsg;
	
	public void contactDetailsBtn()
	{
		util.waitforElementClickable(driver, contactDetailsBtn);
		contactDetailsBtn.click();
	}
	
	public String validateContactDetailsPage()
	{
		util.waitforElementVisiblity(driver, contactDetailsPage);
		return contactDetailsPage.getText();
	}
	
	public void addContactDetails()
	{
		util.waitforElementClickable(driver, addressField);
		addressField.sendKeys(FakerUtility.fakeAddress());
		util.waitforElementClickable(driver, cityField);
		cityField.sendKeys(FakerUtility.fakeCity());
		util.waitforElementClickable(driver, MobileField);
		MobileField.sendKeys(FakerUtility.fakePhoneNumber());
		util.waitforElementClickable(driver, emailField);
		emailField.sendKeys(FakerUtility.fakeEmail());
		util.waitforElementClickable(driver, saveBtn);
		saveBtn.click();
	}
	
	public String validateSuccessMsg()
	{
		util.waitforElementVisiblity(driver, successMsg);
		return successMsg.getText();
	}
}
