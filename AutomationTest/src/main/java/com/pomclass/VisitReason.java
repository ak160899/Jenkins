package com.pomclass;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VisitReason {

	public WebDriver driver;

	@FindBy(xpath = "//div[contains(@title,'Add Visit R')]")
	public WebElement AddIcon;

	@FindBy(xpath = "//div[@title='Enter the description of the patient visit']")
	public WebElement discription;

	@FindBy(xpath = "//div[@id='Visit_ReasonKpop2']/div[2]/div[2]/button[2]")
	public WebElement save;

	@FindBy(xpath = "(//button[@id='admissionVal_dropdown'])[2]//following::ul[1]/li/a")
	public List<WebElement> appointmentTypeDropDown;

	@FindBy(xpath = "(//div[text()='cold'])[1]")
	public WebElement edit;

	@FindBy(xpath = "//div[contains(@title,'Show my favorite Visit ')]")
	public WebElement favoriteIcon;

	@FindBy(xpath = "//div[@id='Visit_ReasonFavKpop2']/div[2]/div[1]/div/table/tbody/tr/td[4]/span[2]")
	public WebElement addNewFavorite;

	@FindBy(xpath = "(//button[@id='admissionVal_dropdown'])[2]//following::ul[1]/li/a/span[2]")
	public List<WebElement> selectFavoriteAppointmnetType;
	
	@FindBy(xpath = "//div[@id='Visit_ReasonPellVal']/div[2]")
	public WebElement favoriteDiscription;
	
	@FindBy(xpath = "//div[@id='Visit_ReasonPell']//following::button[2]")
	public WebElement FavoriteSave;
	
	@FindBy(xpath = "(//div[text()='favorite visit reason'])[1]")
	public WebElement editFavorite;
	
	
	@FindBy(xpath = "(//span[@title='Add this visit reason'])[1]")
	public WebElement addThisFavorite;
	
	
	@FindBy(xpath = "//div[@id='Visit_ReasonFavKpop2']/div[1]/div[1]//following::span[1]")
	public WebElement closeFavorite;
	

	public VisitReason(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
