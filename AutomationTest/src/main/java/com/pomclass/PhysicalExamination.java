package com.pomclass;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PhysicalExamination {

	public WebDriver driver;

	@FindBy(xpath = "//div[contains(@title,'Add Physical Examination')]")
	public WebElement addIcon;

	@FindBy(id = "bodyParts")
	public WebElement organItem;

	@FindBy(id = "finding")
	public WebElement finding;

	@FindBy(xpath = "//div[@id='Physical_ExaminationsKpop2']/div[2]/div[2]/div/button")
	public WebElement more;

	@FindBy(xpath = "//div[@id='Physical_ExaminationsKpop2']/div[2]/div[2]/div/button//following::ul[1]/li")
	public List<WebElement> moreDropDown;

	@FindBy(xpath = "//input[@id='notes']")
	public WebElement notes;

	@FindBy(xpath = "//div[@id='Physical_ExaminationsKpop2']/div[2]/div[3]/button[2]")
	public WebElement save;

	@FindBy(xpath = "//div[text()='lets goo']")
	public WebElement edit;

	@FindBy(xpath = "//div[contains(@title,'Show my favorite Physical Examination list')]")
	public WebElement favoriteIcon;

	@FindBy(xpath = "//div[@id='Physical_ExaminationsFavKpop2']//following::div[2]/div[1]/div/table/tbody/tr/td[4]/span[2]")
	public WebElement addNewFavorite;

	@FindBy(xpath = "//div[@id='pNotes']/div[2]/input")
	public WebElement favoriteNotes;

	@FindBy(xpath = "//div[@id='Physical_ExaminationsKpop2']/div[2]/div[2]/button[2]")
	public WebElement favoriteSave;
	
	@FindBy(xpath = "(//div[text()='hello'])[1]")
	public WebElement editFavorite;
	
	@FindBy(xpath = "(//div[text()='hello'])[1]//parent::div[1]//parent::div[1]/div[1]/span[1]")
	public WebElement addThisFavorite;
	
	@FindBy(xpath = "//span[text()='Favorite Physical Examinations']//following::span[1]")
	public WebElement closeFavorite;
	

	public PhysicalExamination(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
