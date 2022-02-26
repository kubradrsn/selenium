package com.test.Orengehrm.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPage {

    public  AdminPage(WebDriver driver){
        PageFactory.initElements(driver,this);

    }

       @FindBy(id ="btnAdd")
      WebElement AddButton;

     @FindBy(id = "systemUser_userType")
    WebElement UserRoles;

     @FindBy(id = "systemUser_employeddName_empName")
     WebElement employeeName;

    @FindBy (xpath ="//input[@id='systemUser_userName']")
    WebElement UserName;

    @FindBy(name ="systemUser[sattus]")
    WebElement status;

    @FindBy (name ="systemUser[password]")
    WebElement password;






}
