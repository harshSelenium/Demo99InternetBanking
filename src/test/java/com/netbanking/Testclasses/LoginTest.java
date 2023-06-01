package com.netbanking.Testclasses;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.netbanking.Pageobjects.LoginPage;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

public class LoginTest extends TestBase{

    @Test(priority = 1,dataProvider = "LoginData",groups = "sanity")
    public void Login(String userName, String Password) throws InterruptedException {
//        ExtentHtmlReporter htmlReporter= new ExtentHtmlReporter("C:\\Users\\new user\\IdeaProjects\\Internetbankingdemo99\\extentReport.html");
//        ExtentReports extentReports= new ExtentReports();
//        extentReports.attachReporter(htmlReporter);

        ExtentTest loginTest=extentReports.createTest("Login test ","validating login to demo99 functionality ");

        loginTest.log(Status.INFO,"Launch BaseUrl -  started");
        log.info("Launch BaseUrl -  started");
        driver.get( baseURL);

        login(userName,Password);

        loginTest.log(Status.PASS,"login successfully");
        log.info( "Clicked on login button successfully");
        Thread.sleep(5000);

        logOut();

        loginTest.log(Status.PASS,"loggedOut successfully");
        driver.switchTo().alert().accept();
        Thread.sleep(5000);
        extentReports.flush();

    }

    @DataProvider(name = "LoginData")
    public static String[][] ReadExcel() throws IOException {
        String file= "C:\\Users\\new user\\IdeaProjects\\Internetbankingdemo99\\src\\test\\java\\com\\netbanking\\Testdata\\Data.xlsx";
        FileInputStream fis=new FileInputStream(file);
        XSSFWorkbook wb=new XSSFWorkbook(fis);
        XSSFSheet ws = wb.getSheet("Sheet1");
        int rowCount= ws.getLastRowNum();
       String loginData [][]=new String[rowCount][2];
        for(int i=1;i<=rowCount; i++){
            for(int j=0;j<2;j++){
//                String UserName=ws.getRow(i).getCell(0).getStringCellValue();
//                String Password=ws.getRow(i).getCell(1).getStringCellValue();
                loginData[i-1][j]=ws.getRow(i).getCell(j).getStringCellValue();
            }
        }
        return loginData;
    }




}
