package TestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WindowHandling {

    WebDriver driver;
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void herokuapp()  {
        driver.get("http://the-internet.herokuapp.com/windows");
        String mainHandle = driver.getWindowHandle();
        System.out.println(driver.getTitle());
        driver.findElement(By.linkText("Elemental Selenium")).click();
        List<String> allHandles = new ArrayList<String>(driver.getWindowHandles());
        System.out.println(driver.getTitle());
        for (String s:allHandles) {
            if(!s.equals(mainHandle)){
                driver.switchTo().window(s);
                break;
            }
        }
        System.out.println(driver.getTitle());
        driver.close();
        driver.switchTo().window(mainHandle);
        System.out.println(driver.getTitle());
    }
}
