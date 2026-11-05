package baseClass;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	public ExtentReports extent;
	public ExtentTest test;

	String timeStamp=LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HHmmss"));
	@BeforeSuite
	public void setupReport() {
		ExtentSparkReporter reporter = new ExtentSparkReporter("Reports/AutomationReport_"+timeStamp+".html");
		reporter.config().setDocumentTitle("Automation Test Report");
		reporter.config().setReportName("Selenium Test Results");

		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Nikhil Bankar");

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();

		driver.manage().window().maximize();
		driver.get(getUrl().getString("url"));

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	}

	public static  ResourceBundle getUrl()
	{
		ResourceBundle url = ResourceBundle.getBundle("Routes"); //name of the property file
		return url;
	}

//	@AfterMethod
//	public void tearDown(org.testng.ITestResult result) throws IOException {
//		if (result.getStatus() == ITestResult.FAILURE) {
//			test.fail("Test Failed: " + result.getThrowable());
//			String screenshotPath = takeScreenshot(result.getName());
//			test.addScreenCaptureFromPath(screenshotPath);
//		} else if (result.getStatus() == ITestResult.SUCCESS) {
//			test.pass("Test Passed");
//		}
//
//		driver.quit();
//	}

//	@AfterSuite
//	public void tearDown() {
//		if(driver!=null)
//		{
//			driver.quit();;
//		}
//		extent.flush();
//	}

//	public String takeScreenshot(String testName) throws IOException {
//		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
//		String path = "Reports/Screenshots/" + testName + "_" + timestamp + ".png";
//		FileHandler.createDir(new File("Reports/Screenshots"));
//		FileHandler.copy(src, new File(path));
//		return path;
//	}


}
