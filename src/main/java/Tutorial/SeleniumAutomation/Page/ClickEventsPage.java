package Tutorial.SeleniumAutomation.Page;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Tutorial.SeleniumAutomation.Base;

public class ClickEventsPage extends Base {
	public static org.apache.logging.log4j.Logger log = LogManager.getLogger(ClickEventsPage.class.getName());

	@FindBy(xpath = "//button[text()='Click Me']")
	public WebElement singleClickButton;
	@FindBy(xpath = "//p[text()='You have done a dynamic click']")
	public WebElement singleClickButtonText;
	@FindBy(id = "rightClickBtn")
	public WebElement rightClickButton;
	@FindBy(xpath = "//p[text()='You have done a right click']")
	public WebElement rightClickButtonText;
	@FindBy(id = "doubleClickBtn")
	public WebElement doubleClickButton;
	@FindBy(xpath = "//p[text()='You have done a double click']")
	public WebElement doubleClickButtonText;

	public void singleclick() {
		log.info("single click on button");
		PageFactory.initElements(driver, this);
		click(singleClickButton);
		log.info("Checking for the text");
		verifyElementPresent(singleClickButtonText);

	}

	public void rightClick() {
		log.info("right click on button");
		PageFactory.initElements(driver, this);
		rightClick(rightClickButton);
		log.info("Checking for the text");
		verifyElementPresent(rightClickButtonText);

	}

	public void doubleClick() {
		log.info("double click on button");
		PageFactory.initElements(driver, this);
		doubleClick(doubleClickButton);
		log.info("Checking for the text");
		verifyElementPresent(doubleClickButtonText);

	}

}
