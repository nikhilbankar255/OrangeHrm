package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import baseClass.BaseClass;
import pageObject.AdminPage;
import utilities.DataProviders;

public class TC_AddAdminRole extends BaseClass {

	@Test(dataProvider = "excelAdminData", dataProviderClass = DataProviders.class)
	public void testAddAdminRole(String userRole, String empName, String password, String confirmPwd) throws InterruptedException {
		AdminPage page = new AdminPage(driver);
		page.searchText(userRole);
		page.adminPage();
		page.addAdmin(empName, password, confirmPwd);

		Assert.assertEquals(page.validateSuccessMsg(), "Successfully Saved", "Admin Not created");
	}
}
