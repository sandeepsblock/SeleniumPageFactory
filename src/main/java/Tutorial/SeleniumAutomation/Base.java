package Tutorial.SeleniumAutomation;

import java.io.File;
import java.io.IOException;
//import org.apache.*;
//import org.apache.commons.io.FileUtils;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.google.common.io.Files;

//import junit.framework.Assert;

public class Base {

	public static WebDriver driver;
	
	Utils utils = new Utils();

	public static String browserName = Utils.readConfigFile("Browser");
	public static org.apache.logging.log4j.Logger log = LogManager.getLogger(Base.class.getName());

	// Initialize Browser
	public static WebDriver browserSetup(String URL) {

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "Resource/Drivers/Chrome/chromedriver.exe");
			driver = new ChromeDriver();
			driver.get(URL);
			driver.manage().window().maximize();
			log.info("Chrome opened with URL");
		} else if (browserName.equals("firefox")) {
			driver = new FirefoxDriver();
			driver.get(URL);
			driver.manage().window().maximize();
			log.info("Firefox opened with URL");

		} else {
			log.error("Invalid Browser");
		}
		return driver;
	}

	// Closing Browser

	public void tearDown() {
		driver.quit();
		log.info("Closing browser");
	}

	// Taking screenshot
	public void captureScreenshot(String testCaseName) {
		try {
			TakesScreenshot screehshot = ((TakesScreenshot) driver);
			File srcFile = screehshot.getScreenshotAs(OutputType.FILE);
			File destFile = new File("Resource/Screenshots");
			Files.copy(srcFile, destFile);
			System.out.println(destFile.getAbsolutePath());
		} catch (IOException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}

		System.out.print("Screenshot Captured");
	}

	// click on element
	public void click(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
		} catch (Exception e) {
			log.error(e.getMessage());
			Assert.fail(e.getMessage());

		}

	}

	// Right click action
	public void rightClick(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		Actions action = new Actions(driver);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element));
			action.contextClick(element).perform();
		} catch (Exception e) {
			log.error(e.getMessage());
			Assert.fail(e.getMessage());

		}

	}

	// Double click action
	public void doubleClick(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		Actions action = new Actions(driver);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element));
			action.doubleClick(element).perform();
		} catch (Exception e) {
			log.error(e.getMessage());
			Assert.fail(e.getMessage());

		}

	}

	// Verify the presence of an element
	public void verifyElementPresent(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			log.error(e.getMessage());
			Assert.fail(e.getMessage());
		}
	}

}
