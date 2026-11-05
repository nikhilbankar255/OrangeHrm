package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageObject.PIMEmployeeContactDetails;

public class TC_PIMContactDetails extends BaseClass{

	@Test
	public void testAddContactDetails()
	{
		PIMEmployeeContactDetails page= new PIMEmployeeContactDetails(driver);
		page.contactDetailsBtn();
		Assert.assertEquals(page.validateContactDetailsPage(),"Contact Details","Not on Contact Details page..X");
		
		page.addContactDetails();
		Assert.assertEquals(page.validateSuccessMsg(),"Successfully Updated","Contact details failed to save..");
	}
}
