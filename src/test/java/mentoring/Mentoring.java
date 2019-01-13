package mentoring;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class Mentoring {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.qaclickacademy.com/practice.php");
        driver.manage().window().maximize();
        List <WebElement> links = driver.findElements(By.xpath("//a")); // store all the links on the page
        driver.get(links.get(25).getAttribute("href"));            // will navigate to the link at index 25(last link)
        String title = (driver.getTitle());                             // gets the title of the page
        String[] arr = title.split(" ");
        title = "";
        for(int i = 0; i<arr.length; i++){                             // get every second word of the title
           if(i%2!=0){
               title+=(arr[i]+" ");
           }
        }
        int length = title.length();                                //store the length of the title

        driver.get("https://phptravels.com/");
        driver.manage().window().maximize();
        Thread.sleep(5000);
       // driver.findElement(By.xpath("//*[.='Contact Us']")).click();
        driver.findElement(By.id("onesignal-popover-cancel-button")).click();
        WebElement close = driver.findElement(By.xpath("//div[@class = 'mc-closeModal']"));
       // browser.executeScript("arguments[0].click()",close);
        Actions a = new Actions(driver);
        a.moveToElement(driver.findElement(By.xpath("//*[.='Company']"))).build().perform();
        driver.findElement(By.xpath("//*[.='Contact Us']")).click();
        String text = driver.findElement(By.xpath("//p[@class='wow fadeIn cw animated']")).getText();
        String [] arr1 = text.split(" ");
        String pass = "";
        for (String s:arr1) {
            pass+=s.charAt(0);
        }
        pass = pass + length;
        System.out.println(pass);

        }











    }

