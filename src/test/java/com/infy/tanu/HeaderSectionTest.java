package com.infy.tanu;

import Pages.HeaderSection;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;

public class HeaderSectionTest {
    WebDriver driver;
    HeaderSection hd;
    LoginPage lp;
    WebDriverWait wait;

    @BeforeMethod
    public  void setUp(){
        driver=new FirefoxDriver();
        driver.get("https://qajobbyapp.ccbp.tech/login");
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        hd=new HeaderSection(driver);
        lp=new LoginPage(driver);
        lp.loginToApplication("rahul","rahul@2021");
        wait.until(ExpectedConditions.urlToBe("https://qajobbyapp.ccbp.tech/"));
    }

    //@AfterMethod
    public  void tearDown(){
        driver.close();

    }

    @Test
    public  void testAppLogoImg(){

        Assert.assertTrue(hd.findAppLogo().isDisplayed(),"App logo is not displayed");
    }

    @Test(priority = 1)
    public  void testNavigationByNavJobsLink(){
        hd.clickOnNavJobsLink();
        wait.until(ExpectedConditions.urlToBe("https://qajobbyapp.ccbp.tech/jobs"));
        Assert.assertEquals(driver.getCurrentUrl(),"https://qajobbyapp.ccbp.tech/jobs","URLs do not match");
    }

    @Test(priority = 2)
    public  void testNavigationByAppLogoLink(){
        hd.clickOnNavJobsLink();
        hd.clickOnAppLogo();
        Assert.assertEquals(driver.getCurrentUrl(),"https://qajobbyapp.ccbp.tech/","URLs do not match");

    }
    @Test(priority = 3)
    public  void testNavigationByNavHomeLink(){
        hd.clickOnNavJobsLink();
        hd.clickOnNavHomeLink();
        Assert.assertEquals(driver.getCurrentUrl(),"https://qajobbyapp.ccbp.tech/","URLs do not match");
    }

    @Test(priority = 4)
    public  void testLogoutFunctionality(){
        hd.logout();
        Assert.assertEquals(driver.getCurrentUrl(),"https://qajobbyapp.ccbp.tech/login","URLs do not match");
    }
}
