package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageObject.PIMEmployeePersonalDetails;
import utilities.DataProviders;

public class TC_PIMPersonalDetails extends BaseClass{

	@Test(dataProvider = "excelPersonalDetailsData", dataProviderClass = DataProviders.class)
	public void testPIMPersonalDetails(String name )
	{
		PIMEmployeePersonalDetails page= new PIMEmployeePersonalDetails(driver);
		page.employeePersonalDetails(name);
		Assert.assertEquals(page.validateSuccessMessage(),"Successfully Updated", "Failed to add Personal Details...");
	}
}
