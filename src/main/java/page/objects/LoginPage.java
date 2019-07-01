package page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='login']")
	WebElement getLoginInput;

	public WebElement getLoginInput() {
		return getLoginInput;
	}
	
	@FindBy(xpath = "//input[@id='password']")
	WebElement getPasswordInput;

	public WebElement getPasswordInput() {
		return getPasswordInput;
	}
	
	@FindBy(xpath = "//a[@href='register.jsp']")
	WebElement getRegisterLink;

	public WebElement getRegisterLink() {
		return getRegisterLink;
	}
	
	
}
