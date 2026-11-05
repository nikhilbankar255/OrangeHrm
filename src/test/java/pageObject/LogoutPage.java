package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.Waitutility;

public class LogoutPage extends BasePage {
	Waitutility util;

	public LogoutPage(WebDriver driver) {
		super(driver);
		util = new Waitutility();
	}

	@FindBy(xpath = "//p[@class='oxd-userdropdown-name']")
	WebElement logoutDropdown;

	@FindBy(xpath = "//a[text()='Logout']")
	WebElement logoutBtn;

	@FindBy(xpath = "//h5[text()='Login']")
	WebElement loginPage;

	public void logout() {
		util.waitforElementVisiblity(driver, logoutDropdown);
		logoutDropdown.click();
		util.waitforElementVisiblity(driver, logoutBtn);
		logoutBtn.click();
	}

	public String validateLogoutSuccess() {
		util.waitforElementVisiblity(driver, loginPage);
		return loginPage.getText();
	}
}
