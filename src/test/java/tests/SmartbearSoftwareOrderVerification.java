package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class SmartbearSoftwareOrderVerification {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/ \n" +
                "login.aspx");
        driver.manage().window().maximize();
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
        driver.findElement(By.id("ctl00_MainContent_login_button")).click();
        String date =  driver.findElement(By.xpath("//td[.='Susan McLaren']/../td[5]")).getText();
        if(date.equals("01/05/2010")){
            System.out.println("date verification passed");
        }else{
            System.out.println("date verification failed");
        }
        System.out.println(verifyOrder(driver,"Paul Brown"));

        printAllNames(driver);
    }
    public static boolean  verifyOrder(WebDriver driver, String name){

       List <WebElement> names = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td[2]"));
        System.out.println(names.size());
        for(WebElement w : names){
           if(w.getText().equals(name)){
               return true;
           }
        }return  false;
    }
    public static void printAllNames(WebDriver driver){
        List <WebElement> names = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td[2]"));
        for(WebElement w : names){
            System.out.println(w.getText());
        }
        System.out.println(names.size());
    }
}
