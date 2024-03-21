package Tests;

import Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class accountpagetest {
    public WebDriver driver;

    LoginPage loginPage;
    Homepage homePage;
    HeadersectionPage headerSection;
    PopularPage popularPage;
    SearchPage searchPage;
    MovieDetailsPage movieDetails;
    AcoountPage accountPage;
    @BeforeMethod
    @Test
    public void setup() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\OneDrive\\Desktop\\chromedriver-win64\\chromedriver-win64//chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");



        loginPage = new LoginPage(driver);
        homePage = new Homepage(driver);
        headerSection=new HeadersectionPage(driver);
        popularPage=new PopularPage(driver);
        searchPage=new SearchPage(driver);
        movieDetails=new MovieDetailsPage(driver);
        accountPage=new AcoountPage(driver);

    }
    @AfterMethod
    public void teardown(){
        driver.quit();

    }
    @Test(priority = 1)
    public  void testaccount(){
        loginPage.loginToApplication("rahul","rahul@2021");
        loginPage.submitLink2();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        accountPage.avatarli().click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        accountPage.wait.until(ExpectedConditions.visibilityOf(accountPage.accounthead()));
        Assert.assertEquals(accountPage.accounthead().getText(),"Account","heading is not matched");
        accountPage.wait.until(ExpectedConditions.visibilityOf(accountPage.members()));
        Assert.assertEquals(accountPage.members().getText(),"User name : rahul","membership not matched");
        accountPage.wait.until(ExpectedConditions.visibilityOf(accountPage.plancontai()));
        Assert.assertEquals(accountPage.plancontai().getText(),"Premium","plan details not matched");
        accountPage.wait.until(ExpectedConditions.elementToBeClickable(accountPage.logoutele()));
        Assert.assertTrue(accountPage.logoutele().isDisplayed(),"logout is not displayed");
    }
    @Test(priority = 2)
    public void logoutFunctionality(){
        loginPage.loginToApplication("rahul","rahul@2021");
        loginPage.submitLink2();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        accountPage.avatarli().click();
        WebElement logoutbtn=accountPage.logoutele();
        logoutbtn.click();
        String expurl="https://qamoviesapp.ccbp.tech/login";
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expurl));
        Assert.assertEquals(driver.getCurrentUrl(),expurl,"not matching");
    }

}





