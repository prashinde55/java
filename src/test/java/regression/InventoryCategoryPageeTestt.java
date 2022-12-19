package regression;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.uiFramework.KTCTC.Pages.InventoryCategoryPagee;
import com.uiFramework.KTCTC.testbase.TestBase;

public class InventoryCategoryPageeTestt extends TestBase {
	InventoryCategoryPagee inventoryCategoryPagee;
	String categoryName;
	String newCategoryName;
	int initialCountOfRecords;

	@Test(priority = 1)
	public void verifyNewCategoryCanBeAdded() throws Exception {
		SoftAssert sAssert = new SoftAssert();

		inventoryCategoryPagee = new InventoryCategoryPagee(driver);
		cmObj.expandInventoryOption(driver);
		categoryName = cmObj.getcharacterString(8);

		inventoryCategoryPagee.navigationToInventoryCategoryPage();
		inventoryCategoryPagee.addNewCategoryOnCategoryPage(categoryName);
		boolean flag = inventoryCategoryPagee.NewAddedCategoryDisplyedOnCategoryPage(categoryName);
		sAssert.assertTrue(flag, "Added Category is not Displying");
		sAssert.assertAll();

	}

	@Test(priority = 2)
	public void verifyAddedCategoryDisplayedMessageSuccesFullyOrNot() {
		SoftAssert sAssert = new SoftAssert();
		boolean flag = inventoryCategoryPagee.isSuccessMessageIsDisplayedOnAddingNewCategory();
		sAssert.assertTrue(flag, "Success Message is not displayed");
		sAssert.assertAll();
	}

	@Test(priority = 3)
	public void verifyCountCanIncressByOneWhenCategoryAdded() {
		SoftAssert sAssert = new SoftAssert();
		int count = inventoryCategoryPagee.recordsCheckWhenActionPerformedCategorySucessFully();
		sAssert.assertTrue(count == initialCountOfRecords+1, "record Count is not  Increased by one");
		sAssert.assertAll();

	}

	@Test(priority = 4)
	public void verifyUserCanEditExistingCategory() throws Exception {
		SoftAssert sAssert = new SoftAssert();
		newCategoryName = cmObj.getcharacterString(8);
		inventoryCategoryPagee.categoryCanBeEdited(categoryName, newCategoryName);
		boolean flag = inventoryCategoryPagee.isUpdatedCategoryUpdatedOnCategroyPage();
		sAssert.assertTrue(flag, "new Category is not updated in Category List");
		sAssert.assertAll();
	}

	@Test(priority = 5)
	public void verifyUpdatedSuccessMessgaeIsDisplyed() {
		SoftAssert sAssert = new SoftAssert();
		boolean flag = inventoryCategoryPagee.isUpdatedMessageisDisplayedWhenCategroyisUpdted();
		sAssert.assertTrue(flag, "Updated Success Message is  not Dispalyed");
		sAssert.assertAll();

	}

	@Test(priority = 6)
	public void verifyCountIsNotChangedAfterUpdatingCategory() {
		SoftAssert sAssert = new SoftAssert();
		int count = inventoryCategoryPagee.recordsCheckWhenActionPerformedCategorySucessFully();
		sAssert.assertTrue(count == initialCountOfRecords, "count of record get changed");

		sAssert.assertAll();
	}

	@Test(priority = 7)
	public void verifyExistingCategoryDeleted() throws Exception {

		SoftAssert sAssert = new SoftAssert();
		inventoryCategoryPagee.deletingExistingCategoryInCategorypage(newCategoryName);
		boolean flag = inventoryCategoryPagee.isDeletedCategorySuccessfullyDeletedFromCategoryPage();
		sAssert.assertTrue(flag, "Deleted Categorey is Still Displyed");
		sAssert.assertAll();
	}

	@Test(priority = 8)
	public void verifyDeletedMessageSucessIsDisplayed() {
		SoftAssert sAssert = new SoftAssert();
		boolean flag = inventoryCategoryPagee.isDeletedMessageDisplayedAfterDeleteingCategory();
		sAssert.assertTrue(flag, "Deleted Message is Still Displayed");
		sAssert.assertAll();
	}

	@Test(priority = 9)
	public void VerifyCountReducedByOneAfterCategoryDeleted() {
		SoftAssert sAssert = new SoftAssert();
		int count = inventoryCategoryPagee.recordsCheckWhenActionPerformedCategorySucessFully();
		sAssert.assertTrue(count+1 == initialCountOfRecords, "Record is Not reduced By one");

	}

}
