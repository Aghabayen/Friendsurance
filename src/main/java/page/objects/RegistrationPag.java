package page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPag {
	WebDriver driver;

	public RegistrationPag(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='login']")
	WebElement getUserNameInput;

	public WebElement getUserNameInput() {
		return getUserNameInput;
	}
	
	@FindBy(xpath = "//input[@id='password1']")
	WebElement getPasswordInput;

	public WebElement getPasswordInput() {
		return getPasswordInput;
	}
	
	@FindBy(xpath = "//input[@id='password2']")
	WebElement getRepeatPasswordInput;

	public WebElement getRepeatPasswordInput() {
		return getRepeatPasswordInput;
	}
	
	@FindBy(xpath = "//input[@id='submit']")
	WebElement getRegisterButton;

	public WebElement getRegisterButton() {
		return getRegisterButton;
	}
	
	
}
