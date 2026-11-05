package pageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.FakerUtility;
import utilities.Waitutility;

public class AdminPage extends BasePage {

	Waitutility util;

	public AdminPage(WebDriver driver) {
		super(driver);
		util = new Waitutility();
	}

	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement searchField;

	@FindBy(xpath = "//span[text()='Admin']")
	WebElement adminBtn;

	@FindBy(xpath = "//h6[text()='Admin']")
	WebElement adminmgt;

	@FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
	WebElement addbtn;

	@FindBy(xpath = "//label[text()='User Role']//parent::div//following-sibling::div//div[@class='oxd-select-text-input']")
	WebElement userRoleDropdown;

	@FindBy(xpath = "//div[@role='listbox']//span[text()='Admin']")
	WebElement roleSelect;

	@FindBy(xpath = "//label[text()='Status']//parent::div//following-sibling::div//div[@class='oxd-select-text-input']")
	WebElement statusDropdown;

	@FindBy(xpath = "//span[text()='Enabled']")
	WebElement enableSelect;

	@FindBy(xpath = "//input[@placeholder='Type for hints...']")
	WebElement employeeName;

	@FindBy(xpath = "//label[text()='Username']//parent::div//following-sibling::div//input[@class='oxd-input oxd-input--active']")
	WebElement usernameField;

	@FindBy(xpath = "//label[text()='Password']//parent::div//following-sibling::div//input[@type='password']")
	WebElement pwd;

	@FindBy(xpath = "//label[text()='Confirm Password']//parent::div//following-sibling::div//input[@type='password']")
	WebElement confirmPassword;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement submitbtn;

	@FindBy(xpath = "//p[text()='Successfully Saved']")
	WebElement successMsg;

	public void searchText(String userRole) {
		util.waitforElementClickable(driver, searchField);
		searchField.sendKeys(userRole);
	}

	public void adminPage() {
		util.waitforElementVisiblity(driver, adminBtn);
		adminBtn.click();
	}

	public void addAdmin(String name, String password, String currentPassword) throws InterruptedException {

		util.waitforElementClickable(driver, addbtn);
		addbtn.click();
		System.out.println("In Add admin page");

		util.waitforElementClickable(driver, userRoleDropdown);
		userRoleDropdown.click();
		System.out.println("User Selected->" + roleSelect.getText());
		roleSelect.click();

		util.waitforElementClickable(driver, statusDropdown);
		statusDropdown.click();
		enableSelect.click();

		employeeName.sendKeys(name);
		Thread.sleep(2000);
		employeeName.sendKeys(Keys.ARROW_DOWN);
		employeeName.sendKeys(Keys.ENTER);

		usernameField.sendKeys(FakerUtility.fakeName());
		pwd.sendKeys(password);
		confirmPassword.sendKeys(currentPassword);
		submitbtn.click();
	}

	public String validateSuccessMsg() {
		util.waitforElementVisiblity(driver, successMsg);
		return successMsg.getText();
	}
}
