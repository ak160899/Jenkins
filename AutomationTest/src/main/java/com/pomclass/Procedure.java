package com.pomclass;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Procedure {
	public WebDriver driver;

	@FindBy(xpath = "//div[contains(@title,'Add Procedure')]")
	public WebElement addIcon;

	@FindBy(xpath = "//select[@id='codeType']")
	public WebElement selectCodeType;

	@FindBy(xpath = "//div[@id='ProcedureKpop2']/div[2]/div[1]/div[1]/div[2]/input")
	public WebElement icd;

	@FindBy(xpath = "//div[@id='addfav-div']/div/div/div[4]//following::div[1]//following::ul[2]/li/a/div/small/em")
	public List<WebElement> icdList;

	@FindBy(xpath = "//div[@id='ProcedureKpop2']/div[2]/div/div[2]/div[2]/input")
	public WebElement procedure;

	@FindBy(id = "btnSaveAdd")
	public WebElement save;

	@FindBy(xpath = "//div[@id='saveadd-btn']/ul/li")
	public List<WebElement> saveMore;

	@FindBy(xpath = "//div[contains(@title,'SALT Procedure')]//following::div[3]")
	public WebElement ellipses;

	@FindBy(xpath = "//div[contains(@title,'SALT Procedure')]//following::div[3]//following::ul[1]/li")
	public List<WebElement> ellipsesList;

	@FindBy(xpath = "(//span[text()='Past Procedure'])[1]//following::div[1]/div[3]/div/div/span")
	public WebElement addPast;

	@FindBy(xpath = "(//span[text()='Past Procedure'])[1]//parent::div/span[1]")
	public WebElement closePast;

	@FindBy(xpath = "//div[contains(@title,'Show my favorite Procedure li')]")
	public WebElement favoriteIcon;

	@FindBy(xpath = "//div[@id='ProcedureKpop2']/div[2]/div[1]/select")
	public WebElement favoriteCodeType;

	@FindBy(id = "longDescription")
	public WebElement favoriteIcd;

	@FindBy(xpath = "//div[@id='addfav-div']/div/div/div[4]//following::div[1]//following::ul[2]/li/a/div/small/em")
	public List<WebElement> favoriteIcdList;

	@FindBy(xpath = "//div[@id='ProcedureKpop2']/div[2]/div[1]/select//following::input[2]")
	public WebElement favoriteProcedure;

	@FindBy(id = "btnSaveAdd")
	public WebElement favoriteSave;
	
	@FindBy(xpath = "//div[@id='ProcedureKpop2']/div[2]/div[2]/div/button//following::ul[1]/li/a")
	public List<WebElement> favoriteSaveMore;
	
	@FindBy(xpath = "(//span[@title='Add this procedure'])[1]//following::div[1]/div[2]")
	public WebElement editFavorite;
	
	@FindBy(xpath = "//span[text()='134287002']//following::span[1]")
	public WebElement removeFavoriteCode;
	
	@FindBy(xpath = "(//span[contains(@title,'Add this procedure')])[1]")
	public WebElement addThisFavorite;
	
	@FindBy(xpath = "//div[@id='ProcedureFavKpop2']/div[1]/div[2]/span")
	public WebElement closeFavorite;
	
	
	@FindBy(xpath = "//div[@id='addfav-div']/div/div/div[4]//following::div[1]//following::ul[2]/li/a/div/b")
	public List<WebElement> favIcdList2;
	
	

	@FindBy(xpath = "//div[@id='ProcedureFavKpop2']/div[2]/div[1]/div/table/tbody/tr/td[4]/span[2]")
	public WebElement addNewFavorite;

	public Procedure(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
