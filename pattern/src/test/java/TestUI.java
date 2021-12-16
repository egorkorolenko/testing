import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestUI {
    private WebDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
        driver = new FirefoxDriver();
    }

    @After
    public void setDown(){
        driver.quit();
    }

    @Test
    public void test(){
        PageObjectTest pageObjectTest = PageFactory.initElements(driver,PageObjectTest.class);
        pageObjectTest.open();
        pageObjectTest.clickShowAnswer();

        assertTrue(pageObjectTest.linkAnswerExist());
        assertTrue(pageObjectTest.hideAnswerExist());
    }
}
