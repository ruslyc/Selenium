package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SmartBear {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/ \n" +
                "login.aspx");
        driver.manage().window().maximize();
        String title1 = driver.getTitle();
        if(title1.equals("Web Orders Login")){
            System.out.println("Title1 passed");
        }else{
            System.out.println("Title1 test failed");
        }
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
        driver.findElement(By.id("ctl00_MainContent_login_button")).click();
        String title2 = driver.getTitle();
        if(title2.equals("Web Orders")) {
            System.out.println("Title2 passed");
        }else{
            System.out.println("Title2 test failed");
        }
        String url = driver.getCurrentUrl();
        if(url.equals("http://secure.smartbearsoftware.com/samples/testcomplete12/weborders/")){
            System.out.println("URL test passed");
        }else{
            System.out.println("URL test failed");
        }

    }

}
