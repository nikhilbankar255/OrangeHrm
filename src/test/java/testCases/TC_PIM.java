package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import baseClass.BaseClass;
import net.datafaker.Faker;
import pageObject.PIMPage;
import utilities.DataProviders;
import utilities.FakerUtility;

public class TC_PIM extends BaseClass{

	PIMPage page;
	@Test(priority = 1)
	public void testValidatePIMPage()
	{
		page = new PIMPage(driver);
		Assert.assertEquals(page.validatePim(), "Employee Information","Failed to load PIM Page");
	}
	
	@Test(priority = 2,dataProvider = "excelEmpData", dataProviderClass = DataProviders.class)
	public void testAddEmployee(String name, String lastName)
	{
		page.addEmployee(name, lastName);
		Assert.assertEquals(page.validateSuccessMsg(), "Successfully Saved","Failed to create Employee");
	}
}
