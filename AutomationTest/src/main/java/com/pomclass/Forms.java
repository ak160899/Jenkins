package com.pomclass;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Forms {
	public WebDriver driver;
	
	@FindBy(xpath = "//div[contains(@title,'Add Forms')]")
	public WebElement addIcon;
	
	@FindBy(xpath = "//span[@title='Edit this Form']")
	public List<WebElement> editicon;
	
	
	@FindBy(xpath = "(//label[text()='Form Title*'])[2]//following::input[1]")
	public WebElement formTitleDiscription;
	
	@FindBy(xpath = "(//span[@id='del-form'])[2]")
	public WebElement deleteForm;
	
	
	@FindBy(xpath = "//div[@id='FormsKpop2']/div[1]/span")
	public WebElement addNewFormAddIcon;
	
	@FindBy(xpath = "(//div[@id='build-wrap'])[2]/div[1]/div[2]/ul/li")
	public List<WebElement> dragCheckBox;
	
	@FindBy(xpath = "(//div[contains(@data-content,'Drag a field from the right to this area')])[2]/ul")
	public WebElement dropCheckBox;
	
	@FindBy(xpath = "//label[text()='Label']//following::div[1]/input")
	public WebElement clearLableInCheckBox;
	
	
	@FindBy(xpath = "(//div[@id='build-wrap'])[2]/div[1]/div[2]/ul//following::div[1]/button")
	public WebElement saveNewForm;
	
	
	
	
	public Forms(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

}
