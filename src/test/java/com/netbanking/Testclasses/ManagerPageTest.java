package com.netbanking.Testclasses;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.netbanking.Pageobjects.LoginPage;
import com.netbanking.Pageobjects.ManagerPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class ManagerPageTest extends TestBase{

    @Test(priority = 1)
    public void Login() throws IOException {
        ExtentTest ManagerPageTest=extentReports.createTest("ManagerPage test ","validating Manager page demo99 functionality ");
        log.info("Launch BaseUrl -  started");
        GetUrl(baseURL);
        login(userName,Password);
        log.info( "Clicked on login button successfully");
        ManagerPageTest.log(Status.PASS,"validating Manager page demo99  login successfull");
    }
    @Test(priority = 2)
    public void VerifyWelcomeMsg() throws InterruptedException {
        log.info("Verify welcome message - started");
        ManagerPage managerPage=new ManagerPage(driver);
        String wwelcomeMsg=managerPage.getWelcomeMsg();
        assertValues("Welcome To Manager's Page of Guru99 Bank",wwelcomeMsg);
//        Assert.assertEquals("Welcome To Manager's Page of Guru99 Bank",wwelcomeMsg);
        Thread.sleep(2000);
        driver.findElement(By.linkText("New Customer")).click();


    }

}
