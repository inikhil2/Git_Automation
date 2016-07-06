package com.qainfotech.gitAutomation;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class addReadMe {
	
	WebDriver driver;
	
	public addReadMe(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".btn.btn-sm.btn-primary.flash-action")
	WebElement add;
	
	public void createReadMe(){
		add.click();
	}
	
	@FindBy(css=".ace_text-input")
	WebElement textArea;
	
	@FindBy(css="#submit-file")
	WebElement submit;
	
	public void addText(){
		textArea.sendKeys("Adding data to readme in the test repository.");
		textArea.sendKeys(Keys.PAGE_DOWN);
		submit.click();
	}

}
