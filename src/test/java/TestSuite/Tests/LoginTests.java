package TestSuite.Tests;

import DriverFactory.DriverManager;
import DriverFactory.DriverManagerFactory;
import DriverFactory.DriverType;
import TestSuite.Model.User;
import TestSuite.Model.UserBuilder;
import TestSuite.PageObjects.HomePage;
import TestSuite.PageObjects.LoginPage;
import TestSuite.PageObjects.SecureAreaPage;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    private WebDriver driver;
    private DriverManager driverManager;
    protected HomePage hp;
    protected LoginPage lp;

    @BeforeTest
    public void beforeTest() {
        driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
    }

    @BeforeMethod
    public void SetUp()
    {
        driver = getDriver();
        driver.get("https://the-internet.herokuapp.com");

        hp = new HomePage(driver);
        lp = hp.WhenBasicAuthLnkClicked();
    }

    @Test
    @Description("Login with valid user")
    @Issue("JIRA-1234")
    @Story("Some Story id")
    @Severity(SeverityLevel.NORMAL)
    public void LoginWithValidUser()
    {
        User user = new UserBuilder()
                .username("tomsmith")
                .password("SuperSecretPassword!")
                .build();

        SecureAreaPage sap = lp.WhenLoginWith(user);
    }

    @Test
    @Description("Login with invalid username")
    public void LoginWithInvalidUsername()
    {
        User user = new UserBuilder()
                .username("")
                .password("")
                .build();

        lp.WhenLoginValidationWith(user, LoginPage.invalidUsernameValidation);
    }

    @Test
    @Description("Login with invalid pasword")
    public void LoginWithInvalidPassword()
    {
        User user = new UserBuilder()
                .username("tomsmith")
                .password("")
                .build();

        lp.WhenLoginValidationWith(user, LoginPage.invalidPasswordValidation);
    }
}
