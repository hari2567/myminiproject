package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HeadersectionPage {
    @FindBy(xpath = "//a[text()='Home']")
    WebElement hompeLink;
    @FindBy(xpath = "//a[text()='Popular']")
    WebElement popularLink;
    @FindBy(className = "website-logo")
    WebElement logolink;
    @FindBy(className = "avatar-button")
    WebElement avatarLink;
    WebDriver driver;
    WebDriverWait wait;
    public HeadersectionPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public  WebElement homeNavigation(){
        return hompeLink;
    }
    public  WebElement popularNavigation(){
        return popularLink;
    }
    public  WebElement logoNavigation(){
        return  logolink;
    }
    public  WebElement avatarNaviagtion(){
        return  avatarLink;
    }
}




