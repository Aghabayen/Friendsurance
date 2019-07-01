package page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCategoryPage {
	WebDriver driver;

	public AddCategoryPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "name")
	WebElement getNameInput;

	public WebElement getDayInput() {
		return getNameInput;
	}

	@FindBy(id = "submit")
	WebElement getSubmitButton;

	public WebElement getSubmitButton() {
		return getSubmitButton;
	}
	
	
}
