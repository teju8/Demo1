package testClasses;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import baseClasses.GooglePage;
import baseClasses.TestBase;


public class RunTests extends TestBase{

	GooglePage GooglePage;
	
	public RunTests(){
			super();
	}

	@BeforeSuite(alwaysRun = true)
	@Parameters( {"configFile"} )
	public void setUp(){
				GooglePage = new GooglePage();
	}

	@AfterSuite(alwaysRun = true)
	public void tearDown() throws Exception {
		try {Thread.sleep(20000);} catch (InterruptedException e) {e.printStackTrace();}
		driver.quit();
	}

	@Test(priority=1, enabled=false)
	public void SearchKeyword(){
		GooglePage.enterData("google");
		GooglePage.clickOnSearchBtn();
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.google.com"));
		
	}

	@Test(priority=2, enabled=false)
	public void getResultStats(){
		GooglePage.enterData("google");
		GooglePage.clickOnSearchBtn();
		GooglePage.getResultStats();
	}

	@Test(priority=3, enabled=false, groups= {"Login"})
	public void getFirstResult() {
		GooglePage.enterData("google");
		GooglePage.clickOnSearchBtn();
		GooglePage.getFirstResult();		
	}
}
