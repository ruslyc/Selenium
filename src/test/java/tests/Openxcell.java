package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Openxcell {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
//        driver.get("http://openxcell.com");
//        driver.manage().window().maximize();
//        System.out.println(driver.getTitle());
//        WebElement caseStudies = driver.findElement(By.linkText("Case Studies"));
//        System.out.println(caseStudies.getAttribute("class"));
//        System.out.println(caseStudies.getAttribute("href"));
//        System.out.println(caseStudies.getText());
//        List <WebElement> links = driver.findElements(By.xpath("//body//a"));
//        System.out.println(links.size());
//        for(WebElement w : links){
//            System.out.println(w.getAttribute("href"));
//        }
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/ \n" +
                "login.aspx");
        driver.manage().window().maximize();
        String title = driver.getTitle();
        if(title.equals("Web Orders Login")){
            System.out.println("Title passed");
        }







    }
}
