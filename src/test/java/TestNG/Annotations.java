package TestNG;

import static org.testng.Assert.*;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.annotations.Test;

public class Annotations {
    WebDriver driver;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @BeforeMethod
    public void testSetup() throws InterruptedException {
        driver.get("http://opensource-demo.orangehrmlive.com");
        driver.manage().window().maximize();

    }
    @AfterMethod
    public void testCleanUp(){
      //  driver.close();
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void orangeTitleVerification(){
        assertEquals(driver.getTitle(),"OrangeHRM", "OrangeHRM Title verification");

    }
    @Test
    public void orangeLoginVerification(){
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("admin123" + Keys.ENTER);
        assertEquals(driver.getCurrentUrl(),"https://opensource-demo.orangehrmlive.com/index.php/dashboard", "login test failed");


    }

}
