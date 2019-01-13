package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHomePage {

    WebDriver driver;

    public OrangeHomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "welcome")
    public WebElement welcomeAdmin;

    @FindBy(xpath = "//a[.='Logout']")
    public WebElement logoutLink;

    @FindBy(id = "aboutDisplayLink")
    public WebElement aboutLink;

    @FindBy(id = "companyInfo")
    public WebElement aboutPopUp;

    @FindBy(id = "menu__Performance")
    public WebElement performance;

    @FindBy(id = "menu_performance_Configure")
    public WebElement configure;

    @FindBy(id = "menu_performance_searchKpi")
    public WebElement KPIs;

    @FindBy(id = "kpi360SearchForm_jobTitleCode")
    public WebElement jobSelectDropDown;

}
