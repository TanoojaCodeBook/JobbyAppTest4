package com.infy.tanu;

import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginPageTest {
    public WebDriver driver;
    LoginPage lp;
    WebDriverWait wait;

    @BeforeMethod
    public  void setUp(){
        driver=new FirefoxDriver();
        driver.get("https://qajobbyapp.ccbp.tech/login");
        lp=new LoginPage(driver);
        wait=new WebDriverWait(driver,Duration.ofSeconds(10));

    }

    @AfterMethod
    public  void tearDown(){
        driver.close();
    }

    @Test
    public  void testLoginPageUI(){

        Assert.assertTrue( lp.findAppLogoImg().isDisplayed(),"App logo is not displayed");


        Assert.assertEquals( lp.getLabelTextAtIndex(0),"USERNAME" ,"Username label text does not match");

       Assert.assertEquals(lp.getLabelTextAtIndex(1),"PASSWORD","Password label text does not match");


    }

    @Test(priority = 1)
    public void testSubmissionWithEmptyInputs(){
        lp.clickOnLoginButton();
        Assert.assertEquals(lp.getErrorMessage(),"*Username or password is invalid","Error text with empty input fields does not match");

    }

    @Test(priority = 2)
    public  void testSubmissionWithEmptyUserName(){
        lp.loginToApplication("","rahul@2021");
    Assert.assertEquals(lp.getErrorMessage(),"*Username or password is invalid","Error text with empty input field do not match");
    }


    @Test(priority = 3)
    public  void testSubmissionWithEmptyPassword(){
        lp.loginToApplication("rahul","");
        Assert.assertEquals(lp.getErrorMessage(),"*Username or password is invalid","Error text with empty input field do not match");
    }

    @Test(priority = 4)
    public  void testSubmissionWithInvalidcreds(){
        lp.loginToApplication("rahul","rahul");
        Assert.assertEquals(lp.getErrorMessage(),"*username and password didn't match","\"Error text with invalid password do not match");
    }

    @Test(priority = 5)
    public  void testSubmissionWithValiCreds(){
        lp.loginToApplication("rahul","rahul@2021");
        wait.until(ExpectedConditions.urlToBe("https://qajobbyapp.ccbp.tech/"));
        Assert.assertEquals(driver.getCurrentUrl(),"https://qajobbyapp.ccbp.tech/","URLs do not match");
    }
}
