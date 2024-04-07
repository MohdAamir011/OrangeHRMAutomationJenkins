package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.JavascriptExecutor;

public class PIMManage {

    WebDriver driver;
    public PIMManage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = "ul.oxd-main-menu>:nth-child(2)")
    WebElement PIMBtn;
    @FindBy(xpath = "//button[normalize-space()='Add']")
    WebElement addBtn;
    @FindBy(xpath = "//input[@placeholder='First Name']")
    WebElement FName;
    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement LName;
    @FindBy(css = "div.oxd-grid-2>div>div>div>input")
    WebElement EmpId;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement saveBtn;
    @FindBy(xpath = "//a[normalize-space()='Employee List']")
    WebElement empListTab;
    @FindBy(css = "i[class='oxd-icon bi-caret-down-fill']")
    WebElement downArrowForSearch;
    @FindBy(css = "div.oxd-grid-4>div>div>div>input")
    WebElement EmpIDToSearch;
    @FindBy(css = "button[type='submit']")
    WebElement searchButton;
    @FindBy(xpath = "//i[@class='oxd-icon bi-trash']")
    WebElement deleteIcon;
    @FindBy(xpath = "//button[normalize-space()='Yes, Delete']")
    WebElement yesDelPopUp;


    public String goToPIMPage(){
        PIMBtn.click();
        String title =driver.findElement(By.cssSelector(".oxd-text.oxd-text--h6.oxd-topbar-header-breadcrumb-module")).getText();
        return title;
    }
    public String addEmployee(String fname,String lname) throws InterruptedException {
        addBtn.click();
        FName.sendKeys(fname);
        LName.sendKeys(lname);
        String empId = EmpId.getAttribute("value");

        Thread.sleep(3000);
        saveBtn.click();
        return empId;
    }
    public void goToEmpList(){
        empListTab.click();
    }
    public void SearchEmp(String empId){
        EmpIDToSearch.sendKeys(empId);
        searchButton.click();
    }
    public void deleteEmp(String empID){
        deleteIcon.click();
        yesDelPopUp.click();
    }
}
