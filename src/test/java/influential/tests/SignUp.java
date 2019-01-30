package influential.tests;

import influential.WebDriverSettings;
import influential.pageObject.HomePage;
import influential.pageObject.SignUpPage;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class SignUp extends WebDriverSettings {

   @Test
    public void SignUp(){

        HomePage homePage = PageFactory.initElements(driver, HomePage.class);

        homePage.open();
        homePage.getStarted();

        SignUpPage signUpPage = PageFactory.initElements(driver, SignUpPage.class);

        signUpPage.openSignUpForm();

        Random random = new Random();
        int n = random.nextInt(100) + 1;
        String email = "igor" + n + "@mail.ru";
        String username = "igorpetrov" + n;

        signUpPage.fillFirstName("igor");
        signUpPage.fillLastName("petrov");
        signUpPage.fillEmail(email);
        signUpPage.fillCompanyName("house TV");
        signUpPage.fillUserName(username);
        signUpPage.fillPassword("123qwerty");
        signUpPage.fillPassConfirm("123qwerty");
        signUpPage.submitForm();
        signUpPage.checkSignUpSucces();

    }
    @Test
    @Story("Проверка на фейл регистрации")
    public void SignUpFailure() {

        HomePage homePage = PageFactory.initElements(driver, HomePage.class);

        homePage.open();
        homePage.getStarted();

        SignUpPage signUpPage = PageFactory.initElements(driver, SignUpPage.class);

        signUpPage.openSignUpForm();
        signUpPage.submitForm();
        signUpPage.checkErrorRequiredFields();

        String nameFirstError = signUpPage.getErrorFirstName();
        Assert.assertEquals(nameFirstError, "PLEASE ADD A FIRST NAME");

        String nameLastError = signUpPage.getErrorLastName();
        Assert.assertEquals(nameLastError, "PLEASE ADD A LAST NAME");

        String emailError = signUpPage.getEmailError();
        Assert.assertEquals(emailError, "PLEASE ADD AN EMAIL ADDRESS");

        String companyError = signUpPage.getCompanyError();
        Assert.assertEquals(companyError, "PLEASE ADD A COMPANY NAME1");

        String userNameError = signUpPage.getUserNameError();
        Assert.assertEquals(userNameError, "PLEASE ADD A USERNAME");

        String passError = signUpPage.getPassError();
        Assert.assertEquals(passError, "PLEASE ADD A PASSWORD");

        String passConfError = signUpPage.getPassConfirmError();
        Assert.assertEquals(passConfError, "PLEASE CONFIRM YOUR PASSWORD");

    }
}
