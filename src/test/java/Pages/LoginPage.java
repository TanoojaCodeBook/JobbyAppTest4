package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
   public WebDriver driver;
   public WebDriverWait wait;
    public LoginPage(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }



    By appLogoImgLocator=By.xpath("//img[@alt='website logo']");
    By labelsLocator=By.className("input-label");
    By userNameLocator=By.id("userNameInput");
    By passwordLocator=By.id("passwordInput");
    By loginButtonLocator=By.className("login-button");
    By errorMessageLocator=By.className("error-message");



    public WebElement findAppLogoImg(){
        return  driver.findElement(appLogoImgLocator);
    }


    public String getLabelTextAtIndex(int index){
        return  driver.findElements(labelsLocator).get(index).getText();
    }


    public  void enterUserName(String userName){
        driver.findElement(userNameLocator).sendKeys(userName);
    }

    public  void enterPassword(String password){
        driver.findElement(passwordLocator).sendKeys(password);
    }

    public  void clickOnLoginButton(){
        driver.findElement(loginButtonLocator).click();
    }


    public  void loginToApplication(String userName, String password){
        enterUserName(userName);
        enterPassword(password);
        clickOnLoginButton();
    }



    public  String getErrorMessage(){
        //return  driver.findElement(errorMessageLocator).getText();
      return   wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageLocator)).getText();
    }
}
