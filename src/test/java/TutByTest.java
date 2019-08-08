import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TutByTest {

    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "C:/Program Files/Git/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://www.tut.by");
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
    }

    @Test
    public void tutByTest() {
        loginPage.buttonMail();
        loginPage.login("truhanzhenya", "1230551truhanZhenya");
        loginPage.isElementPresent();
        Assert.assertTrue(loginPage.countMessage() > 0);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}