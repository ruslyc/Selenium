package TestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Iframe {

    WebDriver driver;
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com");
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void iFrame() throws InterruptedException {
        driver.switchTo().frame(driver.findElement(By.xpath("//div[@id = 'facebook_block']//iframe")));
        Thread.sleep(2000);
        System.out.println(driver.findElement(By.xpath("//span[@id = 'u_0_6']")).getText());
        driver.switchTo().defaultContent();


    }
}
