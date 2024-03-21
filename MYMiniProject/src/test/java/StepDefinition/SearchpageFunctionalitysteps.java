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

public class SearchpageFunctionalitysteps {
    public WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\OneDrive\\Desktop\\chromedriver-win64\\chromedriver-win64//chromedriver.exe");
        driver = new ChromeDriver();
    }


    @Given("I click to login page")
    public void iclicktologinpage(){
        driver.get("https://qamoviesapp.ccbp.tech");
        driver.findElement(By.id("usernameInput")).sendKeys("rahul");
        driver.findElement(By.id("passwordInput")).sendKeys("rahul@2021");
    }
    @When("I click to username and password")
    public void iclicktousernameandpassword(){
        driver.findElement(By.id("usernameInput")).sendKeys("rahul");
        driver.findElement(By.id("passwordInput")).sendKeys("rahul@2021");

    }
    @And("I click the to   login buttons")
    public void iclicktheloginbutton(){
        driver.findElement(By.className("login-button")).click();
    }
    @Then("I should enter into the search page")
    public void ishouldenterintosearchpage(){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement searchpagelink=wait.until(ExpectedConditions.elementToBeClickable(By.id("search")));
        searchpagelink.click();
        String expur2="https://qamoviesapp.ccbp.tech/search";
        WebDriverWait wait2=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait2.until(ExpectedConditions.urlToBe(expur2));
        Assert.assertEquals(driver.getCurrentUrl(),expur2,"not eqaul");
    }
    @After
    public void tearDown(){
        driver.quit();
    }
}
