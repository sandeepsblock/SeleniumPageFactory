package Tutorial.SeleniumAutomation;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Tutorial.SeleniumAutomation.Base;

public class IframePage extends Base{
	
	@FindBy(id="frame1")
	public WebElement iFrame1;
	@FindBy(xpath="//h1[@id=\"sampleHeading\"]")
	public WebElement contentHeader;
	
	public void intiliazeElement() {
		PageFactory.initElements(driver, this);
		driver.switchTo().frame(iFrame1);
		System.out.println(getVisibleText(contentHeader));
	}

}
