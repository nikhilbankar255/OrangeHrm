package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import baseClass.BaseClass;
import pageObject.OrangeLogin;
import utilities.DataProviders;

public class TC_OrangeLogin extends BaseClass {

//	@Test(dataProvider = "loginData")
//	public void login(String uname, String pwd)
//	{
//		OrangeLogin login = new OrangeLogin(driver);
//		login.orangeLogin(uname, pwd);
//	}
//	
//	@DataProvider(name= "loginData")
//	public Object[][] getData()
//	{
//		String path = System.setProperty("user.dir", path)+"/Orange/data.xlsx";
//		
//	}

	@Test(dataProvider = "excelData", dataProviderClass = DataProviders.class)
	public void loginTest(String username, String password) {

		OrangeLogin lp = new OrangeLogin(driver);
		lp.orangeLogin(username, password);
		Assert.assertEquals(lp.validateHomepage(), "Dashboard", "Not on Dashboard after login");
	}
}
