package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookPractice {
    public static void main(String[] args) throws InterruptedException {
        /*
        Scenario:   Open a Chrome browser.
         Navigate to "http://www.fb.com"
        Verify that the page is redirected to "http://www.facebook.com",
        by getting the current URL. (use Assertion)
       Verify that there is a "Create an account" section on the page.
       Fill in the text boxes:  First Name, Surname,
       Mobile Number or email address, "Re-enter mobile number", new password.
     Update the date of birth in the drop-down.
      Select gender.
      Click on "Create an account".
        Verify that the account is not created.
         */

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");


        driver.manage().window().maximize();
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "http://www.facebook.com/";

        if(actualURL.equals(expectedURL)){
            System.out.println("the website is correct");
        }else{
            System.out.println("the website is wrong");

        }


          WebElement createAccountButton=driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));
          boolean validationButton = createAccountButton.isDisplayed();
          boolean expectedValidationButton = true;

        if (validationButton==expectedValidationButton){
            System.out.println("Button is displayed");

        }else{
            System.out.println("Button is not displayed");
        }

        createAccountButton.click();

        Thread.sleep(1000);

        WebElement firstname = driver.findElement(By.name("firstname"));
        firstname.sendKeys("Kubra");

        Thread.sleep(1000);


        WebElement lastname = driver.findElement (By.name("lastname"));
          lastname.sendKeys("Dursun");

        Thread.sleep(1000);


          WebElement email = driver.findElement(By.name("reg_email__"));
           email.sendKeys("cutie.ak@gmail.com");

        Thread.sleep(1000);

           WebElement confirmationEmail = driver.findElement(By.name("reg_email_confirmation__"));
           confirmationEmail.sendKeys("Kubra@gamil.com");

        Thread.sleep(1000);


            WebElement passwrd = driver.findElement(By.name("reg_passwd__"));
             passwrd.sendKeys("cutie.ak@gmail.com");

        Thread.sleep(1000);

            WebElement month = driver.findElement(By.id("month"));
            month.sendKeys("july");

        Thread.sleep(1000);

          WebElement day = driver.findElement(By.id("birthday_day"));
           day.sendKeys("20");

        Thread.sleep(1000);

        WebElement year = driver.findElement(By.id("Birthday_year"));
        year.sendKeys("1988");

           WebElement gender = driver.findElement(By.xpath("//input[@name='sex and @value = '2']"));
           gender.click();


             WebElement signupbutton = driver.findElement(By.name("website"));
             signupbutton.click();

        Thread.sleep(1000);







    }
}
