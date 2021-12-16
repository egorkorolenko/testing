import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageObjectTest {
    protected WebDriver driver;
    protected WebDriverWait webDriverWait;

    @FindBy(id = "show_answ")
    private WebElement showAnsw;

    @FindBy(linkText = "Ссылка на ответы")
    private WebElement linkAnswer;

    @FindBy(id = "hide_answ")
    private WebElement hideAnsw;

    public PageObjectTest(WebDriver webDriver){
        PageFactory.initElements(webDriver,this);
        this.driver = webDriver;
        this.webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickShowAnswer(){
        showAnsw.click();
    }

    public boolean linkAnswerExist(){
        return linkAnswer.isDisplayed();
    }


    public boolean hideAnswerExist(){
        return hideAnsw.isDisplayed();
    }

    public void open(){
        driver.get("https://playground.learnqa.ru/puzzle/triangle");
    }
}
