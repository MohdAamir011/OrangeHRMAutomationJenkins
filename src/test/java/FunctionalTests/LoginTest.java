package FunctionalTests;
import PageObjects.Login;
import base.Base;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;

public class LoginTest extends Base
{
    WebDriver driver;

    @Test
    public void LoginToApp () throws IOException {
        driver=launchDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        Login l1 = new Login(driver);
        System.out.println("Running test cases");
        HashMap<String,String> data =l1.getLogInCred();
        l1.fillLoginForm(data);
        Assert.assertEquals(driver.getTitle(),"OrangeHRM");
    }
    @AfterMethod
    public void closeDriver() throws InterruptedException {
        driver.close();
    }
}
