package page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ListexpensesPage {
	WebDriver driver;

	public ListexpensesPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@id='editaccount']")
	WebElement getEidtAccountLink;

	public WebElement getEidtAccountLink() {
		return getEidtAccountLink;
	}
	
	@FindBy(xpath = "//a[@id='go_add_expense']")
	WebElement getAddExpenseLink;

	public WebElement getAddExpenseLink() {
		return getAddExpenseLink;
	}
	
	@FindBy(id = "go_list_categories")
	WebElement getListOfCategoriesLink;

	public WebElement getListOfCategoriesLink() {
		return getListOfCategoriesLink;
	}
	
	@FindBy(xpath = "//table[@class='table']/tbody/tr/td[1]")
	WebElement getDateTd;

	public WebElement getDateTd() {
		return getDateTd;
	}
	
	@FindBy(xpath = "//table[@class='table']/tbody/tr/td[2]")
	WebElement getCategoryTd;

	public WebElement getCategoryTd() {
		return getCategoryTd;
	}
	
	@FindBy(xpath = "//table[@class='table']/tbody/tr/td[3]")
	WebElement getAmmountTd;

	public WebElement getAmmountTd() {
		return getAmmountTd;
	}
	
	@FindBy(xpath = "//table[@class='table']/tbody/tr/td[4]")
	WebElement getReasontTd;

	public WebElement getReasontTd() {
		return getReasontTd;
	}
	
}
