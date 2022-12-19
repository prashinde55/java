package com.uiFramework.KTCTC.Pages;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.uiFramework.KTCTC.helper.wait.WaitHelper;

public class InventoryCategoryPagee {
	private WebDriver driver;

	By InventoryButton = By.xpath("/html/body/div/b/b/aside/section/ul/li[8]/a");
	By categoryButtonPage = By.xpath("//a[@href='category.php']");

	By newButtonOnCategoryPage = By.xpath("//a[@href='#addnew']");
	By searchOnnewButtonCategoryPage = By.id("name");
	By saveButtonInNewButtonOnCategoryPage = By.name("add");

	By AddedsucessMessageDispayAfterAddingNewCategory = By
			.xpath("//div[@class='alert alert-success alert-dismissible']");
	By mainSearchBoxOnInventoryCategory = By.xpath("//input[@type='search']");
	By editButtonOnInventoryCategoryPage = By.xpath("//button[contains(text(),'Edit')]");

	By deleteButtonOnInventoryCategoryPage = By.xpath("//button[contains(@class,'delete')]");
	By recordCountOnCategory = By.xpath("//div[contains(text(),'Showing')]");
	By updateButtonOnEditCategoryOnInventoryCategoryPage = By.name("edit");

	By searchBoxOnEditButton = By.name("name");
	By deleteButtonInsideDeleteButton = By.xpath("//*[@id=\"delete\"]/div/div/div[3]/button[2]");
	By editedSucessMessageDisplayAfterEditingCategory = By
			.xpath("//div[@class='alert alert-success alert-dismissible']");

	By deletedSucessMessageDisplayAfterDeletingCategory = By
			.xpath("//div[@class='alert alert-success alert-dismissible']");
	By newlyAddedCategoryDisplyedOnCategoryPage = By.xpath("//*[@id=\"example1\"]/tbody/tr/td[1]");
	By newlyUpdatedCategoryDisplayedOnCategoryPage = By.xpath("//*[@id=\"example1\"]/tbody/tr/td[1]");
	By searchBoxClearOnEditedButton = By.xpath("//*[@id=\"edit_name\"]");

	public InventoryCategoryPagee(WebDriver driver) {
		this.driver = driver;
	}

	public void navigationToInventoryCategoryPage() {
		driver.findElement(categoryButtonPage).click();

	}

	public void addNewCategoryOnCategoryPage(String name) {
		driver.findElement(newButtonOnCategoryPage).click();
		driver.findElement(searchOnnewButtonCategoryPage).sendKeys(name);
		driver.findElement(saveButtonInNewButtonOnCategoryPage).click();
	}

	public boolean NewAddedCategoryDisplyedOnCategoryPage(String name) {
		try {
			clearSearchBox();
		} catch (Exception e) {

		} // this method clear before every new Search in search Box

		// driver.findElement(newlyAddedCategoryDisplyedOnCategoryPage).sendKeys(name);

		boolean flag = false;
		flag = driver.findElement(newlyAddedCategoryDisplyedOnCategoryPage).isDisplayed();
		return flag;
	}

	public void mainSearchBoxOnInventoryCategory(String newCategoryName) {
		try {
			clearSearchBox();
		} catch (Exception e) {

		}
		driver.findElement(mainSearchBoxOnInventoryCategory).sendKeys(newCategoryName);

	}

	public boolean isSuccessMessageIsDisplayedOnAddingNewCategory() {

		boolean flag = false;
		flag = driver.findElement(AddedsucessMessageDispayAfterAddingNewCategory).isDisplayed();

		return flag;
	}

	public void clearSearchBox() {

		String str = driver.findElement(mainSearchBoxOnInventoryCategory).getAttribute("value");
		driver.findElement(mainSearchBoxOnInventoryCategory).click();
		for (int i = 0; i < str.length(); i++) {
			driver.findElement(mainSearchBoxOnInventoryCategory).sendKeys(Keys.BACK_SPACE);
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

		}
	}

	public void categoryCanBeEdited(String categoryName, String newCategoryName) {

		// NewAddedCategoryDisplyedOnCategoryPage(existCategory);
		// driver.findElement(editButtonOnInventoryCategoryPage).click();
		try {
			clearSearchBox();
		} catch (Exception e) {

		}
		driver.findElement(mainSearchBoxOnInventoryCategory).sendKeys(categoryName);
		driver.findElement(editButtonOnInventoryCategoryPage).click();
		driver.findElement(searchBoxClearOnEditedButton).clear();

		driver.findElement(searchBoxClearOnEditedButton).sendKeys(newCategoryName);
		driver.findElement(updateButtonOnEditCategoryOnInventoryCategoryPage).click();
		// driver.findElement(searchBoxClearOnEditedButton).clear();
	}

	public boolean isUpdatedCategoryUpdatedOnCategroyPage() {

		boolean flag = false;
		flag = driver.findElement(newlyUpdatedCategoryDisplayedOnCategoryPage).isDisplayed();

		return flag;
	}

	public boolean isUpdatedMessageisDisplayedWhenCategroyisUpdted() {

		boolean flag = false;
		flag = driver.findElement(editedSucessMessageDisplayAfterEditingCategory).isDisplayed();

		return flag;
	}

	public void deletingExistingCategoryInCategorypage(String newCategoryName) {
		try {
			clearSearchBox();
		} catch (Exception e) {

		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

		}
		mainSearchBoxOnInventoryCategory(newCategoryName);
		// driver.findElement(mainSearchBoxOnInventoryCategory);
		driver.findElement(deleteButtonOnInventoryCategoryPage).click();
		driver.findElement(deleteButtonInsideDeleteButton).click();

	}

	public boolean isDeletedCategorySuccessfullyDeletedFromCategoryPage() {
		try {
			clearSearchBox();
		} catch (Exception e) {

		}
		boolean flag = false;
		flag = driver.findElement(By.xpath("//*[@id=\"example1\"]/tbody/tr/td[1]")).isDisplayed();
		return flag;
	}

	public boolean isDeletedMessageDisplayedAfterDeleteingCategory() {
		boolean flag = false;
		flag = driver.findElement(deletedSucessMessageDisplayAfterDeletingCategory).isDisplayed();
		return flag;
	}

	public int recordsCheckWhenActionPerformedCategorySucessFully() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {

		}
		String cnt = driver.findElement(recordCountOnCategory).getText();
		String act = cnt.trim().split(" ")[5];
		int ct = Integer.parseInt(act);
		return ct;
	}

}
