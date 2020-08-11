package Tutorial.SeleniumAutomation;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Tutorial.SeleniumAutomation.Page.WindowHandlingPage;

public class WindowHandlingTest extends Base {
	
	WindowHandlingPage windowHandlingPage = new WindowHandlingPage();
	@BeforeTest
	public void initialize() {
		browserSetup("http://www.demoqa.com/browser-windows");

	}

	@Test
	public void handleWindow() throws InterruptedException {
		windowHandlingPage.openAndCloseWindow() ;

	}

	@AfterMethod
	public void chechStatus(ITestResult result) {
		String testCaseName = result.getName();
		if (ITestResult.FAILURE == result.getStatus()) {
			captureScreenshot(testCaseName);
		}
	

	}
	
	@AfterTest
	public void close()
	{
		tearDown();
	}

}