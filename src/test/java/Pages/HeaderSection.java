package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HeaderSection {
    WebDriver driver;
    WebDriverWait wait;
   public HeaderSection(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
        By appLogoImgLocator= By.xpath("//div[@class='nav-bar-large-container']/child::a");
        By appLogoLinkLocator=By.xpath("//div[@class='nav-bar-large-container']/child::a");
        By homeLinkLocator=By.linkText("Home");
        By jobsLinkLocator=By.linkText("Jobs");
        By logoutBtnLoator=By.xpath("//button[normalize-space()='Logout']");


      public WebElement findAppLogo(){
          return driver.findElement(appLogoImgLocator);
        }

        public  void clickOnAppLogo(){
          driver.findElement(appLogoImgLocator).click();
        }

        public  void clickOnNavHomeLink(){
          driver.findElement(homeLinkLocator).click();
        }

        public  void clickOnNavJobsLink(){
          driver.findElement(jobsLinkLocator).click();
        }

        public  void clickOnLogoutBtn(){
          driver.findElement(logoutBtnLoator).click();
        }

        public void logout(){
          clickOnLogoutBtn();
          driver.switchTo().alert().accept();
        }
}

