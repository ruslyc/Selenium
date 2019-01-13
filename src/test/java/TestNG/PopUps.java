package TestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PopUps {
    WebDriver driver;
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void popUp1() throws InterruptedException {
    driver.findElement(By.xpath("(//button)[1]")).click();
    driver.switchTo().alert().accept();
    driver.findElement(By.xpath("(//button)[2]")).click();
    driver.switchTo().alert().accept();
    driver.findElement(By.xpath("(//button)[3]")).click();
    driver.switchTo().alert().accept();
}
}