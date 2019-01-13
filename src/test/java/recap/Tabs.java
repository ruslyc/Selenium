package recap;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Tabs {

    WebDriver driver;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void startTest(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    @Test
    public void todo(){
        System.out.println("Ignore this one");
    }

    @Test
    public void multipleTabs(){
        driver.get("http://amazon.com");
        ((JavascriptExecutor) driver).executeScript("window.open('http://www.google.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://www.etsy.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://www.openxcell.com','_blank');");
        List<String> handles = new ArrayList<String>(driver.getWindowHandles());
        for (String s:handles) {
            driver.switchTo().window(s);
            if(driver.getTitle().contains("Etsy")){
                System.out.println(driver.getCurrentUrl());
                break;
            }
        }

        System.out.println(driver.getTitle());
    }
}
