package page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ListCategoriesPage {
	WebDriver driver;

	public ListCategoriesPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "go_add_category")
	WebElement getAddCategoryLink;

	public WebElement getAddCategoryLink() {
		return getAddCategoryLink;
	}
	
	@FindBy(xpath = "//table[@class='table']/tbody/tr/td[1]")
	WebElement getAddedCategoryTd;

	public WebElement getAddedCategoryTd() {
		return getAddedCategoryTd;
	}
	
	
}
