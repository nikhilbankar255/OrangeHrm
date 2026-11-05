package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.Waitutility;

public class PIMEmployeeJob extends BasePage{

	Waitutility util;
	public PIMEmployeeJob(WebDriver driver) {
		super(driver);
		util= new Waitutility();
	}
	
	@FindBy(xpath = "//a[text()='Job']")
	WebElement jobBtn;
	
	@FindBy(xpath = "//h6[text()='Job Details']")
	WebElement jobDetailsPage;
	
	@FindBy(xpath = "//label[text()='Job Title']//parent::div//following-sibling::div")
	WebElement jobTitleDropdown;
	
	@FindBy(xpath = "//span[text()='Automaton Tester']")
	WebElement role;
	
	@FindBy(xpath = "//label[text()='Employment Status']//parent::div//following-sibling::div")
	WebElement empStatusDropdown;
	
	@FindBy(xpath = "//span[text()='Full-Time Contract']")
	WebElement jobDuration;
	
	@FindBy(xpath = "//div[@class='oxd-form-actions']//button")
	WebElement saveBtn;
	
	@FindBy(xpath = "//p[text()='Successfully Updated']")
	WebElement sucessMsg;
	
	public void jobBtn()
	{
		util.waitforElementClickable(driver, jobBtn);
		jobBtn.click();
	}
	
	public String validatejobDetailsPage()
	{
		util.waitforElementVisiblity(driver, jobDetailsPage);
		return jobDetailsPage.getText();
	}
	
	public void addJobDetails()
	{
		util.waitforElementClickable(driver, jobTitleDropdown);
		jobTitleDropdown.click();
		
		role.click();
		empStatusDropdown.click();
		jobDuration.click();
		saveBtn.click();
	}
	
	public String validateSuccessMsg()
	{
		util.waitforElementVisiblity(driver, sucessMsg);
		return sucessMsg.getText();
	}
}
