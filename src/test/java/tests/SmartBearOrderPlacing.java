package tests;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SmartBearOrderPlacing {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/ \n" +
                "login.aspx");
        driver.manage().window().maximize();
        String title1 = driver.getTitle();
        if(title1.equals("Web Orders Login")){
            System.out.println("Title1 passed");
        }else{
            System.out.println("Title1 test failed");
        }
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
        driver.findElement(By.id("ctl00_MainContent_login_button")).click();
        driver.findElement(By.xpath("//a[.='Order']")).click();
        WebElement products = driver.findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct"));
        Select product = new Select(products);
        product.selectByIndex(1);
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity")).sendKeys("2");
        Faker faker = new Faker();
        String name = faker.name().fullName();
        String street = faker.address().streetAddress();
        String city = faker.address().cityName();
        String state = faker.address().state();
        String zip = faker.address().zipCode().substring(0,5);
        String cardNumber = faker.number().numberBetween(10000000,99999999)+""+faker.number().numberBetween(10000000,99999999);
        int m = faker.number().numberBetween(0,12);
        String month = m<10? String.format("%02d", m):m+"";
        String expiration = month + "/" + faker.number().numberBetween(19,25);
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName")).sendKeys(name);
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2")).sendKeys(street);
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3")).sendKeys(city);
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4")).sendKeys(state);
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5")).sendKeys(zip);
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_0")).click();
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys(cardNumber);
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1")).sendKeys(expiration);
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton")).click();
        String message = driver.findElement(By.xpath("//strong")).getText();
        if(message.equals("New order has been successfully added.")){
            System.out.println("Order placement was successful");
        }else{
            System.out.println("Order placement failed");
        }







    }
}
