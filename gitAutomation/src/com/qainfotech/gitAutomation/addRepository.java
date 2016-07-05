package com.qainfotech.gitAutomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class addRepository extends GitAutomation{
	WebDriver driver;
	String repName = "Test_Repository";
	public addRepository(){
		
	}
	public addRepository(WebDriver driver){
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id="repository_name")
	WebElement repositoryName;
	
	@FindBy(css=".btn.btn-primary.first-in-line")
	WebElement btn;
	
	public void newRepository(){
		repositoryName.sendKeys(repName);
		btn.click();
	}
}