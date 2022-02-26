package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinksAndTags {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("file:///Users/Kubra/Downloads/Techtorial%20(2).html");
        driver.manage().window().maximize();

        WebElement javalink = driver.findElement(By.linkText("Java"));
        javalink.click();
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());

        driver.navigate().back();


        WebElement SeleniumLink = driver.findElement(By.linkText("Selenium"));
        SeleniumLink.click();
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());

        driver.navigate().back();

        WebElement CucumberLink = driver.findElement(By.linkText("Cucumber"));
        CucumberLink.click();
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        Thread.sleep(3000);
        driver.navigate().back();
        Thread.sleep(3000);
        javalink = driver.findElement(By.linkText("Java"));
        javalink.click();
        Thread.sleep(3000);
        driver.navigate().back();
        Thread.sleep(3000);
        WebElement resApi = driver.findElement(By.partialLinkText("Rest"));
        resApi.click();
        Thread.sleep(3000);
        driver.navigate().back();
        Thread.sleep(3000);
        WebElement version = driver.findElement(By.tagName("u"));
        System.out.println(version.getText());







    }
}
