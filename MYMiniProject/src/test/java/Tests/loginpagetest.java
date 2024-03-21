package Tests;

import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class loginpagetest {
    WebDriver driver;
    LoginPage loginPage;

    @BeforeMethod
    public void setup() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\OneDrive\\Desktop\\chromedriver-win64//chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");
        loginPage=new LoginPage(driver);

    }
    @Test(priority = 1)
    public void ImageLogoIsDisplayed(){
        Assert.assertTrue(loginPage.imageelement().isDisplayed(),"not displayed");
        Assert.assertEquals("Login",loginPage.headingelement().getText());
        String usernameText=loginPage.usernamelinkl().getText();
        String expectedtext="USERNAME";
        Assert.assertEquals(usernameText,expectedtext,"username is not matching");
        String passwordText=loginPage.passwordLink().getText();
        String expectedText2="PASSWORD";
        Assert.assertEquals(passwordText,expectedText2,"password is not matching");

        Assert.assertTrue(loginPage.submitLink().isDisplayed(),"not displayed");


    }
    @Test(priority = 2)
    public void pageWithoutlogin(){
        loginPage.submitLink2();
        String actualUrl=loginPage.errorMessage();
        Assert.assertEquals(actualUrl,"*Username or password is invalid","Error text does not match");
    }
    @Test(priority = 3)
    public void PageWithemptyusername(){
        loginPage.loginToApplication("","rahul@2021");
        loginPage.submitLink2();
        String actualUrl=loginPage.errorMessage();
        Assert.assertEquals(actualUrl,"*Username or password is invalid","Error text does not match");

    }
    @Test(priority = 4)
    public void pagewithemptypassword(){
        loginPage.loginToApplication("rahul","");
        loginPage.submitLink2();
        String actualUrl=loginPage.errorMessage();
        Assert.assertEquals(actualUrl,"*Username or password is invalid","Error text does not match");

    }
    @Test(priority = 5)
    public void PageWIthInvalidNames(){
        loginPage.loginToApplication("rahul","rahul");
        loginPage.submitLink2();
        String actualUrl=loginPage.errorMessage();
        Assert.assertEquals(actualUrl,"*username and password didn't match","Error text does not match");


    }
    @Test(priority = 6)
    public void pagewithvalidinputs(){
        loginPage.loginToApplication("rahul","rahul@2021");
        loginPage.submitLink2();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String expectedurl="https://qamoviesapp.ccbp.tech/";
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expectedurl));
        String actualUL= driver.getCurrentUrl();
        Assert.assertEquals(actualUL,expectedurl,"url doesnot match");
    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }






}







