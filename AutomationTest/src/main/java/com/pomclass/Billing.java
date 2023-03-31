package com.pomclass;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Billing {

	public WebDriver driver;

	@FindBy(xpath = "//td[text()='Billing']")
	public WebElement clickBill;

	@FindBy(xpath = "//button[@title='Create new Bill']")
	public WebElement clickCreateNewBill;

	@FindBy(xpath = "(//button[@title='Add Item purchased or service offered'])[1]")
	public WebElement addItem;

	@FindBy(xpath = "(//label[@id='itemServicelbl'])[2]//following::input[1]")
	public WebElement enterTheItem;

	@FindBy(xpath = "(//label[@id='itemServicelbl'])[2]//following::input[2]")
	public WebElement addPrice;

	@FindBy(xpath = "(//label[@id='itemServicelbl'])[2]//following::input[3]")
	public WebElement addQuantity;

	@FindBy(xpath = "(//label[@id='itemServicelbl'])[2]//following::input[2]//following::button[2]")
	public WebElement saveItem;

	@FindBy(xpath = "(//button[@id='cancel-btn'])[12]")
	public WebElement cancelItem;

	@FindBy(xpath = "(//input[@id='search-string'])[2]")
	public WebElement FavoriteItem;

	@FindBy(xpath = "(//div[@class='col-xs-1 center-cont hover'])[14]")
	public WebElement addThisToFavorite;

	@FindBy(xpath = "//button[@id='finalize-bill']")
	public WebElement finaliseBill;

	@FindBy(xpath = "(//button[@id='print'])[6]")
	public WebElement printBill;

	@FindBy(xpath = "(//button[@id='del'])")
	public WebElement deleteBill;

	@FindBy(xpath = "(//button[@id='back'])[1]")
	public WebElement goBack;

	@FindBy(xpath = "(//button[@id='accept-btn'])[21]")
	public WebElement confirmFinalise;

	@FindBy(xpath = "//div[@id='discount-side']/div[3]/div/div/div[2]/div[4]/div/ul/li/a")
	public List<WebElement> discountDropDown;

	@FindBy(xpath = "//div[@id='dmain']/div[4]/div[2]//following::div[2]//following::ul[3]/li/a/table/tbody/tr/td[2]")
	public List<WebElement> searchPatientDropdown;

	@FindBy(xpath = "(//button[@id='cancel-btn'])[20]")
	public WebElement cancelBill;

	@FindBy(xpath = "//div[@id='assign-side']/div[1]/div")
	public WebElement favoriteItemServiceUi;

	@FindBy(xpath = "//div[@id='assign-side']/div[2]/div[1]/div/table/tbody/tr/td[4]/span[2]")
	public WebElement addNewFavoriteItemServiceAddIcon;

	@FindBy(xpath = "//div[@id='assign-side']/div[3]/div/div/div[2]/div[3]/div[2]/div/input")
	public WebElement favoriteItemServiceDiscription;

	@FindBy(xpath = "//div[@id='assign-side']/div[3]/div/div/div[2]/div[4]/div[2]/input")
	public WebElement favoriteItemServicePriceField;

	@FindBy(xpath = "//div[@id='assign-side']/div[3]/div/div/div[2]/div[4]/div[2]//following::div[1]/div/div[4]//following::div[1]/div/button[2]")
	public WebElement favoriteItemServiceSave;

	@FindBy(xpath = "(//span[text()='Kaaspro']//parent::div//parent::div[1]//parent::div[1]/div[1]/span[1])[1]")
	public WebElement addFavoriteItemserviceToBillList;
	
	@FindBy(xpath = "(//span[text()='Kaaspro'])[2]")
	public WebElement editFavoriteItemservice;
	
	@FindBy(xpath = "//div[@id='assign-side']/div[3]/div/div/div[1]/div[2]/span[2]")
	public WebElement deleteFavoriteItemService;
	
	
	@FindBy(xpath = "//div[@id='item-code-side']/div[1]/div")
	public WebElement favoriteItemseriveCodeUi;
	
	@FindBy(xpath = "//div[@id='item-code-side']/div[2]/div[1]/div/table/tbody/tr/td[4]/span[3]")
	public WebElement itemServiceCodeAddIcon;
	
	@FindBy(xpath = "//div[@id='item-code-side']/div[3]/div/div/div[2]/div[3]/input")
	public WebElement enterItemServiceCode;
	
	@FindBy(xpath = "//div[@id='item-code-side']/div[3]/div/div/div[2]/div[4]/textarea")
	public WebElement itemserviceCodeDiscription;
	
	@FindBy(xpath = "//div[@id='item-code-side']/div[3]/div/div/div[2]/div[5]/input")
	public WebElement itemservicecodePrice;
	
	@FindBy(xpath = "//div[@id='item-code-side']/div[3]/div/div/div[2]/div[7]/div/button[2]")
	public WebElement itemservicecodeSave;
	
	@FindBy(xpath = "(//div[text()='PRODUCT001'])//parent::div[1]//parent::div[1]/div/span")
	public WebElement itemservicecodeAddToBillList;
	
	@FindBy(xpath = "//div[text()='PRODUCT001']")
	public WebElement itemservicecodeEdit;
	
	@FindBy(xpath = "//div[@id='item-code-side']/div[3]/div/div/div[1]/div[2]/span[2]")
	public WebElement itemservicecodeDelete;
	
	@FindBy(xpath = "//div[@id='tax-side']/div[1]/div/span[3]")
	public WebElement itemservicechargesUi;
	
	@FindBy(xpath = "//div[@id='tax-side']/div[2]/div[1]/div/table/tbody/tr/td[4]/span[3]")
	public WebElement itemservicechargesAddIcon;
	
	
	@FindBy(xpath = "//div[@id='tax-side']/div[3]/div/div/div[2]/div[3]/input")
	public WebElement itemservicechargesDiscription;
	
	
	@FindBy(xpath = "//div[@id='tax-side']/div[3]/div/div/div[2]/div[4]/input")
	public WebElement itemservicechargesPrice;
	
	@FindBy(xpath = "//div[@id='tax-side']/div[3]/div/div/div[2]/div[6]/div/button[2]")
	public WebElement itemservicechargesSave;
	
	@FindBy(xpath = "//div[text()='service charge<>']//parent::div[1]//parent::div[1]/div/span")
	public WebElement itemservicechargesAddToBillList;
	
	@FindBy(xpath = "//div[text()='service charge<>']")
	public WebElement itemservicechargesEdit;
	
	@FindBy(xpath = "//div[@id='tax-side']/div[3]/div/div/div[1]/div[2]/span[2]")
	public WebElement itemservicechargesDelete;
	
	@FindBy(xpath = "//div[@id='discount-side']/div[1]/div")
	public WebElement discountUi;
	
	@FindBy(xpath = "//div[@id='discount-side']/div[2]/div[1]/div/table/tbody/tr/td[4]/span[3]")
	public WebElement discountAddIcon;
	
	@FindBy(xpath = "//div[@id='discount-side']/div[3]/div/div/div[2]/div[3]/input")
	public WebElement discountDiscription;
	
	@FindBy(xpath = "//div[@id='discount-side']/div[3]/div/div/div[2]/div[4]/div/button")
	public WebElement discountType;
	
	@FindBy(xpath = "//div[@id='discount-side']/div[3]/div/div/div[2]/div[5]/div/input")
	public WebElement discountPercentage;
	
	@FindBy(xpath = "//div[@id='discount-side']/div[3]/div/div/div[2]/div[8]/div/button[2]")
	public WebElement saveDiscount;
	
	@FindBy(xpath = "//div[text()='Discnt']//parent::div[1]//parent::div/div/span")
	public WebElement addDiscountToBillList;
	
	@FindBy(xpath = "//div[text()='Discnt']")
	public WebElement editDiscount;
	
	@FindBy(xpath = "//div[@id='discount-side']/div[3]/div/div/div[1]/div[2]/span[2]")
	public WebElement deleteDiscount;
	
	@FindBy(xpath = "(//button[@id='add-payment-btn'])[1]")
	public WebElement addPayment;
	
	@FindBy(xpath = "(//span[@id='paymentMethodTypeSelectValue'])[2]")
	public WebElement selectPayment;
	
	@FindBy(xpath = "(//span[@id='paymentMethodTypeSelectValue'])[2]//following::ul[1]/li")
	public List<WebElement> selectPayemntDropdown;
	
	@FindBy(xpath = "(//button[@id='paymentMethodTypeId'])[2]//following::textarea[1]")
	public WebElement paymentDiscription;
	
	@FindBy(xpath = "(//button[@title='Make Payment'])[3]")
	public WebElement makePayment;
	
	@FindBy(xpath = "//button[@id='finalize-bill']")
	public WebElement finalizBill;
	
	@FindBy(xpath = "(//button[@title='Finalize'])[1]")
	public WebElement finalizeBillConfirmationKpop;
	
	@FindBy(xpath = "//button[@id='finalize-bill']//following::button[2]")
	public WebElement deleteInvoice;
	
	
	@FindBy(xpath = "//center[text()='Do you like to delete Invoice?']//following::div[1]/button[2]")
	public WebElement deleteInvoiceConfirmationKpop;
	
	@FindBy(xpath = "//div[@id='bill_report']/div[1]/div[2]//following::div[1]/div[2]/div/div[2]/div[3]/div[1]/div[1]/div[1]//following::div[1]/input")
public WebElement searchPatientBy;	
	
	
	
	
	
	
	
	
	
	

	public Billing(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
