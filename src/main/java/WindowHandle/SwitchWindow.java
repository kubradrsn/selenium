package WindowHandle;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class SwitchWindow {

    @Test
    public void practice1() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/windows");

        System.out.println(driver.getWindowHandle());

        WebElement click = driver.findElement(By.xpath("//a[.='Click Here']"));
        click.click();

        System.out.println(driver.getWindowHandles());

        //WebElement header = driver.findElement(By.xpath("//h3[.='New Window']"));
        //System.out.println(header.getText());

        String mainPageId = driver.getWindowHandle();
        Set<String> allPagesId = driver.getWindowHandles();

        // this implementation for only 2 tabs

        for (String id : allPagesId) {
            //System.out.println(id);
            if (!id.equals(mainPageId)) {
                driver.switchTo().window(id);
            }
        }

        WebElement header = driver.findElement(By.xpath("//h3[.='New Window']"));
        System.out.println(header.getText());

        String actualText = header.getText();
        String expectedText = "New Window";

        Assert.assertEquals(actualText, expectedText);

    }

    @Test
    public void WindowHandlePractice2() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");

        String mainPageid = driver.getWindowHandle();

        WebElement button2 = driver.findElement(By.id("newTabBtn"));
        button2.click();

        BrowserUtils.SwitchOnlyFor2Tabs(driver, mainPageid);

        Set<String> allPagesId = driver.getWindowHandles();
//
//        for (String id : allPagesId) {
//            if (!id.equals(mainPageid)) {
//                driver.switchTo().window(id);
//            }
//        }

        WebElement header = driver.findElement(By.xpath("//h1[contains(text(),'Alert')]"));

        String actualHeader = BrowserUtils.getTextMethod(header);
        String expectedHeader = "AlertsDemo";

        Assert.assertEquals(actualHeader,expectedHeader);

        WebElement click = driver.findElement(By.id("alertBox"));
        click.click();


    }
}