package com.pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdvanceDirectives {
	public WebDriver driver;

	@FindBy(xpath = "//div[contains(@title,'Add Advance directives')]")
	public WebElement addIcon;

	@FindBy(xpath = "//div[@id='Assessment-div']/select")
	public WebElement selectType;

	@FindBy(xpath = "//input[@id='directive_desc']")
	public WebElement assesment;

	@FindBy(xpath = "//div[@id='Advance_DirectivesKpop2']/div[2]/div[2]/button[2]")
	public WebElement save;

	@FindBy(xpath = "//div[contains(@title,'Show my favorite Advance directives list ')]")
	public WebElement favoriteIcon;

	@FindBy(xpath = "//div[@id='Advance_DirectivesFavKpop2']//following::div[2]/div[1]/div/table/tbody/tr/td[4]/span[2]")
	public WebElement addNewFavorite;

	@FindBy(xpath = "(//div[@id='Advance_DirectivesKpop2']//following::select[1])[1]")
	public WebElement favoriteStatusType;

	@FindBy(xpath = "(//div[@id='Advance_DirectivesKpop2']//following::select[1])[1]//following::input[1]")
	public WebElement favoriteDiscription;

	@FindBy(xpath = "//div[@id='Advance_DirectivesKpop2']/div[2]/div[2]/button[2]")
	public WebElement favoriteSave;

	@FindBy(xpath = "(//span[text()='Assessment'])[1]")
	public WebElement editFavorite;

	@FindBy(xpath = "((//span[text()='Assessment'])[1]//parent::div//parent::div[1]//parent::div[1]/div[1]/span[1])[1]")
	public WebElement addThisFavorite;
	
	@FindBy(xpath = "//div[@id='Advance_DirectivesFavKpop2']/div[1]/div[2]/span")
	public WebElement closeFavorite;

	public AdvanceDirectives(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
