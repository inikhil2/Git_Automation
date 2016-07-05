package com.qainfotech.gitAutomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Validate {

	WebDriver driver;
	public Validate(WebDriver driver){
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="a.js-navigation-open")
	WebElement code;
	@FindBy(css="a.message")
	WebElement commit;
	
	public boolean validateCode() {
		String onGit=code.getText();
		if(onGit.equals("Hello"))
		return true;
		else
		return false;
	}

	
	public boolean validateCommit() {
		String onGit =commit.getText();
		if(onGit.equals("First Commit")){
			System.out.println("True");
			return true;
		}
			
			else{
			System.out.println("False");
				return false;
			}
	}
	
}
