package com.infy.tanu;

import Pages.HomePage;
import Pages.JobsPage;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class JobPageTest {

    WebDriver driver;
    LoginPage lp;
    WebDriverWait wait;
    HomePage hp;
    JobsPage jp;

    @BeforeMethod
    public  void setUp(){
        driver=new FirefoxDriver();
        lp=new LoginPage(driver);
        hp=new HomePage(driver);
        jp=new JobsPage(driver);
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://qajobbyapp.ccbp.tech/login");
        lp.loginToApplication("rahul","rahul@2021");
        wait.until(ExpectedConditions.urlToBe("https://qajobbyapp.ccbp.tech/"));
        hp.clickOnFindJobsBtn();
        wait.until(ExpectedConditions.urlToBe("https://qajobbyapp.ccbp.tech/jobs"));
    }

    //@AfterMethod
    public  void tearDown(){
        driver.close();
    }


    @DataProvider
    public  Object[][] dataSet(){
        return new Object[][] {

                {"Devops Engineer","9"},  {"Backend Engineer","11"},  {"Frontend Engineer","13"},
                {"Fullstack Developer","6"},   {"Data Scientist","11"},  {"ML Engineer","10"},
        };
    }
    @Test
    public  void testProfielContainerUI(){

        Assert.assertTrue(jp.findProfileimg().isDisplayed(),"Profile image is not displayed");
        Assert.assertEquals(jp.getProfileName(),"Rahul Attluri","Profile name does not match");
        Assert.assertEquals(jp.getShortBio(),"Lead Software Developer and AI-ML expert","Bio does not match");

    }

    @Test(priority = 1, dataProvider = "dataSet")
    public  void testSuccessfulSearch(String jobName, String noOfJobs){
        jp.search(jobName);
        int acutalResult=jp.getNumberOfJobsDisplayed();
        Assert.assertEquals(acutalResult, Integer.parseInt(noOfJobs));

    }
}
