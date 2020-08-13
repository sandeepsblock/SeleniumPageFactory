package Tutorial.SeleniumAutomation;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class IframeTest extends Base {
	
	IframePage iframePage = new IframePage();

	@BeforeTest
	public void initialize() {
		browserSetup("https://demoqa.com/frames");

	}

	@Test
	public void iFrameHandle() {

		iframePage.intiliazeElement();
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
