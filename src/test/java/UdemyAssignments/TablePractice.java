package UdemyAssignments;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class TablePractice {

    public static void main(String[] args) throws IOException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://qaclickacademy.com/practice.php");
        List<WebElement> values = driver.findElements(By.xpath("//table[@id='product']/tbody/tr/td[3]"));
        int sum = 0;
        for (WebElement w:values) {
           sum +=Integer.parseInt( w.getText());
        }
        System.out.println(sum);
        File src=	 ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src,new File("C:\\Users\\rusly\\Desktop\\CYBERTEK\\screenshotExampleSelenium.png"));

    }
}
