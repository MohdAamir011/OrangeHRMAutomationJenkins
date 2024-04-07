package FunctionalTests;

import PageObjects.Login;
import PageObjects.PIMManage;
import base.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.HashMap;

public class PIMManageTest extends Base {
    WebDriver driver;

    @BeforeMethod
    public void Login() throws IOException {
        driver=launchDriver();
        Login l1 =new Login(driver);
        driver.get("https://opensource-demo.orangehrmlive.com/");
        HashMap<String,String> data =l1.getLogInCred();
        l1.fillLoginForm(data);
    }
    @Test
    public void manageEmp() throws IOException, InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/");
        PIMManage p1 = new PIMManage(driver);
        Thread.sleep(2000);
        String t=p1.goToPIMPage();
        SoftAssert sf =new SoftAssert();
        sf.assertEquals(t,"PIM3");
//        Assert.assertEquals(t,"PIM3");
        Thread.sleep(5000);
        String EmpId = p1.addEmployee("ankit","patel");
        Thread.sleep(3000);
        p1.goToEmpList();
        Thread.sleep(3000);
        p1.SearchEmp(EmpId);
//        Thread.sleep(3000);
//        p1.deleteEmp(EmpId);

    }
    @AfterMethod
    public void closeDriver() throws InterruptedException {
        driver.close();
    }
}
