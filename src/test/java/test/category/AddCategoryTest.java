package test.category;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import intermidiate.classes.Categories;
import main.test.TestConstants.TestData;
import page.objects.AddCategoryPage;
import page.objects.ListCategoriesPage;
public class AddCategoryTest extends Categories {

	@BeforeMethod
	public void goToAddCategory() {

		ListCategoriesPage listCategory = new ListCategoriesPage(driver);

		listCategory.getAddCategoryLink().click();
	}
	
	@AfterMethod
	public void getNewCategory() {

		TestData.CATEGORY = TestData.category();

	}

	@Test
	public void addValidCategory() {
		System.out.println(TestData.CATEGORY);
		AddCategoryPage addCategory = new AddCategoryPage(driver);
		addCategory.getDayInput().sendKeys(TestData.CATEGORY);
		addCategory.getSubmitButton().click();
		waitobj.until(ExpectedConditions.urlContains("listcategories"));
		
		ListCategoriesPage listCategory = new ListCategoriesPage(driver);

		assertEquals(listCategory.getAddedCategoryTd().getText(), TestData.CATEGORY);

	}
}
