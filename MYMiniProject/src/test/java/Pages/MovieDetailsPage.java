package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MovieDetailsPage {
    @FindBy(linkText = "Home")
    WebElement homelink;
    @FindBy(xpath = "/html/body/div/div/div[2]/div[1]/div/div/div/div/div[1]/div/a/div/img")
    WebElement homeimahge;
    @FindBy(className = "title-details-container")
    WebElement detailscontainer;
    @FindBy(className = "movie-title")
    WebElement movieheading;
    @FindBy(className = "movie-overview")
    WebElement moviedescription;
    @FindBy(className = "similar-movies-container")
    WebElement bottomcontainer;
    @FindBy(className = "footer-icons-container")
    WebElement footercontainer;
    @FindBy(className = "contact-us-paragraph")
    WebElement contactparagraph;
    @FindBy(linkText = "Popular")
    WebElement popularLink;
    @FindBy(xpath = "/html/body/div/div/div[1]/li[1]/a/img")
    WebElement popularimage;
    WebDriver driver;
    public WebDriverWait wait;
    public MovieDetailsPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));

    }
    public WebElement Hometext(){
        return homelink;
    }
    public WebElement imagelink(){
        return  homeimahge;
    }
    public WebElement  detailscontain(){
        return  detailscontainer;
    }
    public WebElement movieheadi(){
        return movieheading;
    }
    public WebElement moviedescrip(){
        return  moviedescription;
    }
    public WebElement bottomcontain(){
        return bottomcontainer;
    }
    public  WebElement footercontain(){
        return footercontainer;
    }
    public WebElement contactparag(){
        return contactparagraph;
    }
    public  WebElement popularli(){
        return  popularLink;
    }
    public  WebElement imageuh(){
        return popularimage;
    }
}




