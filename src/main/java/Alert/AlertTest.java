package Alert;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertTest {

    @Test
    public  void JSAlert1(){
        /*
        1)Navigate to "https://sweetalert.js.org/"
        2)Click first preview(which is on the bottom left one)
         3)Validate the text on pop-up
          4)Handle the pop up
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://sweetalert.js.org/");
        driver.manage().window().maximize();

        WebElement preview = driver.findElement(By.xpath("//button[contains(@onclick,'alert')]"));
        preview.click();

        Alert alert = driver.switchTo().alert();

        String actualText = alert.getText();
        String expectedText = "Oops, something went wrong!";
        Assert.assertEquals(actualText,expectedText);
        alert.accept();

//        String actuelPreview = BrowserUtils.getTextMethod(preview);
//        String expectedPreview = "Oops, something went wrong!";
////h5[contains(text(),'Normal alert']
//        Assert.assertEquals(actuelPreview,expectedPreview);
    }

    @Test
    /* TASK 2 (ALERT CLASS)
     1)Navigate to "https://sweetalert.js.org/"
    2)Click first preview(which is on the bottom right one)
    3)Validate the text on pop-up
    4)Handle the pop up
     */
    public void TrailForAlertToHandleHTMLPopup2(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://sweetalert.js.org/");


        WebElement previewHTML = driver.findElement(By.xpath("//button[contains(@onclick,'swal')]"));
        previewHTML.click();

        Alert alert = driver.switchTo().alert();
        alert.accept();


    }

    @Test

    /*
    TASK 3 (HTML ALERT)
    1)Navigate to "https://sweetalert.js.org/"
    2)Click first preview(which is on the bottom right one)
    3)Validate the text on pop-up
    4)Handle the pop up
     */

    public void HTMLAlert3() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://sweetalert.js.org/");


        WebElement previewHTML = driver.findElement(By.xpath("//button[contains(@onclick,'swal')]"));
        previewHTML.click();

        Thread.sleep(2000);


//        String actualText = BrowserUtils.getTextMethod(text);
//        String expectedText = "Something went wrong!";
//        Assert.assertEquals(actualText,expectedText);





    }

}
