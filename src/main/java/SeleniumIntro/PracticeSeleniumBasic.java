package SeleniumIntro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PracticeSeleniumBasic {
    public static void main(String[] args) throws InterruptedException {
        /* TAsk :
        I want you go to the 3 website. Get the title currentURL
        You decide and going back
        forward with them lastly refresh and quit
         */

        System.setProperty("webdriver.chrome.driver","chromedriver");
        WebDriver driver = new ChromeDriver();


        driver.navigate().to("https://www.facebook.com/");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        driver.navigate().to("https://www.youtube.com/");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        driver.navigate().to("https://www.instagram.com/");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        driver.navigate().back();

        driver.navigate().forward();

        driver.navigate().refresh();

        driver.close();





    }
}
