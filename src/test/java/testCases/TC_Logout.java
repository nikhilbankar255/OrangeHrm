package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageObject.LogoutPage;

public class TC_Logout extends BaseClass {

	@Test
	public void testLogout() {
		LogoutPage page = new LogoutPage(driver);
		page.logout();
		Assert.assertEquals(page.validateLogoutSuccess(), "Login", "Logout Failed .. ");
	}
}
