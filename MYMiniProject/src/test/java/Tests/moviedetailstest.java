package Tests;

import Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class moviedetailstest {
    public WebDriver driver;

    LoginPage loginPage;
    Homepage homePage;
    HeadersectionPage headerSection;
    PopularPage popularPage;
    SearchPage searchPage;
    MovieDetailsPage movieDetails;
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

    }
    @AfterMethod
    public void teardown(){
        driver.quit();

    }
    @Test(priority = 1)
    public void homepahetest(){
        loginPage.loginToApplication("rahul","rahul@2021");
        loginPage.submitLink2();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        movieDetails.Hometext().click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        movieDetails.imagelink().click();
        movieDetails.wait.until(ExpectedConditions.visibilityOf(movieDetails.detailscontain()));
        movieDetails.wait.until(ExpectedConditions.visibilityOf(movieDetails.movieheadi()));
        Assert.assertEquals(movieDetails.movieheadi().getText(),"No Time to Die","not displayed");
        movieDetails.wait.until(ExpectedConditions.visibilityOf(movieDetails.moviedescrip()));
        Assert.assertEquals(movieDetails.moviedescrip().getText(),"Bond has left active service and is enjoying a tranquil life in Jamaica. His peace is short-lived when his old friend Felix Leiter from the CIA turns up asking for help. The mission to rescue a kidnapped scientist turns out to be far more treacherous than expected, leading Bond onto the trail of a mysterious villain armed with dangerous new technology.","not equal");
        movieDetails.wait.until(ExpectedConditions.visibilityOf(movieDetails.footercontain()));
        movieDetails.wait.until(ExpectedConditions.visibilityOf(movieDetails.contactparag()));
        Assert.assertEquals(movieDetails.contactparag().getText(),"Contact Us","not eqaul");
        if(movieDetails.detailscontain().isDisplayed()&&movieDetails.movieheadi().isDisplayed()&&movieDetails.moviedescrip().isDisplayed()&&movieDetails.bottomcontain().isDisplayed()&&movieDetails.footercontain().isDisplayed()&&movieDetails.contactparag().isDisplayed()){
            System.out.println("homepahe movies are displayed");
        }else {
            System.out.println("not displayed");
        }

    }
    @Test(priority = 2)
    public void popularpage(){
        loginPage.loginToApplication("rahul","rahul@2021");
        loginPage.submitLink2();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        movieDetails.popularli().click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        movieDetails.imageuh().click();
        movieDetails.wait.until(ExpectedConditions.visibilityOf(movieDetails.detailscontain()));
        movieDetails.wait.until(ExpectedConditions.visibilityOf(movieDetails.movieheadi()));
        Assert.assertEquals(movieDetails.movieheadi().getText(),"Venom","both are not equal");
        movieDetails.wait.until(ExpectedConditions.visibilityOf(movieDetails.moviedescrip()));
        Assert.assertEquals(movieDetails.moviedescrip().getText(),"nvestigative journalist Eddie Brock attempts a comeback following a scandal, but accidentally becomes the host of Venom, a violent, super powerful alien symbiote.","not eqaul");
        movieDetails.wait.until(ExpectedConditions.visibilityOf(movieDetails.bottomcontain()));
        movieDetails.wait.until(ExpectedConditions.visibilityOf(movieDetails.footercontain()));
        movieDetails.wait.until(ExpectedConditions.visibilityOf(movieDetails.contactparag()));
        Assert.assertEquals(movieDetails.contactparag().getText(),"Contact Us","not displayed");
        if(movieDetails.detailscontain().isDisplayed()&&movieDetails.movieheadi().isDisplayed()&&movieDetails.moviedescrip().isDisplayed()&&movieDetails.bottomcontain().isDisplayed()&&movieDetails.footercontain().isDisplayed()&&movieDetails.contactparag().isDisplayed()){
            System.out.println("populare movies are displayed");
        }else {
            System.out.println("not displayed");
        }

    }
}



