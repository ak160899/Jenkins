package com.pomclass;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Status {
	public WebDriver driver;

	@FindBy(xpath = "//div[contains(@title,'Add Status')]")
	public WebElement addIcon;

	@FindBy(xpath = "(//select[@id='statusType'])[1]")
	public WebElement selectType;

	@FindBy(xpath = "//div[@id='StatusKpop2']/div[2]/div[1]/select[1]//following::div[1]/div[2]/input")
	public WebElement icd;

	@FindBy(xpath = "//div[@id='StatusKpop2']/div[2]/div[1]/select//following::input[1]//following::ul[1]/li/a/div")
	public List<WebElement> icdList;

	@FindBy(xpath = "//div[@id='StatusKpop2']/div[2]/div[2]/button[2]")
	public WebElement save;

	@FindBy(xpath = "//div[@id='StatusKpop2']/div[2]/div[1]/select//following::span[5]")
	public WebElement removeStatus;

	@FindBy(xpath = "//div[contains(@title,'Show my favorite Status list for ')]")
	public WebElement favoriteicon;

	@FindBy(xpath = "//div[@id='StatusFavKpop2']/div[2]/div[1]/div/table/tbody/tr/td[4]/span[2]")
	public WebElement addNewFavorite;

	@FindBy(xpath = "//div[@id='StatusKpop2']/div[2]/div[1]/select")
	public WebElement favoritesStatusType;

	@FindBy(xpath = "//div[@id='StatusKpop2']/div[2]/div[1]/select//following::input[1]")
	public WebElement favoriteIcd;

	@FindBy(xpath = "//div[@id='StatusKpop2']/div[2]/div[1]/select//following::input[1]//following::ul[1]/li/a/div")
	public List<WebElement> favoriteicdList;

	@FindBy(xpath = "//div[@id='StatusKpop2']/div[2]/div[2]/button[2]")
	public WebElement favoriteSave;

	@FindBy(xpath = "(//div[contains(text(),'134374006: Hearing test bilateral')])[1]")
	public WebElement editFavorite;

	@FindBy(xpath = "//div[text()='test']")
	public List<WebElement> editFavoriteBasic;

	@FindBy(xpath = "(//span[text()='134374006'])[1]//following::span[1]")
	public WebElement removeFavoriteCode;

	@FindBy(css = "span#remove")
	public List<WebElement> removeFavoriteIcdBasic;
	
	@FindBy(xpath = "(//span[contains(@title,'Add this status')])[1]")
	public WebElement addThisFavorite;

	@FindBy(xpath = "//div[@id='StatusFavKpop2']/div[1]/div[2]/span")
	public WebElement closeFavorite;

	public Status(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
