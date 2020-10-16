package TestSuite.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Page {
    protected WebDriver driver;
    private WebDriverWait wait;

    public Page(WebDriver driver, PageHeading heading){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 10);

        thenPageIsLoaded(heading);
    }

    @FindBy(css = "h2")
    @CacheLookup
    public WebElement h2;

    @FindBy(id = "flash")
    @CacheLookup
    public WebElement flash;

    public void thenPageIsLoaded(PageHeading heading)
    {
        String actual = h2.getText();
        Assert.assertEquals(heading.getHeading(), actual, String.format("Expected page: %s. Actual page: %s", heading.getHeading(), actual));
    }

    public void thenVerifyValidationMsg(String expected)
    {
        String actual = flash.getText();
        Assert.assertTrue(actual.contains(expected), String.format("Expected validation msg: %s. Actual validation is: %s", expected, actual));
    }

    public void waitAndClick(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }
}
