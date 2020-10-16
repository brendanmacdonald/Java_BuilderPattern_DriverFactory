package TestSuite.PageObjects;

import TestSuite.Model.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Page {

    //private WebDriver driver;
    public static String invalidUsernameValidation = "Your username is invalid!";
    public static String invalidPasswordValidation = "Your password is invalid!";

    public LoginPage(WebDriver driver) {
        super(driver, PageHeading.LOGIN_PAGE);
    }

    @FindBy(id = "username")
    @CacheLookup
    private WebElement usernameTxt;

    @FindBy(id = "password")
    @CacheLookup
    private WebElement passwordTxt;

    @FindBy(className = "radius")
    @CacheLookup
    private WebElement loginBtn;

    public SecureAreaPage WhenLoginWith(User user)
    {
        usernameTxt.sendKeys(user.username);
        passwordTxt.sendKeys(user.password);
        loginBtn.click();
        return new SecureAreaPage(driver);
    }

    public void WhenLoginValidationWith(User user, String validation)
    {
        usernameTxt.sendKeys(user.username);
        passwordTxt.sendKeys(user.password);
        loginBtn.click();
        thenVerifyValidationMsg(validation);
    }
}
