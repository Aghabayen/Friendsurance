package test.expenses;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import intermidiate.classes.Expenses;
import main.test.TestConstants.TestData;
import page.objects.AddExpensePage;
import page.objects.ListexpensesPage;

public class AddExpenseTest extends Expenses{
	
	@BeforeMethod
	public void goToAddValidExpense() {
		ListexpensesPage listExpense = new ListexpensesPage(driver);
		listExpense.getAddExpenseLink().click();
	}
	
	@Test
	public void AddValidExpense() {
		AddExpensePage addExpense = new AddExpensePage(driver);
		
		addExpense.getDayInput().sendKeys("28");
		addExpense.getMonthInput().clear();
		addExpense.getMonthInput().sendKeys("9");
		addExpense.getYearInput().sendKeys("2020");
		assertEquals(addExpense.getCategoryInput().getText().trim().replaceAll("\n ", ""), TestData.CATEGORY);
		addExpense.getAmmountInput().sendKeys("100");
		addExpense.getResonInput().sendKeys("monthly expenses");

		addExpense.getSubmitInput().click();
		waitobj.until(ExpectedConditions.urlContains("listexpenses"));
		
		ListexpensesPage listExpense = new ListexpensesPage(driver);

		assertEquals(listExpense.getDateTd().getText(), "28.09.20");
		assertEquals(listExpense.getCategoryTd().getText(), TestData.CATEGORY);
		assertEquals(listExpense.getAmmountTd().getText(), "100,00 €");
		assertEquals(listExpense.getReasontTd().getText(), "monthly expenses");


	}

}
