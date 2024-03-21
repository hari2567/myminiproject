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

import java.time.Duration;

public class AccountpageFunctionalitysteps {
    public WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\OneDrive\\Desktop\\chromedriver-win64\\chromedriver-win64//chromedriver.exe");
        driver = new ChromeDriver();
    }
    @Given("I click on login page")
    public void iclickontheloginpage(){
        driver.get("https://qamoviesapp.ccbp.tech");
    }
    @When("I click on username and password")
    public void iclickonusernameandpassword() {
        driver.findElement(By.id("usernameInput")).sendKeys("rahul");
        driver.findElement(By.id("passwordInput")).sendKeys("rahul@2021");
    }
        @And("I click on    login butto")
    public void iclickonlogginbutto(){
            driver.findElement(By.className("login-button")).click();
    }
    @Then("I should enter into the account page")
    public void ishouldenterintotheaccount(){
        WebElement accountlink=driver.findElement(By.className("avatar-button"));
        accountlink.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("account-heading")));


    }
    @After
    public void tearDown(){

    }
}
