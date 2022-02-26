package Homework.Homework1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase {
    public static void main(String[] args) throws InterruptedException {
       // INTERVIEW QUESTIONS:  What is WEB DRIVER  and why do need it?

        // web driver is connection between webpage and your system
        // I need web driver to MANIPULATE (change ..etc)  the webpage  elements
        // first step of starting automation should be reading the test case (TAsk)
        // Step by step implement the requirements.

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://demoqa.com/text-box");

        WebElement fullNameBox = driver.findElement(By.xpath("//input[@id='userName']"));
        fullNameBox.sendKeys("Kubra Dursun");

        WebElement email = driver.findElement(By.xpath("//input[@type='email']"));
        email.sendKeys("cutie.ak@hotmal.com");

        WebElement CurAddress = driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
        CurAddress.sendKeys("3900 N. pine grove ");

        WebElement permanentAddress = driver.findElement(By.xpath("//textarea[@id='permanentAddress']"));
        permanentAddress.sendKeys("Ataslar Diyar life Diyarbakir permanentAddress ");

        WebElement button = driver.findElement(By.xpath("//button[@id='submit']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", button);
        button.click();

        Thread.sleep(500);

//        WebElement button = driver.findElement(By.xpath("//button[@id='submit']"));
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);
//        button.click();

         WebElement nameValidation = driver.findElement(By.xpath("//p[@id='name']"));

        System.out.println(nameValidation.getText());

        String expectedValidation="Name:Kubra Dursun"  ;
        String actualValidation = nameValidation.getText();

        if(expectedValidation.equals(actualValidation)){
            System.out.println("pass");
        }else{
            System.out.println("fail");
        }








    }
}
