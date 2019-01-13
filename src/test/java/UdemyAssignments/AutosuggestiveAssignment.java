package UdemyAssignments;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutosuggestiveAssignment {
    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://qaclickacademy.com/practice.php");
        driver.findElement(By.id("autocomplete")).sendKeys("rom");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String script = "return document.getElementById(\"autocomplete\").value;";
        String text =(String) js.executeScript(script);

        while(!text.equalsIgnoreCase("Romania")){
            driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
            text =(String) js.executeScript(script);
        }
        System.out.println(text);


    }

}
