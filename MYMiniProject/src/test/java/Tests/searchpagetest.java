package Tests;

import Pages.*;
import org.openqa.selenium.By;
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

public class searchpagetest {
    public WebDriver driver;
    LoginPage loginPage;
     Homepage homePage;
    HeadersectionPage headerSection;
    PopularPage popularPage;
    SearchPage searchPage;

    @BeforeMethod
    @Test
    public void setup() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\OneDrive\\Desktop\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");


        loginPage = new LoginPage(driver);
        homePage = new Homepage(driver);
        headerSection = new HeadersectionPage(driver);
        popularPage = new PopularPage(driver);
        searchPage = new SearchPage(driver);

    }

    @AfterMethod
    public void teardown() {
        driver.quit();

    }

    @Test(priority = 1)
    public void testsearch() {
        loginPage.loginToApplication("rahul", "rahul@2021");
        loginPage.submitLink2();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String expectedurl="https://qamoviesapp.ccbp.tech/";
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expectedurl));
        Assert.assertEquals(driver.getCurrentUrl(),expectedurl,"not same");
        WebElement searchpage2=driver.findElement(By.className("search-empty-button"));
        searchpage2.click();
        String expur2="https://qamoviesapp.ccbp.tech/search";
        WebDriverWait wait2=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait2.until(ExpectedConditions.urlToBe(expur2));
        Assert.assertEquals(driver.getCurrentUrl(),expur2,"not display");
        searchPage.searchel().sendKeys("Titanic");
        WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='link-item']")));
        WebElement movieimgel = driver.findElement(By.xpath("//a[@class='link-item']"));
        Assert.assertTrue(movieimgel.isDisplayed(),"specific movie is not displaying.");
    }
}




