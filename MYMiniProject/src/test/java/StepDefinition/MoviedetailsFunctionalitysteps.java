package StepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class MoviedetailsFunctionalitysteps {
    public WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\OneDrive\\Desktop\\chromedriver-win64\\chromedriver-win64//chromedriver.exe");
        driver = new ChromeDriver();
    }
    @Given("I enter  login page")
    public void ienterloginpage(){
        driver.get("https://qamoviesapp.ccbp.tech");

    }
    @When("I enter  username and password")
    public void ienterusernameandpassword(){
        driver.findElement(By.id("usernameInput")).sendKeys("rahul");
        driver.findElement(By.id("passwordInput")).sendKeys("rahul@2021");

    }
    @And("I click   login button")
    public void iclickloginbutton(){
        driver.findElement(By.className("login-button")).click();
    }
    @Then("I should enter   home page")
    public void ishouldenterhomepage(){
        String expectedurl="https://qamoviesapp.ccbp.tech/";
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expectedurl));
        String actualUL= driver.getCurrentUrl();
        Assert.assertEquals(actualUL,expectedurl,"url doesnot match");


    }
    @And("I check homepage  , popular displayed")
    public void icheckhomepagepopularpage(){
        WebElement hometext= driver.findElement(By.xpath("//a[text()='Home']"));
        Assert.assertTrue(hometext.isDisplayed(),"Home");
        WebElement populartext=driver.findElement(By.xpath("//a[text()='Popular']"));
        Assert.assertTrue(populartext.isDisplayed(),"Popular");


    }
    @Then ("I navigate to home and popular pages")
    public void inavigatetohomeandpopularpages(){
        WebElement hometext2= driver.findElement(By.xpath("//a[text()='Home']"));
        hometext2.click();
        WebElement populartext2=driver.findElement(By.xpath("//a[text()='Popular']"));
        populartext2.click();
    }
    @After
     public void tearDown(){
        driver.quit();
    }
}
