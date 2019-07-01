package intermidiate.classes;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import main.test.MainDriver;
import main.test.TestConstants.TestData;
import page.objects.AddCategoryPage;
import page.objects.ListCategoriesPage;
import page.objects.ListexpensesPage;
import page.objects.LoginPage;
import page.objects.RegistrationPag;

public class Expenses extends MainDriver{
	
	@BeforeClass
	public void beforeAdd() {
		
		//launch login
		driver.get(TestData.ENVIRONMENT);

		//click on registration in login and create new user
		LoginPage login = new LoginPage(driver);
		login.getRegisterLink().click();
		RegistrationPag register = new RegistrationPag(driver);
		register.getUserNameInput().sendKeys(TestData.USERNAME);
		register.getPasswordInput().sendKeys(TestData.PASSWORD);
		register.getRepeatPasswordInput().sendKeys(TestData.PASSWORD);
		register.getRegisterButton().click();

		ListexpensesPage listExpense = new ListexpensesPage(driver);

		System.out.println(TestData.USERNAME);

		waitobj.until(ExpectedConditions.urlContains("listexpenses"));

		assertEquals(listExpense.getEidtAccountLink().getText(), TestData.USERNAME);
		listExpense.getListOfCategoriesLink().click();
		
		//Add new category
		ListCategoriesPage listCategory = new ListCategoriesPage(driver);

		listCategory.getAddCategoryLink().click();
		
		System.out.println(TestData.CATEGORY);
		AddCategoryPage addCategory = new AddCategoryPage(driver);
		addCategory.getDayInput().sendKeys(TestData.CATEGORY);
		addCategory.getSubmitButton().click();
		waitobj.until(ExpectedConditions.urlContains("listcategories"));
		

		assertEquals(listCategory.getAddedCategoryTd().getText(), TestData.CATEGORY);
	}
	
	@AfterClass
	public void prepareNewEmail() {
		TestData.USERNAME = TestData.username();
		TestData.CATEGORY = TestData.category();

	}

}
