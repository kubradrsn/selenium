package SeleniumIntro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumBasics {
    public static void main(String[] args) {
        // Step 1 : We need to define the chrome driver into the project as a property.

        System.setProperty("webdriver.chrome.driver", "chromedriver");

        // Windows:
        // System.setProtperty("webdriver.chrome.driver", "chromedriver.exe")

        //step 2 : we need to instantiate (declare )our driver.

        WebDriver driver = new ChromeDriver();

        // Note : Driver is a reference name . webdriver --> interface
        // new ChromeDriver () --> new object.

        //  FIRST INterview  QUESTIONS:
        // WHERE DO YOU USE POLYMORPHISM IN YOUR TESTING FRAMEWORK?
        // I USE IT TO INSTANTIATE MY DRIVER.EXAMPLE

        // WebDriver driver = new ChromeDriver();

        //SECOND interview questions:
        //can you istantia your driver like

        // WebDriver driver = new WebDriver();

        // FIRST METHOD :
        // GET () --> methods navigates to the given url.
        driver.get("https://www.techtorialacademy.com/");

        // getTitle()-- >methods get the little of the page

        String title = driver.getTitle();
        System.out.println(title);
        if (title.equals("Home Page - Techtorial")){
            System.out.println("Your test is passed");
        }else{
            System.out.println("your test is failed");
        }
    // getCurrentUrl()--> it's get Currentl Url of the website
        String actual = driver.getCurrentUrl();
        String exepected = "https://www.techtorialacademy.com/";
        if (actual.equals(exepected)){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }


    }
}
