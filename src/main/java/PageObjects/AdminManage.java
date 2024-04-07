package PageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class AdminManage {
    WebDriver driver;
    public AdminManage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = "ul.oxd-main-menu>:nth-child(1)")
    WebElement AdminBtn;
    @FindBy(xpath = "//button[normalize-space()='Add']")
    WebElement AddBtn;
    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    WebElement EmpName;
    @FindBy(css = "form > div:nth-child(1) > div > div:nth-child(4) > div>div>input")
    WebElement UserName;

    @FindBy(css ="button[type='submit']")
    WebElement SaveBtn;
    @FindBy(css ="div.oxd-grid-item>div>div>input")
    WebElement UserNameSearch;
    @FindBy(css ="div.oxd-input-field-bottom-space>div>div>div>input")
    WebElement EmpNameSearch;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement SearchBtn;

public String goToAdminPage(){
    AdminBtn.click();
    String title = driver.findElement(By.cssSelector("h6.oxd-topbar-header-breadcrumb-module")).getText();
return title;
}
public void addSystemUser(String empName,String uname,String pwd) throws InterruptedException {
    AddBtn.click();
    List<WebElement>selectDropdowns =driver.findElements(By.xpath("//div[@class='oxd-select-text-input'][normalize-space()='-- Select --']"));
    WebElement userRole = selectDropdowns.get(0);
    WebElement status = selectDropdowns.get(1);
    List<WebElement> PwdInput= driver.findElements(By.cssSelector("input[type=\"password\"]"));
    WebElement Password = PwdInput.get(0);
    WebElement ConfirmPassword = PwdInput.get(1);

    userRole.click();
    Thread.sleep(2000);
    Actions actions = new Actions(driver);
    actions.sendKeys(Keys.ARROW_DOWN)
            .sendKeys(Keys.ENTER).build().perform();

    EmpName.sendKeys(empName);
    Thread.sleep(2000);
    actions.sendKeys(Keys.ARROW_DOWN)
            .sendKeys(Keys.ENTER).build().perform();
    status.click();
    Thread.sleep(2000);
    actions.sendKeys(Keys.ARROW_DOWN)
            .sendKeys(Keys.ENTER).build().perform();
    UserName.sendKeys(uname);
    Password.sendKeys(pwd);
    ConfirmPassword.sendKeys(pwd);
    Thread.sleep(2000);
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", SaveBtn);
    SaveBtn.click();
}
public void searchSystemUser(String uname,String empname) throws InterruptedException {
    UserNameSearch.sendKeys(uname);
    EmpNameSearch.sendKeys(empname);
    Actions actions = new Actions(driver);
    Thread.sleep(2000);
    actions.sendKeys(Keys.ARROW_DOWN)
            .sendKeys(Keys.ENTER).build().perform();
    Thread.sleep(3000);
    SearchBtn.click();
}

public void deleteSystemUser(){

}


}
