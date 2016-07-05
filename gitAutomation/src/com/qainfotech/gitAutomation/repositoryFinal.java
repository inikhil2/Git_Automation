package com.qainfotech.gitAutomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class repositoryFinal extends GitAutomation {
WebDriver driver;
String s;
public repositoryFinal (){
	PageFactory.initElements(driver, this);
}
public repositoryFinal(WebDriver driver){
	this.driver=driver;
	PageFactory.initElements(driver, this);
	
	
}

@FindBy(css=".form-control.js-git-clone-help-field.url-field.js-zeroclipboard-target")
//form-control js-git-clone-help-field url-field js-zeroclipboard-target
WebElement cloneURL;

/*@FindBy(css=".form-control.input-sm.js-git-clone-help-field url-field.js-zeroclipboard-target")
WebElement url;*/

public String getCloneUrl(){
	s= cloneURL.getAttribute("value");
	System.out.println(s);
	return s;
	
}
}
