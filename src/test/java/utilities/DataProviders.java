package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	 @DataProvider(name = "excelData")
	    public Object[][] excelDataProvider() throws IOException {
	        return ExcelUtility.getData("src/test/resources/data.xlsx", "login");
	    }
	 
	 @DataProvider(name = "excelAdminData")
	    public Object[][] excelUserDataProvider() throws IOException {
	        return ExcelUtility.getData("src/test/resources/data.xlsx", "admin");
	    }
	 
	 @DataProvider(name = "excelEmpData")
	    public Object[][] excelEmpDataProvider() throws IOException {
	        return ExcelUtility.getData("src/test/resources/data.xlsx", "emp");
	    }
	 
	 @DataProvider(name = "excelPersonalDetailsData")
	    public Object[][] excelPersonalDetailsDataProvider() throws IOException {
	        return ExcelUtility.getData("src/test/resources/data.xlsx", "personalDetails");
	    }
}
