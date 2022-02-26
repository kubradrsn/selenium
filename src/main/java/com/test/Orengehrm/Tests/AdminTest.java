package com.test.Orengehrm.Tests;

import com.test.Orengehrm.Pages.AdminPage;
import com.test.Orengehrm.Pages.LoginPage;
import com.test.Orengehrm.Pages.MainPage;
import org.testng.annotations.Test;

public class AdminTest extends TestBase {

    @Test
    public  void ValidateTheCreationOfEmployeeMessage(){

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin","admin123");

        MainPage mainPage =new MainPage(driver);
        mainPage.clickAdminButton();

        AdminPage adminPage = new AdminPage(driver);
        adminPage.sendingAllInformationForEMployee;





    }

}
