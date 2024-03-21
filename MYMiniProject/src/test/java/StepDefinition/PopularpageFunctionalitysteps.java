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
import java.util.List;

public class PopularpageFunctionalitysteps {
    public WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\OneDrive\\Desktop\\chromedriver-win64\\chromedriver-win64//chromedriver.exe");
        driver = new ChromeDriver();
    }
    @Given("I click login page")
    public void iclickloginpage(){
        driver.get("https://qamoviesapp.ccbp.tech");

    }
    @When("I click  username and password")
    public void iclickusernameandpassword(){
        driver.findElement(By.id("usernameInput")).sendKeys("rahul");
        driver.findElement(By.id("passwordInput")).sendKeys("rahul@2021");
    }
    @And("I click the    login buttons")
    public void iclicktheloginbuttons(){
        driver.findElement(By.className("login-button")).click();

    }
    @Then("I should enter into popular page")
    public void ishouldenterintopopularpage(){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement popularpagelink=wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Popular")));
        popularpagelink.click();
        String expectedurlp="https://qamoviesapp.ccbp.tech/popular";
        Assert.assertEquals(expectedurlp,driver.getCurrentUrl(),"not displayed");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        List<WebElement>popularapageList=driver.findElements(By.className("movie-icon-item"));
        Assert.assertEquals(popularapageList.size(),30,"not all movies are present in popular movies section ");

    }
    @After
    public void tearDown(){
        driver.quit();
    }
}
