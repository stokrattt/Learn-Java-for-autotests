package influential.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public SignUpPage (WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    @FindBy (css = "[href=\"/signup/talent#form-anchor\"]")
    private WebElement formAnchor;
    By formLocator = By.cssSelector("form");

    @FindBy (id = "name-first")
    private WebElement nameFirst;

    @FindBy(id = "name-last")
    private WebElement nameLast;

    @FindBy(id = "email")
    private WebElement emailAdress;

    @FindBy(id = "company-name")
    private WebElement companyName;

    @FindBy(id = "username")
    private WebElement userName;

    @FindBy(id = "password")
    private WebElement passUser;

    @FindBy(id = "password-confirm")
    private WebElement passConfirm;

    @FindBy(css = "[type=\"submit\"]")
    private WebElement submit;

    private By signUpComplete = By.id("signup-complete");
    private By errorMsgLocator = By.cssSelector("[class=\"error error-msg\"]");

    public void openSignUpForm(){
        formAnchor.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(formLocator));
    }
    public void fillFirstName(String firstName){
        nameFirst.sendKeys(firstName);
    }
    public void fillLastName (String lastName){
        nameLast.sendKeys(lastName);
    }
    public void fillEmail (String email){
        emailAdress.sendKeys(email);
    }
    public void fillCompanyName (String nameOfCompany){
        companyName.sendKeys(nameOfCompany);
    }
    public void fillUserName(String nameUser){
        userName.sendKeys(nameUser);
    }
    public void fillPassword (String pass){
        passUser.sendKeys(pass);
    }
    public void fillPassConfirm(String sendPassConfirm){
        passConfirm.sendKeys(sendPassConfirm);
    }
    public void submitForm(){
        submit.click();
    }
    public void checkSignUpSucces (){
        wait.until(ExpectedConditions.visibilityOfElementLocated(signUpComplete));
    }

    // Errors

    public void checkErrorRequiredFields(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(errorMsgLocator));
    }
    public String getErrorFirstName (){
        WebElement nameFirstParent = nameFirst.findElement(By.xpath(".."));
        return nameFirstParent.findElement(By.cssSelector("p")).getText();
    }
    public String getErrorLastName(){
        WebElement nameLastParent = nameLast.findElement(By.xpath(".."));
        return nameLastParent.findElement(By.cssSelector("p")).getText();
    }
    public String getEmailError (){
        WebElement emailParent = emailAdress.findElement(By.xpath(".."));
        return emailParent.findElement(By.cssSelector("p")).getText();
    }
    public String getCompanyError(){
        WebElement companyNameParent = companyName.findElement(By.xpath(".."));
        return companyNameParent.findElement(By.cssSelector("p")).getText();
    }
    public String getUserNameError(){
        WebElement userNameParent = userName.findElement(By.xpath(".."));
        return userNameParent.findElement(By.cssSelector("p")).getText();
    }
    public String getPassError(){
        WebElement passwordParent = passUser.findElement(By.xpath(".."));
        return passwordParent.findElement(By.cssSelector("p")).getText();
    }
    public String getPassConfirmError (){
        WebElement passwordConfirmParent = passConfirm.findElement(By.xpath(".."));
        return passwordConfirmParent.findElement(By.cssSelector("p")).getText();
    }

}
