package Tutorial.SeleniumAutomation;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Tutorial.SeleniumAutomation.Page.ClickEventsPage;

public class ClickEventsTest extends Base {

	ClickEventsPage clickEventsPage = new ClickEventsPage();

	@BeforeTest
	public void intializeBrowser() {
		browserSetup("http://demoqa.com/buttons");
	}

	@Test(priority=0)
	public void clickOnButton() {
		clickEventsPage.singleclick();
	}

	@Test(priority=1)
	public void rightClickOnButton() {
		clickEventsPage.rightClick();
	}

	@Test(priority=2)
	public void doubleClickOnButton() {
		clickEventsPage.doubleClick();
		;
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
