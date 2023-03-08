package com.pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Notes {

	public WebDriver driver;

	@FindBy(xpath = "//div[contains(@title,'Add Notes')]")
	public WebElement addIcon;

	@FindBy(xpath = "//div[@title='Enter the notes description of the patient visit']")
	public WebElement enterNote;

	@FindBy(xpath = "//div[@id='NotesKpop2']/div[2]/div[2]/button[2]")
	public WebElement save;

	@FindBy(xpath = "//div[text()='hell']")
	public WebElement edit;

	@FindBy(xpath = "//div[contains(@title,'Show my favorite Notes list ')]")
	public WebElement favoriteIcon;

	@FindBy(xpath = "//div[@id='NotesFavKpop2']/div[2]/div[1]/div/table/tbody/tr/td[4]/span[2]")
	public WebElement addNewFavorite;

	@FindBy(xpath = "//div[@id='NotesPellVal']/div[2]")
	public WebElement favoriteDiscription;
	
	@FindBy(xpath = "//div[@id='NotesPellVal']/div[2]//following::button[2]")
	public WebElement favoriteSave;
	
	@FindBy(xpath = "(//div[text()='Notes module'])[1]")
	public WebElement editFavorite;
	
	@FindBy(xpath = "(//span[contains(@title,'Add this note')])[2]")
	public WebElement addThisFavorite;
	
	@FindBy(xpath = "//div[@id='NotesFavKpop2']/div[1]/div[2]/span")
	public WebElement closeFavorite;
	

	public Notes(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
