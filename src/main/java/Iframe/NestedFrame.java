package Iframe;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NestedFrame {

    @Test
    public  void nestedFrameValidation(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        driver.manage().window().maximize();

// this is example of using index to switch frame

        driver.switchTo().frame(0); // I am on the top frame

// this is the example of using webElement to switch frame

        WebElement middleFrame = driver.findElement(By.name("frame-middle"));
        driver.switchTo().frame(middleFrame); // I am on the middle frame

        WebElement textBox = driver.findElement(By.xpath("//div[@id='content']"));

        String actualName = BrowserUtils.getTextMethod(textBox);
        String expectedName = "MIDDLE";

        Assert.assertEquals(actualName,expectedName);

        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-left");

        WebElement leftBox = driver.findElement(By.xpath("//body[contains(text(),'LEFT')]"));
        String actualleftBox = leftBox.getText().trim();
        String expectedleftBox = "LEFT";
        Assert.assertEquals(actualleftBox,expectedleftBox);

//        driver.switchTo().parentFrame(); // top
//        driver.switchTo().parentFrame();

        driver.switchTo().defaultContent(); // means it directly goes to the HTML

        driver.switchTo().frame("frame-bottom");

        WebElement BOTTOM =driver.findElement(By.xpath("//body[contains(text(),'BOTTOM')]"));
        String actualBottom = BrowserUtils.getTextMethod(BOTTOM);
        String expectedBottom = "BOTTOM";
        Assert.assertEquals(actualBottom,expectedBottom);
    }
}
