package com.netbanking.Pageobjects;

import com.netbanking.Testclasses.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class ManagerPage extends TestBase {
    WebDriver ldriver;

    public ManagerPage (WebDriver rdriver){
        ldriver=rdriver;
        PageFactory.initElements(rdriver,this);
    }

    //Webelements
    @FindBy (xpath = "//*[@class='heading3' and @behavior='alternate']")
    WebElement WelcomeMsgText;

    @FindBy(xpath = "//*[@class='heading3' and @behavior='alternate']")
    WebElement ManagerIdText;

    @FindBy(xpath = "//table[@class='layout']/tbody/tr/td/center/img[1]")
    WebElement image1;

    //Methods

    public String getWelcomeMsg(){
         return WelcomeMsgText.getText();
    }
    public String getManagerId(){
        String ManagerIDText= ManagerIdText.getText();
        log.info(ManagerIDText.charAt(11));;
        return "";
    }
    public Boolean isimage1Present(){
      return  image1.isDisplayed();
    }






}
