package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PopularPage {
    WebDriver driver;
    WebDriverWait wait;
    @FindBy(xpath = "//a[text()='Popular']")
    WebElement popularLink;
    @FindBy (xpath = "//li[@class='movie-icon-item']")
    List<WebElement> ppopularmovieslocator;

    public WebElement popularnavi(){
        return  popularLink;
    }

    public PopularPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    public boolean checkpopulaesec() {
        WebElement populaesec = driver.findElement(By.linkText("Popular"));
        populaesec.click();
        WebElement Pppularcontainer= driver.findElement(By.className("search-movies-container"));
        return Pppularcontainer.isDisplayed();
    }
    public List<WebElement>getPpopularmovieslocator(){
        return  ppopularmovieslocator;
    }

}




