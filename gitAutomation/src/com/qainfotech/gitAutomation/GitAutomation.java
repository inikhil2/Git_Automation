package com.qainfotech.gitAutomation;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class GitAutomation {
	public static WebDriver driver;
	loginPage lp;
	addRepository arp;
	landingPage ldp;
	mainPage mp;
	repositoryFinal rpf;
	TestScript tsc;
	Validate va;
	ShellScript ssc;
	String title;
	addReadMe arm;
/*	commandLineAutomation ce;*/
	@BeforeTest
	  public void beforeClass() {
	  driver=new FirefoxDriver();
	 // final Logger log= Logger.getLogger("InfoLogging");
	  }
	
  @Test
  public void autogitTest() throws InterruptedException, IOException {
	  
	  driver.get("https://github.com/");
  }
  
  @Test(dependsOnMethods = { "autogitTest" })
  public void landingPageTest(){

	  ldp = new landingPage(driver);
	  ldp.hit();
	  title=driver.getTitle();
	  //if(title.contains("https://github.com/"))
		  System.out.println(title);

  }
  
  @Test(dependsOnMethods = { "landingPageTest" })
  public void loginPageTest(){
	  lp =new loginPage(driver);
	  lp.signIn();
	  title= driver.getTitle();
	  //if(title.contains("https://github.com/login"))
		  System.out.println(title);
  }
  
  @Test(dependsOnMethods = { "loginPageTest" })
  public void addRepositoryTest(){
	  mp = new mainPage(driver);
	  mp.addRepository();
	  title= driver.getTitle();
	  //if(title.contains("https://github.com/login"))
		  System.out.println(title);
  }
  
  @Test(dependsOnMethods = { "addRepositoryTest" })
  public void newRepositoryTest(){
	  arp= new addRepository(driver);
	  arp.newRepository();
	  title= driver.getTitle();
	  //if(title.contains("https://github.com/login"))
		  System.out.println(title);
  }
  
  @Test(dependsOnMethods = { "newRepositoryTest" })
  public void finalRepositoryPageTest(){
	  rpf = new repositoryFinal(driver);
	  rpf.getCloneUrl();
	  title= driver.getTitle();
	  //if(title.contains("https://github.com/login"))
		  System.out.println(title);
  } 
  
  @Test(dependsOnMethods = { "finalRepositoryPageTest" })
  public void createShellFileTest() throws IOException, InterruptedException{
	  ssc= new ShellScript();
	  ssc.createShellFile();
	  ssc.execute(rpf.s, lp.user,lp.pass);
  } 
  
  @Test(dependsOnMethods ={"createShellFileTest"})
  public void shellScriptingTest(){
	  tsc = new TestScript();
	  tsc.exec();
  }
  
  @Test(dependsOnMethods ={"shellScriptingTest"})
  public void validate() throws InterruptedException {
	  Thread.sleep(2000);
	  driver.get("https://github.com/qaitautomation/Test_Repository");
	  va= new Validate(driver);
	  va.validateCode();
	  va.validateCommit();	  
  }
  
  @Test(dependsOnMethods ={"validate"})
  public void addReadmeTest(){
	  arm = new addReadMe(driver);
	  arm.createReadMe();
	  arm.addText();
  }

  @AfterTest
  public void afterClass() {
	  //let
  }

}
