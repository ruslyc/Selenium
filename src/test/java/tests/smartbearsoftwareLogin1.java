package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class smartbearsoftwareLogin1 {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/ \n" +
                "login.aspx");
        driver.manage().window().maximize();
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_login_button")).click();
        String message = driver.findElement(By.id("ctl00_MainContent_status")).getText();
        if(message.equals("Invalid Login or Password.")){
            System.out.println("Error message passed");
        }else{
            System.out.println("Error message failed");
        }
    }
    public boolean negativeLogin(WebDriver driver, String username, String password){
        driver.findElement(By.id("ctl00_MainContent_username")).clear();
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys(username);
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys(password);
        driver.findElement(By.id("ctl00_MainContent_login_button")).click();
        String message = driver.findElement(By.id("ctl00_MainContent_status")).getText();
        if(message.equals("Invalid Login or Password.")){
            return true;
        }else{
            return false;
        }
    }
}