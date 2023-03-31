package com.pomclass;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Problems {
	public WebDriver driver;

	@FindBy(xpath = "//div[contains(@title,'Add Problems')]")
	public WebElement addIcon;

	@FindBy(xpath = "//div[@id='ProblemsKpop2']/div[2]/div/div[1]/div[2]/input")
	public WebElement icd;

	@FindBy(xpath = "//button[@id='btnSaveAdd']")
	public WebElement save;

	@FindBy(xpath = "//div[@id='saveadd-btn']/ul/li")
	public List<WebElement> saveMore;

	@FindBy(xpath = "//div[@id='ProblemsKpop2']/div[2]/div[1]/div[1]/div[2]//following::div[2]")
	public WebElement removeProblem;

	@FindBy(xpath = "//div[contains(@title,'Show my favorite Problems list ')]")
	public WebElement favoriteIcon;

	@FindBy(xpath = "//div[@id='ProblemsFavKpop2']//following::div[2]/div[1]/div/table/tbody/tr/td[4]/span[2]")
	public WebElement addNewFavorite;

	@FindBy(xpath = "(//div[@id='ProblemsKpop2']//following::input[1])[1]")
	public WebElement favoriteIcd;

	@FindBy(xpath = "//div[@id='ProblemsKpop2']/div[2]/div[2]//following::ul[1]/li/a/div/small")
	public List<WebElement> favoriteIcdList;

	@FindBy(xpath = "(//div[@id='ProblemsKpop2']//following::button[2])[1]")
	public WebElement favoriteSave;

	@FindBy(xpath = "(//div[@id='ProblemsKpop2']//following::input[2])[1]")
	public WebElement favoriteNote;

	@FindBy(xpath = "(//span[text()='Malignant neoplasm of testis'])[1]")
	public WebElement editFavorite;

	@FindBy(xpath = "//td[text()='Malignant neoplasm of testis']//following::div[1]")
	public WebElement removeFavoriteCode;
	
	@FindBy(css = "div#remove")
	public List<WebElement> removeFavoriteBaisc;

	@FindBy(xpath = "//span[@id='select']")
	///(//span[text()='Malignant neoplasm of testis'])[1]//parent::div//parent::div[1]//parent::div[1]/div[1]/span[1]
	public List<WebElement> addThisFavorite;
	
	
	
	@FindBy(xpath = "(//div[@id='ProblemsFavKpop2']/div[1]//following::span[1])[1]")
	public WebElement closeFavorite;
	

	public Problems(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
