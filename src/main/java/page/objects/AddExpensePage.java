package page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddExpensePage {
	WebDriver driver;

	public AddExpensePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "day")
	WebElement getDayInput;

	public WebElement getDayInput() {
		return getDayInput;
	}
	
	@FindBy(id = "month")
	WebElement getMonthInput;

	public WebElement getMonthInput() {
		return getMonthInput;
	}
	
	@FindBy(id = "year")
	WebElement getYearInput;

	public WebElement getYearInput() {
		return getYearInput;
	}
	
	@FindBy(id = "amount")
	WebElement getAmmountInput;

	public WebElement getAmmountInput() {
		return getAmmountInput;
	}
	
	@FindBy(id = "reason")
	WebElement getResonInput;

	public WebElement getResonInput() {
		return getResonInput;
	}
	
	@FindBy(id = "submit")
	WebElement getSubmitInput;

	public WebElement getSubmitInput() {
		return getSubmitInput;
	}
	
	@FindBy(id = "category")
	WebElement getCategoryInput;

	public WebElement getCategoryInput() {
		return getCategoryInput;
	}
}
