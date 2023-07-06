package baseClasses;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import baseClasses.TestBase;


public class GooglePage extends TestBase{

	@FindBy(id="APjFqb")
	protected WebElement searchFld;

	@FindBy(xpath="//input[@aria-label='Google Search']")
	protected WebElement searchBtn;

	@FindBy(xpath="//input[@aria-label='I'm Feeling Lucky']")
	protected WebElement luckyBtn;
	
	@FindBy(id="result-stats")
	protected WebElement resultStats;
	
	@FindBy(xpath="/html/body/div[7]/div/div[13]/div/div[2]/div[2]/div/div/div[1]/div/div/div[1]/div/a/h3")
	protected WebElement firstResult;

	// Constructor
		public GooglePage(){
			PageFactory.initElements(driver, this);
		}

	Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(60)).ignoring(NoSuchElementException.class).ignoring(ElementClickInterceptedException.class).ignoring(StaleElementReferenceException.class).ignoring(NotFoundException.class).pollingEvery(Duration.ofMillis(500));

	// Methods
		public void enterData(String data) {
			wait.until(ExpectedConditions.visibilityOf(searchFld));
			searchFld.sendKeys(data);
		}

		public void clickOnSearchBtn() {
			wait.until(ExpectedConditions.visibilityOf(searchBtn));
			searchBtn.click();
			try {Thread.sleep(5000);} catch (InterruptedException e) {e.printStackTrace();}
		}

		public void clickOnFeelingLuckyBtn() {
			wait.until(ExpectedConditions.visibilityOf(searchBtn));
			searchBtn.click();
			try {Thread.sleep(5000);} catch (InterruptedException e) {e.printStackTrace();}
		}
		
		public void getResultStats() {
			System.out.println(resultStats.getText());
		}
		
		public void getFirstResult() {
			System.out.println(firstResult.getText());
		}

}