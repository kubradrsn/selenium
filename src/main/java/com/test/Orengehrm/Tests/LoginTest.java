package com.test.Orengehrm.Tests;

import com.test.Orengehrm.Pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

//    WebDriver driver;
//    @BeforeMethod
//
//    public void setup(){
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
//        driver.manage().window().maximize();
//
//        System.out.println("i am running before every test annotation");
//    }


    @Test
    public void validateLoginPositive(){

//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
//        driver.manage().window().maximize();

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("Admin","admin123");

        String actualUrl= driver.getCurrentUrl();
        String expectedUrl="https://opensource-demo.orangehrmlive.com/index.php/dashboard";

        Assert.assertEquals(actualUrl,expectedUrl);
    }


    @Test
    public void validateLoginNegative1(){

//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
//        driver.manage().window().maximize();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin","ahmet");

        String actualErrorMessage=loginPage.getErrorMessage();
        String expectedErrorMessage="Invalid credentials";

        Assert.assertEquals(actualErrorMessage,expectedErrorMessage);
    }

    @Test
    public void validateLoginNegative2(){
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
//        driver.manage().window().maximize();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("","");

        String actualErrorMessage=loginPage.getErrorMessage();
        String expectedErrorMessage="Username cannot be empty";

        Assert.assertEquals(actualErrorMessage,expectedErrorMessage);

        String actualColorOfErrorMessage=loginPage.getColorOfTheErrorMessage();
        String expectedColorOfErrorMessage="rgba(221, 119, 0, 1)";

        Assert.assertEquals(actualColorOfErrorMessage,expectedColorOfErrorMessage);
    }
//    @AfterMethod
//
////    public void tearDown(){
////        System.out.println("I am running after each test annotation");
////        driver.quit();
////
////    }




}
