package com.pomclass;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Symptoms {

	public WebDriver driver;

	@FindBy(xpath = "//div[contains(@title,'Add Symptoms')]")
	public WebElement addicon;

	@FindBy(xpath = "//div[@id='SymptomsKpop2']/div[2]/div/div[2]/div[2]/input")
	public WebElement icd;

	@FindBy(xpath = "//div[@id='addfav-div']/div/div/div[4]//following::div[1]//following::ul[1]/li/a/div")
	public List<WebElement> icdList;

	@FindBy(xpath = "//div[@id='SymptomsKpop2']/div[2]/div/div[3]/div[2]/input")
	public WebElement symptoms;

	@FindBy(xpath = "//div[@id='SymptomsKpop2']/div[2]/div[2]/button[2]")
	public WebElement save;

	@FindBy(xpath = "(//div[text()='R76.1: Abnormal reaction to tuberculin test'])[1]")
	public WebElement curePast;

	@FindBy(xpath = "(//div[text()='R76.1: Abnormal reaction to tuberculin test'])[1]//following::div[10]//following::div[1]/span[1]")
	public WebElement yesCure;

	@FindBy(xpath = "//div[contains(@title,'Add Symptoms')]//following::div[1]")
	public WebElement ellipses;

	@FindBy(xpath = "//div[contains(@title,'Add Symptoms')]//following::div[1]//following::ul[1]/li")
	public List<WebElement> ellipsesList;

	@FindBy(xpath = "(//span[text()='Past Cured Symptom'])[1]//following::div[1]/div[3]/div/div/span")
	public WebElement addPast;

	@FindBy(xpath = "(//span[text()='Past Cured Symptom'])[1]//parent::div/span[1]")
	public WebElement closePast;

	@FindBy(xpath = "//div[contains(@title,'Show my favorite Symptoms list fo')]")
	public WebElement favoriteIcon;

	@FindBy(xpath = "//div[@id='SymptomsFavKpop2']/div[2]/div[1]/div/table/tbody/tr/td[4]/span[2]")
	public WebElement addNewFavorite;

	@FindBy(id = "longDescription")
	public WebElement favoriteicd;

	@FindBy(xpath = "//div[@id='Symptom-div']/div[2]/input")
	public WebElement favoriteSymptom;

	@FindBy(xpath = "//div[@id='addfav-div']/div/div/div[4]//following::div[1]//following::ul[1]/li/a/div")
	public List<WebElement> favoriteicdList;

	@FindBy(id = "accept-btn")
	public WebElement favoriteSave;
	
	@FindBy(xpath = "(//div[text()='R76.1: Abnormal reaction to tuberculin test'])[2]")
	public WebElement editFavorite;
	
	@FindBy(xpath = "//span[text()='R76.1']//following::span[1]")
	public WebElement removeFavoriteIcd;
	
	
	@FindBy(xpath = "(//span[contains(@title,'Add this symptom')])[1]")
	public WebElement addThisFavorite;
	
	
	@FindBy(xpath = "//div[@id='SymptomsFavKpop2']/div[1]/div[1]//following::span[1]")
	public WebElement closeFavorite;
	
	public Symptoms(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
