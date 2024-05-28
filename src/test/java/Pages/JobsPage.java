package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class JobsPage {

    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;
  public   JobsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        js=(JavascriptExecutor) driver;
    }


    By profileImgLocator= By.xpath("//img[@alt='profile']");
    By profileNameLocator=By.className("profile-name");
    By shortBioLocator=By.className("short-bio");
    By searchInputLocator=By.cssSelector("div[class ^='desktop'] input.search-input");
    By searchBtnLocator=By.cssSelector("div[class ^='desktop'] button.search-button");
    By jobsListLocator=By.xpath("//h1[@class='title']");

    By noJobsFoundImgLocator=By.className("jobs-not-found-img");
    By noJobgsFoundHeadingLocator=By.className("jobs-not-found-heading");
    By noJobsFoundDesLocator=By.className("jobs-not-found-description");


    public WebElement findProfileimg(){
       return wait.until(ExpectedConditions.visibilityOfElementLocated(profileImgLocator));
        //return driver.findElement(profileImgLocator);
    }

    public String getProfileName(){
       return driver.findElement(profileNameLocator).getText();
    }

    public String getShortBio(){
        return driver.findElement(shortBioLocator).getText();
    }



    public void enterSearchText(String searchtext) {
        driver.findElement(searchInputLocator).sendKeys(searchtext);
    }

    public  void clickOnSearchBtn(){

        //wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(searchBtnLocator))).click();
        driver.findElement(searchBtnLocator).click();
    }

    public  int getNumberOfJobsDisplayed(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(jobsListLocator));
        return driver.findElements(jobsListLocator).size();
    }

    public WebElement findNoJobsFoundImg(){
        return  driver.findElement(noJobsFoundImgLocator);
    }

    public String getNoJobsFoundHeading(){
        return driver.findElement(noJobgsFoundHeadingLocator).getText();
    }

    public  String getNoJobsFoundDescription(){
        return driver.findElement(noJobsFoundDesLocator).getText();
    }


    public void search(String text){
        enterSearchText(text);
        clickOnSearchBtn();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(jobsListLocator));
    }
}
