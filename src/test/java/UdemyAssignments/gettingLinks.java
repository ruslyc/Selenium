package UdemyAssignments;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class gettingLinks {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://qaclickacademy.com/practice.php");
        WebElement FooterDriver = driver.findElement(By.id("gf-BIG"));
        WebElement columnDriver = FooterDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        List<WebElement> links =  columnDriver.findElements(By.tagName("a"));
        String openTabs = Keys.chord(Keys.CONTROL, Keys.ENTER);
        for (WebElement w:links) {
            w.sendKeys(openTabs);
        }
        Set<String> handles = driver.getWindowHandles();

        Iterator<String> it = handles.iterator();
        while(it.hasNext()){
            driver.switchTo().window(it.next());
            System.out.println(driver.getTitle());
        }
    }
}
