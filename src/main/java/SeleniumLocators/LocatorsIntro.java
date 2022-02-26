package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsIntro {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("file:///Users/Kubra/Downloads/Techtorial%20(2).html");
        WebElement header = driver.findElement(By.id("techtorial1"));
        String actualText = header.getText();// from the system
        String expectedText = "Techtorial Academy";

        if (actualText.equals(expectedText)){
            System.out.println("passed");
        }else {
            System.out.println("failed");
        }

        // getText() --> it gives

        WebElement text = driver.findElement(By.id("details2"));
        System.out.println(text.getText());

        if (text.getText().equals("To create your account, \n" +
                "        we'll need some basic information about you. This information will be \n" +
                "        used to send reservation confirmation emails, mail tickets when needed \n" +
                "        and contact you if your travel arrangements change. Please fill in the \n" +
                "        form completely."));
        {
            System.out.println("passed");
        }



            // LOCATOR CLASSNAME:
            WebElement tools = driver.findElement(By.className("group_checkbox"));
            System.out.println(tools.getText());

           // NOTE: IF YOU PROVIDE WRONG PATH WEB ELEMENT. IT WILL TROW AN EXCEPTION WHICH IS CALLED
        // "No such Element Exception "


            //LOCATOR NAME :

        WebElement firstName = driver.findElement(By.name("firstName"));
        firstName.sendKeys("Kubra");

        WebElement lastName = driver.findElement(By.name("lastName"));
        lastName.sendKeys("Dursun");

        WebElement phoneNumber = driver.findElement(By.name("phone"));
        phoneNumber.sendKeys("312 855 23 45");

        WebElement email = driver.findElement(By.id("userName"));
        email.sendKeys("cutie.ak@hotmail.com");

        WebElement javaBox = driver.findElement(By.id("cond1"));
        javaBox.click();
        System.out.println(javaBox.isDisplayed());
        System.out.println(javaBox.isSelected());

        WebElement TestNG = driver.findElement(By.id("cond3"));
        TestNG.click();
        System.out.println(TestNG.isDisplayed());
        System.out.println(TestNG.isSelected());


        WebElement Cucumber = driver.findElement(By.id("cond4"));
        Cucumber.click();
        System.out.println(Cucumber.isDisplayed());
        System.out.println(Cucumber.isSelected());








    }
}
