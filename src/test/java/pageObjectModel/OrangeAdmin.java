package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import pages.OrangeHomePage;
import pages.OrangeLoginPage;
import utilities.Config;
import utilities.Driver;
import utilities.TestBase;

import java.util.List;

public class OrangeAdmin extends TestBase {

    @Test
    public void login(){
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("admin123");
        driver.findElement(By.id("btnLogin")).click();
        WebElement admin = driver.findElement(By.id("welcome"));
        Assert.assertTrue(admin.isDisplayed());
    }

    @Test
    public void loginVerification(){
        driver.get("https://opensource-demo.orangehrmlive.com/");
        OrangeLoginPage olp = new OrangeLoginPage();
        olp.login("Admin", "admin123");
        OrangeHomePage ohp = new OrangeHomePage(driver);
        Assert.assertTrue(ohp.welcomeAdmin.isDisplayed());
        ohp.welcomeAdmin.click();
        ohp.aboutLink.click();
        Assert.assertTrue(ohp.aboutPopUp.getText().contains("OrangeHRM"));

    }

    @Test
    public void jobTitleVerification(){
        driver.get("https://opensource-demo.orangehrmlive.com/");
        OrangeLoginPage olp = new OrangeLoginPage();
        olp.login("Admin", "admin123");
        OrangeHomePage ohp = new OrangeHomePage(driver);
        Actions action = new Actions(driver);
        action.moveToElement(ohp.performance).perform();
        action.moveToElement(ohp.configure).perform();
        ohp.KPIs.click();
        Select jobTitle = new Select(ohp.jobSelectDropDown);
        List<WebElement> options = jobTitle.getOptions();
        boolean found = false;
        for (WebElement w: options) {
            if(w.getText().equals("CEO")){
                found = true;
                break;
            }
        }
        Assert.assertTrue(found);
    }
    @Test
    public void negativeLogin(){
        Driver.getDriver().get(Config.getProperty("url"));
        String username = Config.getProperty("userName");

    }

}
