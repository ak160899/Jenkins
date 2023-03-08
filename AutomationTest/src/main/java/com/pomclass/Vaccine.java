package com.pomclass;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Vaccine {

	public WebDriver driver;

	@FindBy(xpath = "//div[contains(@title,'Add Vaccine')]")
	public WebElement addIcon;

	@FindBy(xpath = "//select[@id='date-type']")
	public WebElement selectDateType;

	@FindBy(id = "vaccine-cvx")
	public WebElement vaccineCvx;

	@FindBy(id = "vaccineName")
	public WebElement vaccineName;
	
	@FindBy(xpath = "//div[text()='TT']")
	public WebElement edit;

	@FindBy(xpath = "//div[@id='VaccineKpop2']/div[2]/div[3]/button[@id='accept-btn']")
	public WebElement save;

	@FindBy(xpath = "//div[@title='Show my favorite Vaccine list for selection']//following::div[2]")
	public WebElement ellipses;

	@FindBy(xpath = "//div[@title='Show my favorite Vaccine list for selection']//following::div[2]//following::ul[1]/li/a/span[2]")
	public List<WebElement> ellipsesList;

	@FindBy(xpath = "(//div[text()='TT INJECTION'])[1]")
	public WebElement curePast;

	@FindBy(xpath = "(//div[text()='TT INJECTION'])[1]//following::span[3]")
	public WebElement yesCure;

	@FindBy(xpath = "(//span[@title='Click to add this vaccine'])[2]")
	public WebElement addThisVaccine;
	@FindBy(xpath = "(//span[text()='Past Taken Vaccine'])[1]//parent::div/span[1]")
	public WebElement cancelPastTaken;

	@FindBy(xpath = "//div[contains(@title,'Show my favorite Vaccine list ')]")
	public WebElement favoriteicon;

	@FindBy(id = "plus-add")
	public WebElement addNewFavorite;

	@FindBy(xpath = "//div[@id='VaccineKpop2']/div[1]/div[1]//following::input[1]")
	public WebElement favoriteVaccineCvx;

	@FindBy(xpath = "//div[@id='VaccineKpop2']/div[1]/div[1]//following::input[2]//following::button[1]//following::ul[1]/li/a/span[2]")
	public List<WebElement> favoriteIcdList;

	@FindBy(id = "accept-btn")
	public WebElement favoriteSave;

	@FindBy(xpath = "(//span[@title='Add this vaccine'])[1]//following::div[1]/div[2]")
	public WebElement editFavorite;

	@FindBy(xpath = "//input[@id='vaccine-cvx']//following::span[3]")
	public WebElement removeFavoriteIcd;
	
	@FindBy(xpath = "(//span[@title='Add this vaccine'])[1]")
	public WebElement addThisFavorite;
	
	@FindBy(xpath = "//div[@id='VaccineFavKpop2']/div[1]/div[1]//following::span[1]")
	public WebElement closeFavorite;

	public Vaccine(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
