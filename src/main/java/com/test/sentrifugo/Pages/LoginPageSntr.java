package com.test.sentrifugo.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageSntr {

    /*  we are going to store our element locations
         and methods here
     */


    public LoginPageSntr(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@id='username']")
    WebElement usurname ;

    @FindBy(xpath = "//input[@id='password']")
    WebElement password;

    @FindBy(id ="loginsubmit")
    WebElement loginButton;

    public  void login(){
        usurname.sendKeys("EM01");
        password.sendKeys("sentrifugo");
        loginButton.click();
    }

    public void dynamicLogin(String username, String password){
        this.usurname.sendKeys(username);
        this.password.sendKeys(password);
        loginButton.submit();
    }



}
