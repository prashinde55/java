package regression;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.uiFramework.KTCTC.helper.select.DropDownHelper;

public class ProductCategoryPage {
	private WebDriver driver;
	Select sel;

	By inventoryButton = By.xpath("/html/body/div/b/b/aside/section/ul/li[8]/a/span[1]");
	By productButtonInventoryDropDown = By.xpath("/html/body/div/b/b/aside/section/ul/li[8]/ul/li[3]/a");

	By cilckOnNewButtonOnProductCategoryPage = By.xpath("//*[@id=\"addproduct\"]");
	By nameTextBoxOnNewButtonProduct = By.xpath("//*[@id=\"name\"]");
	By priceTextBoxOnNewButtonProduct = By.xpath("//*[@id=\"price\"]");

	By photoChooseButtonOnNewButtonProduct = By.xpath("//*[@id=\"photo\"]");
	By brandDropDownOnNewButtonProduct = By.xpath("//*[@id=\"brand\"]");
	By categoryDropDownOnNewButtonProduct = By.xpath("//*[@id=\"category\"]");

	By unitDropDownOnNewButtonProduct = By.xpath("//*[@id=\"unit\"]");
	By statusDropDownOnNewButtonProduct = By.xpath("//*[@id=\"avail\"]");
	By stockQuantityOnNewButtonProduct = By.xpath("//*[@id=\"stock\"]");

	By discriptionTextBoxOnNewButtonProduct = By.xpath("/html");
	By saveButtonOnNewBuutonOnProduct = By.xpath("//*[@id=\"addnew\"]/div/div/div[3]/button[2]");
	By mainSearchBoxOnProductPage = By.xpath("//*[@id=\"example1_filter\"]/label/input");

	By sucessMessageDisplayWhenProductAdd = By.xpath("/html/body/div/b/b/div[2]/section[2]/div[1]");
	By productDisplayInProductListWhenAdded = By.xpath("//*[@id=\"example1\"]/tbody/tr/td[1]");
	By editButtonWhenproductAddedInProductList = By.xpath("//*[@id=\"example1\"]/tbody/tr/td[8]/button[1]");

	By editNameTextBoxOnEditButtonProduct = By.xpath("//*[@id=\"edit_name\"]");
	By editPriceTextBoxOnEditButtonProduct = By.xpath("//*[@id=\"edit_price\"]");
	By availableDropDownOnEditButtonProduct = By.xpath("//*[@id=\"edit_avail\"]");

	By stock_QuantityTextBoxOnEditButtonProduct = By.xpath("//*[@id=\"stock\"]");
	By categoryDropDownOnEditButtonProduct = By.xpath("//*[@id=\"edit_category\"]");
	By unitDropDownOnEditButtonProduct = By.xpath("//*[@id=\"edit_category\"]");
	By BrandDropDownOnEditButtonProduct = By.xpath("//*[@id=\"edit_brand\"]");
	By discriptionTextBoxOnEditButton = By.xpath("/html");
	By updateButtonOnEditButtonProduct = By.xpath("//*[@id=\"edit\"]/div/div/div[3]/button[2]");

	By sucessMessageDisplayWhenProductEdited = By.xpath("/html/body/div/b/b/div[2]/section[2]/div[1]");

	By deleteButtonOnWhenProductAddedInProduct = By.xpath("//*[@id=\"example1\"]/tbody/tr[2]/td[8]/button[2]/i");
	By deleteButtonInsideDeleteButtonInProduct = By.xpath("//*[@id=\"delete\"]/div/div/div[3]/button[2]");
	By sucessMessageDisplayWhenProductDeleted = By.xpath("/html/body/div/b/b/div[2]/section[2]/div[1]");
	By countOnRecord = By.xpath("//*[@id=\"example1_info\"]");

	public ProductCategoryPage(WebDriver driver) {
		this.driver = driver;

	}

	public void navigationToProductInventoryPage() {
		driver.findElement(productButtonInventoryDropDown).click();
	}

	public void NewButtonOnProductInventorypage(WebElement brand, String discription, String stock_quantity,
			String status, String unit, String category, String name, String price, String product) {
		driver.findElement(cilckOnNewButtonOnProductCategoryPage).click();
		driver.findElement(nameTextBoxOnNewButtonProduct).sendKeys(name);
		driver.findElement(priceTextBoxOnNewButtonProduct).sendKeys(price);

		sel = new Select(brand);

		driver.findElement(brandDropDownOnNewButtonProduct).click();
		sel.selectByVisibleText(product);
		driver.findElement(categoryDropDownOnNewButtonProduct).click();
		sel.selectByVisibleText(category);

		driver.findElement(unitDropDownOnNewButtonProduct).click();
		sel.selectByVisibleText(unit);

		driver.findElement(statusDropDownOnNewButtonProduct).click();
		sel.selectByVisibleText(status);

		driver.findElement(stockQuantityOnNewButtonProduct).sendKeys(stock_quantity);

		driver.findElement(discriptionTextBoxOnNewButtonProduct).sendKeys(discription);
		driver.findElement(saveButtonOnNewBuutonOnProduct).click();
	}

	public boolean productAddedInProductList() {
	  boolean flag=false;
	flag=  driver.findElement(productDisplayInProductListWhenAdded).isDisplayed();
	  return flag;
	  
  }

	public boolean sucessMessageIsDispalyedWhenProductisAdded() {
		boolean flag=false;
		flag=driver.findElement(sucessMessageDisplayWhenProductAdd).isDisplayed();
		
		return flag;
		
	}
	
	public boolean countGetIncreaseByOneWhenPoductAdded() {
		boolean flag=false;
		flag=driver.findElement(countOnRecord).isDisplayed();
		return flag;
	}
	
	public void productCanBeEdited(String name,String name, String price,WebElement brand) {
		driver.findElement(editButtonWhenproductAddedInProductList).click();
		driver.findElement(editNameTextBoxOnEditButtonProduct).sendKeys(name);
		driver.findElement(editPriceTextBoxOnEditButtonProduct).sendKeys(price);
		sel=new Select(brand);
		driver.findElement(BrandDropDownOnEditButtonProduct).click();
		sel.selectByVisibleText(name);
		
	}
	
	
	
	
	
	
	
	
}
