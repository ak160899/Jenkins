package com.pomclass;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Goals {
	public WebDriver driver;

	@FindBy(xpath = "//div[contains(@title,'Add Goals')]")
	public WebElement addicon;

	@FindBy(xpath = "//div[@title='Enter goal']")
	public WebElement enterGoal;

	@FindBy(xpath = "//div[@id='GoalsKpop2']/div[2]/div[1]/div[2]/div/input")
	public WebElement DateField;

	@FindBy(xpath = "//select[@class='ui-datepicker-month']")
	public WebElement selectMonth;

	@FindBy(xpath = "//a[text()='14']")
	public WebElement chooseDate;

	@FindBy(xpath = "//div[@id='GoalsKpop2']/div[2]/div[2]/button[2]")
	public WebElement save;

	@FindBy(xpath = "//div[text()='goal1']")
	public WebElement edit;

	@FindBy(xpath = "(//div[text()='HELLO THIS IS GOALS MODULE.'])[1]")
	public WebElement curePast;

	@FindBy(xpath = "(//div[text()='HELLO THIS IS GOALS MODULE.'])[1]//following::div[14]/span[1]")
	public WebElement yesCure;

	@FindBy(xpath = "//div[@title='Show my favorite Goals list for selection']//following::div[2]")
	public WebElement ellipses;

	@FindBy(xpath = "//div[@title='Show my favorite Goals list for selection']//following::div[2]//following::ul[1]/li/a")
	public List<WebElement> ellipsesList;

	@FindBy(xpath = "(//span[@title='Click to add this goal'])[2]")
	public WebElement addPast;

	@FindBy(xpath = "//div[contains(@title,'Show my favorite Goals list for ')]")
	public WebElement favoriteIcon;

	@FindBy(xpath = "//div[@id='GoalsFavKpop2']/div[2]/div[1]/div/table/tbody/tr/td[4]/span[2]")
	public WebElement addNewFavorite;

	@FindBy(xpath = "//div[@id='GoalsPellVal']/div[1]/button[1]")
	public WebElement favoritePellContent;
	
	@FindBy(xpath = "//div[@id='GoalsPellVal']/div[2]")
	public WebElement favoriteDiscription;
	
	@FindBy(xpath = "//div[@id='addfav-div']/div[1]//following::button[2]")
	public WebElement favoritesave;
	
	@FindBy(xpath = "(//span[contains(@title,'Add this goal')])[1]")
	public WebElement addThisFavorite;
	
	@FindBy(xpath = "//div[@id='GoalsFavKpop2']/div[1]/div[2]/span")
	public WebElement closeFavorite;
	
	

	@FindBy(xpath = "(//span[text()='Past Completed Goals'])[1]//parent::div[1]/span[1]")
	public WebElement closePast;

	public Goals(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
