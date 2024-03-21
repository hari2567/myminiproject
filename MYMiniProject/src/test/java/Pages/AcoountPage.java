package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AcoountPage {
    @FindBy(className = "avatar-button")
    WebElement avatarlink;
    @FindBy(className = "account-heading")
    WebElement  accountheading;
    @FindBy(className = "membership-username")
    WebElement membership;
    @FindBy(className = "membership-password")
    WebElement getMembership;
    @FindBy(className = "plan-paragraph")
    WebElement plancontainer;
    @FindBy(className ="logout-button")
    WebElement logoutelent;
    @FindBy (xpath = "//p[@class='membership-heading")
    List<WebElement> membershipheading;
    @FindBy (className = "plan-details")
    WebElement plandetailslocator;
    WebDriver driver;
    public WebDriverWait wait;
    public AcoountPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));

    }
    public WebElement avatarli(){
        return avatarlink;
    }
    public WebElement  accounthead(){
        return  accountheading;
    }
    public  WebElement members (){
        return membership ;
    }
    public WebElement plancontai(){
        return plancontainer ;
    }
    public WebElement logoutele(){
        return logoutelent;
    }
    public WebElement memberpassword(){return  getMembership;}
    public WebElement plandetails(){
        return  plandetailslocator;
    }
    public List<WebElement>memberhaed(){
        return membershipheading;
    }
}




