package com.infy.tanu;

import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class HomePageTest {

    WebDriver driver;
    LoginPage lp;
    WebDriverWait wait;
    HomePage hp;

    @BeforeMethod
    public  void setUp(){
        driver=new EdgeDriver();
        lp=new LoginPage(driver);
        hp=new HomePage(driver);
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://qajobbyapp.ccbp.tech/login");
        lp.loginToApplication("rahul","rahul@2021");
        wait.until(ExpectedConditions.urlToBe("https://qajobbyapp.ccbp.tech/"));
    }

    @AfterMethod
    public  void tearDown(){
        driver.close();
    }

    @Test
    public  void testHomepageHeading(){
        Assert.assertEquals(hp.getHeadingText(),"Find The Job That Fits Your Life","Heading text does not match");
        Assert.assertEquals(hp.getDescriptionText(),"Millions of people are searching for jobs, salary information, company reviews. Find the job that fits your abilities and potential.","Description text does not match");

    }
}
