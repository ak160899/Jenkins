package com.pomclass;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Forms {
	public WebDriver driver;
	
	@FindBy(xpath = "//div[contains(@title,'Add Forms')]")
	public WebElement addIcon;
	
	@FindBy(xpath = "//span[@title='Edit this Form']")
	public List<WebElement> editicon;
	
	
	
	public Forms(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

}
