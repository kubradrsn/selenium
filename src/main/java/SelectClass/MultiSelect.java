package SelectClass;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MultiSelect {

    @Test
    public  void multipleSelectAndFirstSelectPractice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.navigate().to("file:///Users/Kubra/Downloads/Techtorial%20(3).html");
        driver.manage().window().maximize();

        WebElement header = driver.findElement(By.id("techtorial1"));

        WebElement multiSelectBox = driver.findElement(By.xpath("//select[@class='select']"));
        BrowserUtils.selectBy(multiSelectBox,"Two","text");
        BrowserUtils.selectBy(multiSelectBox,"3","index");
        BrowserUtils.selectBy(multiSelectBox,"5","value");

        Select select = new Select(multiSelectBox);
        Thread.sleep(2000);
        select.deselectByIndex(3);
        //select.deselectAll();


        // trim ()--> it removes the space from both side of the string.

        WebElement countryList = driver.findElement(By.name("country"));
        Select contry = new Select(countryList);

      //  String actualFirstSelectedOptions = contry.getFirstSelectedOption().getText().trim();
        String actualFirstSelectedOptions = BrowserUtils.getTextMethod(contry.getFirstSelectedOption());

        String expectedFirstSelectedOptions = "UNITED STATES";

        Assert.assertEquals(actualFirstSelectedOptions,expectedFirstSelectedOptions);




    }
}
