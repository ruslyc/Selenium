package UdemyAssignments;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Calendar {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://cleartrip.com");
        driver.manage().window().maximize();
        driver.findElement(By.id("DepartDate")).click();
        String desiredDay = "6";
        String desiredMonth = "April";
       while( !driver.findElement(By.cssSelector("[class='ui-datepicker-month']")).getText().contains(desiredMonth)){
           driver.findElement(By.cssSelector("[class = 'nextMonth ']")).click();
       }
        List<WebElement> days = driver.findElements(By.cssSelector("[class = 'ui-state-default ']"));
       for(int  i = 0; i<days.size(); i++){
           if(days.get(i).getText().equals(desiredDay)){
               days.get(i).click();
               break;
           }
       }
    }
}
