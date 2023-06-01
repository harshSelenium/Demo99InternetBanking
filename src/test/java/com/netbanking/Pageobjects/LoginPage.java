package com.netbanking.Pageobjects;

import com.netbanking.Testclasses.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {
       WebDriver ldriver;

       public LoginPage(WebDriver rdriver){
        ldriver=rdriver;
        PageFactory.initElements(rdriver,this);
       }

       @FindBy(name="uid")
        WebElement userNamefield;
       @FindBy(name = "password")
        WebElement pwdField;
       @FindBy(name="btnLogin")
        WebElement loginBtn;

       @FindBy(xpath = "//a[contains(text(),'Log out')]")
       WebElement LogOutBtn;
       @FindBy(xpath = "//a[contains(text(),'New Customer')]")
       public WebElement newcustomerBtn;
       public void setUserName(String usernamevalue){
           userNamefield.sendKeys(usernamevalue);
       }
       public void setPassword(String pwdvalue){
            pwdField.sendKeys(pwdvalue);
        }
       public void clickLoginbtn(){
           loginBtn.click();
        }
        public void clickOnNewCustomerBtn(){
           newcustomerBtn.click();
        }
        public void clickLogOutbtn(){
            LogOutBtn.click();
        }
}
