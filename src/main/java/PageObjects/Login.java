package PageObjects;

import base.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.List;

public class Login extends Base {
    WebDriver driver;
    String username = "";
    String password= "";
    public Login(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }
    @FindBy(css = "div.oxd-sheet >p")
    List<WebElement> CredText ;
    @FindBy(css = "[name =\"username\"]")
    WebElement UserName;
    @FindBy(css = "[name =\"password\"]")
    WebElement Password;
    @FindBy(css = "button[type =\"submit\"]")
    WebElement LoginButton;

    public HashMap<String,String> getLogInCred(){
        WebElement usernametext = CredText.stream().filter(ptext->ptext.getText().contains("Username")).findAny().orElse(null);
        WebElement passwordtext = CredText.stream().filter(ptext->ptext.getText().contains("Password")).findAny().orElse(null);
        String []user =usernametext.getText().split(":");
        this.username=user[1];
        String []pwd =passwordtext.getText().split(":");
        this.password=pwd[1];
        System.out.println(username+"  "+password);
        HashMap<String,String> data = new HashMap<String,String>();
        data.put("uname",username.trim());
        data.put("pwd",password.trim());
        return data;
    }

    public void fillLoginForm(HashMap<String,String>data){
        UserName.sendKeys(data.get("uname"));
        Password.sendKeys(data.get("pwd"));
        LoginButton.click();
    }

}
