package com.qainfotech.gitAutomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class landingPage  extends GitAutomation{
	WebDriver driver;
	public landingPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css = ".btn.site-header-actions-btn.mr-2")
	WebElement a;
	
	public void hit(){
		a.click();
	}

}
