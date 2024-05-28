package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    WebDriver driver;
    WebDriverWait wait;
  public   HomePage(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }
  By headingLocator= By.className("home-heading");
    By descriptionLocator=By.className("home-description");
    By findJobsButtonLocator=By.className("find-jobs-button");


    public String getHeadingText(){
        return  driver.findElement(headingLocator).getText();
    }

    public  String getDescriptionText(){
        return  driver.findElement(descriptionLocator).getText();
    }

    public  void clickOnFindJobsBtn(){
        driver.findElement(findJobsButtonLocator).click();
    }

}
