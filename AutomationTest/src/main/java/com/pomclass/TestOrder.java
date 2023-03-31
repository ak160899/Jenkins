package com.pomclass;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestOrder {

	public WebDriver driver;

	@FindBy(xpath = "//div[contains(@title,'Add Test Order')]")
	public WebElement addIcon;

	@FindBy(xpath = "//div[@id='Test_OrderKpop2']/div[2]/div[1]/div[1]/div[2]/input")
	public WebElement icd;

	@FindBy(xpath = "//div[@id='Test_OrderKpop2']/div[2]/div[4]/div/button//following::ul[2]/li/a/div")
	public List<WebElement> icdList;

	@FindBy(xpath = "//div[@id='Test_OrderKpop2']/div[2]/div[2]/div/button")
	public WebElement more;

	@FindBy(xpath = "//div[@id='Test_OrderKpop2']/div[2]/div[2]/div/button//following::ul[1]/li")
	public List<WebElement> moreDropdown;

	@FindBy(xpath = "//div[@id='Test_OrderKpop2']/div[2]/div[1]/div[1]/div[2]//following::div[1]//following::div[1]/div[2]/input")
	public WebElement notes;

	@FindBy(xpath = "//div[@id='Test_OrderKpop2']/div[2]/div[2]/div[1]//following::div[3]/button")
	public WebElement save;
	@FindBy(xpath = "//div[@id='Test_OrderKpop2']/div[2]/div[2]/div[1]//following::div[3]/button//following::ul[1]/li")
	public List<WebElement> saveMore;
	
	
	
	
	
	

	public TestOrder(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	

}
