package com.qainfotech.gitAutomation;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.util.logging.Logger;

import org.eclipse.jetty.util.log.LoggerLog;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class GitAutomation {
	static WebDriver driver;
	loginPage lp;
	addRepository arp;
	landingPage ldp;
	mainPage mp;
	repositoryFinal rpf;
	TestScript tsc;
	Validate va;
	ShellScript ssc;
/*	commandLineAutomation ce;*/
	@BeforeTest
	  public void beforeClass() {
	  driver=new FirefoxDriver();
	  final Logger log= Logger.getLogger("InfoLogging");
	  }
	
  @Test
  public void autogit() throws InterruptedException, IOException {
	  
	  driver.get("https://github.com/");
	  ldp = new landingPage(driver);
	  ldp.hit();
	  lp =new loginPage(driver);
	  lp.signIn();
	  mp = new mainPage(driver);
	  mp.addRepository();
	  arp= new addRepository(driver);
	  arp.newRepository();
	  rpf = new repositoryFinal(driver);
	  rpf.getCloneUrl();
	  //String url= rpf.getCloneUrl();
	  //System.out.println(url);
	 
	 
	
	  ssc= new ShellScript();
	  ssc.createShellFile();
	  ssc.execute(rpf.s, lp.user,lp.pass);
	  tsc = new TestScript();
	  tsc.exec();
	  va= new Validate(driver);
	  va.validateCode();
	  va.validateCommit();
	  
  }
  @Test
  public void validate() {
	  driver.get("https://github.com/qaitautomation/Test_Repository");
	  	  
  }
  

  @AfterTest
  public void afterClass() {
	  //let
  }

}
