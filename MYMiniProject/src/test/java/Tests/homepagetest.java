package Tests;

import Pages.Homepage;
import Pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class homepagetest {
    public WebDriver driver;
    LoginPage loginPage;
    Homepage homePage;
    @Before
    public void setup() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\OneDrive\\Desktop\\chromedriver-win64\\chromedriver-win64//chromedriver.exe");
        driver = new ChromeDriver();
    }
    @Test(priority = 1)
    public void iamonthehomepage(){
        driver.get("https://qamoviesapp.ccbp.tech");
        loginPage = new LoginPage(driver);
        homePage = new Homepage(driver);

    }
    @Test(priority = 2)
    public void ienterusernameandpassword(){
        loginPage.loginToApplication("rahul","rahul@2021");
        loginPage.submitLink2();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String expectedtitle="React App";
        Assert.assertEquals(expectedtitle,driver.getTitle());
    }
    @Test(priority = 3)
    public void icheckwhwtherhometextisdisplayed(){
        loginPage.loginToApplication("rahul","rahul@2021");
        loginPage.submitLink2();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Assert.assertEquals("Home",homePage.homeText().getText());
    }

    @Test(priority = 4)
    public void iverifyhomemovieheadinganddescription(){
        loginPage.loginToApplication("rahul","rahul@2021");
        loginPage.submitLink2();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement homemoviehead=homePage.homemovieh();
        System.out.println(homemoviehead.getText());
        WebElement moviedescription=homePage.homemoviedescri();
        System.out.println(moviedescription.getText());

    }
    @Test(priority = 5)
    public void  iverifywhetherplaybuttonisdisplayed(){
        loginPage.loginToApplication("rahul","rahul@2021");
        loginPage.submitLink2();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Assert.assertTrue(homePage.button().isDisplayed(),"play button is not dis");
    }
    @Test(priority = 6)
    public void icheckwhethertextismatched(){
        loginPage.loginToApplication("rahul","rahul@2021");
        loginPage.submitLink2();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        List<WebElement> headingtext=homePage.getHeadingtextLocator();
        String expected="Trending Now";
        Assert.assertEquals( headingtext.get(0).getText(),expected,"firstsection is not matched");
        String expected2="Originals";
        Assert.assertEquals(headingtext.get(1).getText(),expected2,"secondsection not matched");


    }
    @Test(priority = 7)
    public void iverifymoviessection(){
        loginPage.loginToApplication("rahul","rahul@2021");
        loginPage.submitLink2();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String expectedurl="https://qamoviesapp.ccbp.tech/";
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expectedurl));
        String actualurl=driver.getCurrentUrl();
        Assert.assertEquals(expectedurl,actualurl,"not displayed");
        homePage.homeText().click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        List<WebElement>movieslist=homePage.getMovieslocator();
        Assert.assertEquals(movieslist.size(),20,"movies coint is not matching");

    }
    @Test(priority = 8)
    public void  iverifycontacticon(){
        loginPage.loginToApplication("rahul","rahul@2021");
        loginPage.submitLink2();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        List<WebElement>cotacticon=homePage.getcontact();
        Assert.assertEquals(cotacticon.size(),4,"contacticoncount is not matching");
    }


    @Test(priority = 9)
    public void iverifycontactsection(){
        loginPage.loginToApplication("rahul","rahul@2021");
        loginPage.submitLink2();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Assert.assertEquals("Contact Us",homePage.paragraphcontext().getText());
    }
    @After
    public void closethewindow() {
        driver.quit();
    }



}


