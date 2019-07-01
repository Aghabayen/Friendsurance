package test.registration;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import main.test.MainDriver;
import main.test.TestConstants.TestData;
import page.objects.ListexpensesPage;
import page.objects.LoginPage;
import page.objects.RegistrationPag;

public class RegisterUserTest extends MainDriver {

	@BeforeMethod
	public void launchLogin() {
		driver.get(TestData.ENVIRONMENT);

		LoginPage login = new LoginPage(driver);
		login.getRegisterLink().click();

	}

	@AfterMethod
	public void prepareNewEmail() {
		TestData.USERNAME = TestData.username();

	}

	@Test
	public void validUserRegistration() {
		RegistrationPag register = new RegistrationPag(driver);
		register.getUserNameInput().sendKeys(TestData.USERNAME);
		register.getPasswordInput().sendKeys(TestData.PASSWORD);
		register.getRepeatPasswordInput().sendKeys(TestData.PASSWORD);
		register.getRegisterButton().click();

		ListexpensesPage expenses = new ListexpensesPage(driver);

		System.out.println(TestData.USERNAME);

		waitobj.until(ExpectedConditions.urlContains("listexpenses"));

		assertEquals(expenses.getEidtAccountLink().getText(), TestData.USERNAME);
	}

	@Test
	public void invalidUserRegistrationWithEmptyUserName() {
		RegistrationPag register = new RegistrationPag(driver);

		register.getRegisterButton().click();

		System.out.println(register.getUserNameInput().getAttribute("validationMessage"));

		assertEquals(register.getUserNameInput().getAttribute("validationMessage"), TestData.REGISTRATION_FIELDS_EMPTY_ERROR);
	}

	@Test
	public void invalidUserRegistrationWithEmptyPassword() {
		RegistrationPag register = new RegistrationPag(driver);

		register.getUserNameInput().sendKeys(TestData.USERNAME);
		register.getRegisterButton().click();
		
		//the validation message is one of the element attributes

		System.out.println(register.getPasswordInput().getAttribute("validationMessage"));

		assertEquals(register.getPasswordInput().getAttribute("validationMessage"), TestData.REGISTRATION_FIELDS_EMPTY_ERROR);
	}

	@Test
	public void invalidUserRegistrationWithEmptyRetypePassword() {
		RegistrationPag register = new RegistrationPag(driver);

		register.getUserNameInput().sendKeys(TestData.USERNAME);
		register.getPasswordInput().sendKeys(TestData.PASSWORD);

		register.getRegisterButton().click();

		System.out.append(driver.switchTo().alert().getText());
		assertEquals(driver.switchTo().alert().getText(), TestData.RETYPE_PASSWORD);
		
		//click ok on alert to allow driver to close the browser
		driver.switchTo().alert().accept();
	}
	
	@Test
	public void invalidUserRegistrationWithUserNameLessThanFourChar() {
		RegistrationPag register = new RegistrationPag(driver);

		register.getUserNameInput().sendKeys("123");

		register.getRegisterButton().click();

		System.out.println(register.getUserNameInput().getAttribute("validationMessage"));

		assertEquals(register.getUserNameInput().getAttribute("validationMessage"), TestData.REGISTRATION_FIELDS_4_LESS);
	}
	
	@Test
	public void invalidUserRegistrationWithUserPasswordLessThanFourChar() {
		RegistrationPag register = new RegistrationPag(driver);

		register.getUserNameInput().sendKeys(TestData.USERNAME);
		register.getPasswordInput().sendKeys("123");
		register.getRepeatPasswordInput().sendKeys("123");

		register.getRegisterButton().click();

		System.out.println(register.getPasswordInput().getAttribute("validationMessage"));

		assertEquals(register.getPasswordInput().getAttribute("validationMessage"), TestData.REGISTRATION_FIELDS_4_LESS);
	}

}
