package com.netbanking.Testclasses;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.beust.jcommander.Parameter;
import com.netbanking.Pageobjects.LoginPage;
import com.netbanking.Utilities.Readconfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class TestBase {
    Readconfig rc=new Readconfig();
    public String baseURL=rc.getUrl();
    public String userName=rc.getUserName();
    public String Password = rc.getPassword();
    public static WebDriver driver;
    public static Logger log;
    String BrowserName="firefox";
    static ExtentHtmlReporter htmlReporter;
    static ExtentReports extentReports;
    @BeforeClass
    //@Parameters("BrowserName")
    public void setUp(){
        log= LogManager.getLogger(TestBase.class);
        if(BrowserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\new user\\IdeaProjects\\Internetbankingdemo99\\src\\Drivers\\chromedriver.exe");
            driver = new ChromeDriver();
            log.info("launching browser-Completed");
        }
        else if(BrowserName.equals("firefox")){
            System.setProperty("webdriver.gecko.driver","C:\\Users\\new user\\IdeaProjects\\Internetbankingdemo99\\src\\Drivers\\geckodriver.exe");
            driver = new FirefoxDriver();
            log.info("launched Firefox Driver-Completed");
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        htmlReporter= new ExtentHtmlReporter("C:\\Users\\new user\\IdeaProjects\\Internetbankingdemo99\\extentReport.html");
        extentReports= new ExtentReports();
        extentReports.attachReporter(htmlReporter);

    }
    public void login(String UserName, String Password){
        LoginPage loginPage =new LoginPage(driver);
        loginPage.setUserName(UserName);
        loginPage.setPassword(Password);
        loginPage.clickLoginbtn();
    }
    public void logOut(){
        LoginPage loginPage =new LoginPage(driver);
        loginPage.clickLogOutbtn();
    }
    public void assertValues(String expectedvalue, String actualValue){
        Assert.assertEquals(actualValue,expectedvalue);
    }

    public void GetUrl(String baseURL){
        driver.get( baseURL);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
