package Tutorial.SeleniumAutomation.Page;

import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Tutorial.SeleniumAutomation.Base;

public class WindowHandlingPage extends Base {

	public static org.apache.logging.log4j.Logger log = LogManager.getLogger(WindowHandlingPage.class.getName());

	@FindBy(id = "windowButton")
	public WebElement newWindowButton;
	@FindBy(id="messageWindowButton")
	public WebElement newWindowMessage;
	@FindBy(xpath="//body[1]")
	public WebElement content;

	public void openAndCloseWindow() throws InterruptedException {
		PageFactory.initElements(driver, this);
		String windowHandle = driver.getWindowHandle();
		log.info("Clicking new window button");
		click(newWindowButton);
		Set<String> windowHandles = driver.getWindowHandles();
		windowHandles.remove(windowHandle);
		windowHandle = windowHandles.iterator().next();
		log.info("Switching to new window");
		Thread.sleep(1000);
		driver.switchTo().window(windowHandle);
		log.info("maximizing window");
		//Thread.sleep(1000);
		driver.manage().window().maximize();
		log.info("Capturing text");
		System.out.println(content.getText());
	}

}
