package com.qainfotech.gitAutomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class mainPage extends GitAutomation {

	 WebDriver driver;
	public mainPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".btn.btn-sm.btn-primary")
	WebElement newRepository;
	
	public void addRepository(){
		
		newRepository.click();
	}
	
}
