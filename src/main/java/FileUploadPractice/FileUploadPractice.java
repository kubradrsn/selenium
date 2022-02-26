package FileUploadPractice;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.Browser;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileUploadPractice {

    @Test
    public void ValidateFileUpload(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/upload");
        driver.manage().window().maximize();

        WebElement chooseFile = driver.findElement(By.id("file-upload"));
        chooseFile.sendKeys("/Users/Kubra/Desktop/USA.png");

        WebElement UploadButton = driver.findElement(By.id("file-submit"));
        UploadButton.click();

        WebElement message1 = driver.findElement(By.tagName("h3"));

        String actualMessage1 = BrowserUtils.getTextMethod(message1);
        String expectedMessage1 = "File Uploaded!";

        Assert.assertEquals(actualMessage1,expectedMessage1);

        WebElement Message2 = driver.findElement(By.id("uploaded-files"));

        String actualMessage2 = BrowserUtils.getTextMethod(Message2);
        String expectedMessage2 = "USA.png";

        Assert.assertEquals(actualMessage2,expectedMessage2);



    }
}
