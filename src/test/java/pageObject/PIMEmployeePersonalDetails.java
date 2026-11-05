package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.Actionsutility;
import utilities.Waitutility;

public class PIMEmployeePersonalDetails extends BasePage{

	Waitutility util;
	public static String responseId;
	public PIMEmployeePersonalDetails(WebDriver driver) {
		super(driver);
		util= new Waitutility();
	}

	@FindBy(xpath = "//label[text()='Employee Id']//parent::div//following-sibling::div//input")
	WebElement employeeId;

	@FindBy(xpath = "//label[text()='Nationality']//parent::div//following-sibling::div")
	WebElement nationalityDropdown;

	@FindBy(xpath = "//span[text()='Indian']")
	WebElement country;
	
	@FindBy(xpath = "//label[normalize-space()='Male']")
	WebElement radioBtn;
	
	@FindBy(xpath = "//div[@class='oxd-form-actions']//button[text()=' Save ']")
	WebElement saveBtn;
	
	@FindBy(xpath = "//p[text()='Successfully Updated']")
	WebElement successMsg;
	
	public void employeePersonalDetails(String name)
	{
		util.waitforElementClickable(driver, employeeId);
		String responseId = employeeId.getText();
		System.out.println(responseId);
		
		util.waitforElementClickable(driver, nationalityDropdown);
		nationalityDropdown.click();
		
		country.click();
		
		util.waitforElementClickable(driver, radioBtn);
		Actionsutility.moveToelement(driver, radioBtn);
		
		util.waitforElementClickable(driver, saveBtn);
		saveBtn.click();
	}
	
	public String validateSuccessMessage()
	{
		util.waitforElementVisiblity(driver, successMsg);
		return successMsg.getText();
	}
}
