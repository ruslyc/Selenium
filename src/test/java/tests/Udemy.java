package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.util.List;

public class Udemy {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://qaclickacademy.com/practice.php");
        WebElement checkBox1 = driver.findElement(By.cssSelector("#checkBoxOption1"));
        checkBox1.click();
        System.out.println(checkBox1.isSelected());
        checkBox1.click();
        System.out.println(checkBox1.isSelected());
        List<WebElement> checkBoxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
        System.out.println(checkBoxes.size());
    }
}
