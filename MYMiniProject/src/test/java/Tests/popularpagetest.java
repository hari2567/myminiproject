package Tests;

import Pages.HeadersectionPage;
import Pages.Homepage;
import Pages.LoginPage;
import Pages.PopularPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class popularpagetest {
    public WebDriver driver;
    LoginPage loginPage;
    Homepage homePage;
    HeadersectionPage headerSection;
    PopularPage popularPage;
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

    }

    @Test(priority = 1)
    public void popularsearch(){
        loginPage.loginToApplication("rahul","rahul@2021");
        loginPage.submitLink2();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        popularPage.popularnavi().click();
        String expectedurlp="https://qamoviesapp.ccbp.tech/popular";
        Assert.assertEquals(expectedurlp,driver.getCurrentUrl(),"not displayed");
    }
    @Test(priority = 2)
    public void moviessearch(){
        loginPage.loginToApplication("rahul","rahul@2021");
        loginPage.submitLink2();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        List<WebElement> popularmovies=popularPage.getPpopularmovieslocator();
        for(WebElement movie:popularmovies){
            Assert.assertTrue(movie.isDisplayed(),"some movies are not displayed");
        }


    }
    @AfterMethod
    public void teardown(){
        driver.quit();

    }
}






