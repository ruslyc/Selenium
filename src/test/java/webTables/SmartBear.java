package webTables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.sql.SQLOutput;

public class SmartBear extends TestBase {

    @Test
            public void checkTable() throws InterruptedException {
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/ \n" +
                "login.aspx");
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
        driver.findElement(By.id("ctl00_MainContent_login_button")).click();
//        WebElement table = driver.findElement(By.id("ctl00_MainContent_orderGrid"));
//        int rowSize = table.findElements(By.tagName("tr")).size();
//        System.out.println(rowSize);
//        for (WebElement w:table.findElements(By.tagName("tr"))){
//            for(WebElement c :w.findElements(By.tagName("td")) ){
//                System.out.print(c.getText() + " | ");
//            }
//            System.out.println();
//            System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
//
//        }
        printCoordinatesValue(4,5);
        Thread.sleep(5000);
    }
    public void printCoordinatesValue(int rowNum, int colNum){
        String xpath = "//table[@id = 'ctl00_MainContent_orderGrid']//tr["+rowNum+"]/td["+colNum+"]";
        System.out.println(driver.findElement(By.xpath(xpath)).getText());
    }
}
