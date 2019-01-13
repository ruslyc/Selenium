package UdemyAssignments;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment4 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://qaclickacademy.com/practice.php");
        driver.findElement(By.id("checkBoxOption3")).click();
        String option = driver.findElement(By.id("checkBoxOption3")).getAttribute("value");
        Select s = new Select(driver.findElement(By.id("dropdown-class-example")));
        s.selectByValue(option);
        driver.findElement(By.xpath("//input[@id = 'name']")).sendKeys(option);
        driver.findElement(By.cssSelector("input[id='alertbtn'")).click();
        System.out.println(driver.switchTo().alert().getText().contains(option));


    }
}
