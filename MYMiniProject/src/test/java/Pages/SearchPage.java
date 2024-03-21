package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchPage {
    public WebDriver driver;
    public WebDriverWait wait;
    @FindBy(id = "search")
    WebElement searchlocarot;
    @FindBy(xpath = "//button[@class='search-button']/child::*")
    WebElement serachiconslocator;

    public SearchPage(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));

    }
    public WebElement searchel(){
        return searchlocarot;
    }
    public WebElement searchiconLocat(){
        return  serachiconslocator;
    }
    public void searching(String movieName){
        WebElement serachinputel=searchel();
        serachinputel.sendKeys(movieName);
        WebElement serachiconel=searchiconLocat();
        serachiconel.click();
    }

}




