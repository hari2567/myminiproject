package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Homepage {
    @FindBy(xpath = "//a[text()='Home']")
    WebElement homeheading;
    @FindBy(xpath = "//a[text()='Popular']")
    WebElement popularheading;
    @FindBy(xpath = "//div[@class='footer-icons-container']/child::*")
    List<WebElement> contacticons;

    @FindBy (className = "home-movie-play-button")
    WebElement layButton;
    @FindBy(className = "contact-us-paragraph")
    WebElement paragraph;
    @FindBy (className = "home-movie-description")
    WebElement homemoviedesc;
    @FindBy(className = "home-movie-heading")
    WebElement homemoviehead;
    @FindBy(xpath = "//h1[@class='movie-list-heading']")
    List<WebElement> headingtextLocator;
    @FindBy(xpath = "//div[@class='react-slick-item']")
    List<WebElement> movieslocator;
    @FindBy(className = "avatar-img")
    WebElement avatarimage;
    @FindBy(xpath = "//button[@class='search-empty-button']/child::*")
    WebElement searchlocator;






    WebDriver driver;
    WebDriverWait wait;
    public Homepage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    public  WebElement button(){
        return  layButton;
    }
    public WebElement paragraphcontext(){
        return  paragraph;
    }
    public WebElement homeText(){
        return homeheading;
    }
    public WebElement popularText(){
        return popularheading;
    }
    public WebElement homemoviedescri(){
        return  homemoviedesc;
    }
    public WebElement homemovieh(){
        return homemoviehead;
    }
    public  List<WebElement> getHeadingtextLocator(){
        return    headingtextLocator;
    }
    public List< WebElement> getMovieslocator(){
        return  movieslocator;
    }
    public WebElement getAvatarimage(){
        return  avatarimage;
    }
    public WebElement getSearchlocator(){
        return searchlocator;
    }
    public List<WebElement> getcontact(){
        return contacticons;
    }
}




