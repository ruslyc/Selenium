package mentoring;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Selenium {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

                //ASSIGNMENT 1//

        driver.get("http://automationpractice.com/index.php");
        int framesNum = driver.findElements(By.tagName("iframe")).size();
        Thread.sleep(9000);
        for(int i = 0; i <framesNum; i++) {
            driver.switchTo().frame(i);
            int count = driver.findElements(By.linkText("Like Page")).size();
            if (count > 0) {
                System.out.println(i);
            } else {
                System.out.println("continue looping");
                driver.switchTo().defaultContent();

            }
        }
                //ASSIGNMENT 2//

        driver.get("http://qaclickacademy.com/practice.php");
        List<WebElement> values = driver.findElements(By.xpath("//table[@id='product']/tbody/tr/td[3]"));
        int sum = 0;
        for (WebElement w:values) {
            sum +=Integer.parseInt( w.getText());
        }
        System.out.println(sum);

                //ASSIGNMENT 3//

        driver.get("http://qaclickacademy.com/practice.php");
        List <WebElement> links = driver.findElements(By.xpath("//a"));
        driver.get(links.get(links.size()-1).getAttribute("href"));
        String title = driver.getTitle();
        String[]titleArr = title.split(" ");
        String output = "";
        for (String s: titleArr) {
            output+=s.charAt(0);
        }
        System.out.println(output);
        driver.quit();
    }
}
