package UdemyAssignments;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class Assignment2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://cleartrip.com");
        driver.manage().window().maximize();
        Select select = new Select(driver.findElement(By.id("Adults")));
        select.selectByIndex(1);
        select = new Select(driver.findElement(By.id("Childrens")));
        select.selectByIndex(1);
        driver.findElement(By.id("DepartDate")).click();
        List <WebElement> dates = driver.findElements(By.xpath("//table[@ class= 'calendar']//tr//td//a"));
        for(WebElement w : dates) {
            if (w.getAttribute("class").contains("highlight")) {
                w.click();
            }
        }
        driver.findElement(By.xpath("//a[@id='MoreOptionsLink']//strong")).click();
        driver.findElement(By.id("AirlineAutocomplete")).sendKeys("United");
        driver.findElement(By.id("SearchBtn")).click();
        WebElement error = driver.findElement(By.id("homeErrorMessage"));


        Alert alert = driver.switchTo().alert();
        alert.dismiss();

//        Actions a = new Actions(driver);
//
//        //a.moveToElement(driver.findElement(By.linkText()
//
//        a.moveByOffset(-5,-25).build().perform();



//        driver.get("http://www.itgeared.com/demo/1506-ajax-loading.html");
//        driver.findElement(By.partialLinkText("Click to load")).click();
//        WebDriverWait wait = new WebDriverWait(driver, 20);
//        WebElement result =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("results")));
//        String finalResult =  result.getText();
//        System.out.println(finalResult);

    }
}
