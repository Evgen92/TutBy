import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class LoginPage {

    WebDriver driver;

    @FindBy(xpath = "(.//a [@title='Почта'])[1]")
    private WebElement buttonMail;

    @FindBy(xpath = ".//input [@name='login']")
    private WebElement loginField;

    @FindBy(xpath = ".//input [@name='password']")
    private WebElement passwordField;

    @FindBy(xpath = ".//span [@id='recipient-1']")
    private WebElement elementET;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void buttonMail() {
        buttonMail.click();
    }

    public void login(String login, String password) {
        loginField.sendKeys(login);
        passwordField.sendKeys(password);
        passwordField.submit();
    }

    public int countMessage() {
        int count = 0;
        List<WebElement> messages = driver.findElements(By.xpath(".//div [@data-key = 'box=messages-item-box']"));
        count = messages.size();
        return count;
    }

    public boolean isElementPresent() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(elementET));
        return elementET.isDisplayed();
    }
}