package recap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

public class AmazonMenu extends TestBase {

    @Test
    public void amazonTitle() throws InterruptedException {
        driver.get("http://amazon.com");
        Actions action = new Actions(driver);
        WebElement nav = driver.findElement(By.id("icp-nav-flyout"));
        action.moveToElement(nav).perform();
        Thread.sleep(10000);

    }

    @Test
    public void doubleClick() throws InterruptedException {
        driver.get("https://www.primefaces.org/showcase/ui/misc/effect.xhtml");
        Actions action = new Actions(driver);
        action.doubleClick(driver.findElement(By.id("puff_content"))).perform();
        action.moveToElement(driver.findElement(By.className("footer-info-left"))).perform();
        Thread.sleep(5000);
    }

    @Test
    public void dragAndDrop() throws InterruptedException {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        Actions action = new Actions(driver);
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droptarget"));
        action.dragAndDrop(source, target).perform();
        Thread.sleep(3000);
    }

    @Test
    public void upload() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/upload");
        driver.findElement(By.id("file-upload")).sendKeys("C:\\Users\\rusly\\Desktop\\=======MOTTO OF THE MONTH========.txt");
        driver.findElement(By.id("file-submit")).click();
        Thread.sleep(5000);

    }
}
