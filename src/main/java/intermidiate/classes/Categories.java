package intermidiate.classes;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import main.test.MainDriver;
import main.test.TestConstants.TestData;
import page.objects.ListexpensesPage;
import page.objects.LoginPage;
import page.objects.RegistrationPag;

public class Categories extends MainDriver{
	
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

	}
	
	@AfterClass
	public void prepareNewEmail() {
		TestData.USERNAME = TestData.username();

	}

}
