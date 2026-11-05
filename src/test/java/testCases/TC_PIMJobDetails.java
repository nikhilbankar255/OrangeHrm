package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageObject.PIMEmployeeJob;

public class TC_PIMJobDetails extends BaseClass{

	@Test
	public void testaddJobDetails()
	{
		PIMEmployeeJob page= new PIMEmployeeJob(driver);
		page.jobBtn();
		Assert.assertEquals(page.validatejobDetailsPage(),"Job Details", "Not on Job details page");
		
		page.addJobDetails();
		Assert.assertEquals(page.validateSuccessMsg(), "Successfully Updated","Failed to add job details");
	}
}
