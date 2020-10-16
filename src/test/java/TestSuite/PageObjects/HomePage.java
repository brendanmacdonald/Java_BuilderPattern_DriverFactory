package TestSuite.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Page {

    @FindBy(linkText = "Form Authentication")
    @CacheLookup
    public WebElement formAuthenticationLnk;

    public HomePage(WebDriver driver)
    {
        super(driver, PageHeading.HOME_PAGE);
    }

    public LoginPage WhenBasicAuthLnkClicked()
    {
        waitAndClick(formAuthenticationLnk);
        return new LoginPage(driver);
    }
}
