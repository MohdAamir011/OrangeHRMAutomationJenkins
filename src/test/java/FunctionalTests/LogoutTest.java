package FunctionalTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LogoutTest {

    WebDriver driver;
    public LogoutTest(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
}
