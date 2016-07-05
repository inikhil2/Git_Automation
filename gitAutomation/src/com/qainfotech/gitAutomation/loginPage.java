package com.qainfotech.gitAutomation;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {
 WebDriver driver;
 String user,pass;
	public loginPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="login_field")
	WebElement userName;
	
	@FindBy(id="password")
	WebElement passWord;
	
	@FindBy(css=".btn.btn-primary.btn-block")
	WebElement btn;
	public void signIn(){
		
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.println("Input username for Github: ");
		user=scan.nextLine();
		userName.sendKeys(user);
		System.out.println("Input password for Github: ");
	    pass=scan.nextLine();
		passWord.sendKeys(pass);
		
		
	    btn.click();
	}
	
}
