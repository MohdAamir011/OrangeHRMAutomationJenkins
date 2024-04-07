package FunctionalTests;

import PageObjects.AdminManage;
import PageObjects.Login;
import base.Base;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;

public class AdminManageTest extends Base {
    WebDriver driver;
    @BeforeMethod
    public void Login() throws IOException, IOException {
        driver=launchDriver();
        Login l1 =new Login(driver);
        driver.get("https://opensource-demo.orangehrmlive.com/");
        HashMap<String,String> data =l1.getLogInCred();
        l1.fillLoginForm(data);
    }

    @Test
    public void manageAdminUser() throws IOException, InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/");
        AdminManage a1 = new AdminManage(driver);
        Thread.sleep(3000);
        String t2= a1.goToAdminPage();
        Assert.assertEquals(t2,"Admin");
        Thread.sleep(3000);
        String empName="ankit patel";
        String userName="ankit patel";
        a1.addSystemUser(empName,userName,"john@123");
        Thread.sleep(5000);
        a1.searchSystemUser(userName,empName);
//        a1.deleteSystemUser();
    }
    @AfterMethod
    public void closeDriver() throws InterruptedException {
        driver.close();
    }
}
