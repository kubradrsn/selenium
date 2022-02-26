package JavaScriptExecutor;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.bouncycastle.voms.VOMSAttribute;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import sun.security.krb5.internal.KdcErrException;

public class JSMethods {

    /*
    Whenever normal methods are not working then last decision should JavaScript
     */

    @Test
    public void TitleMethod(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.techtorialacademy.com/");
        driver.manage().window().maximize();

        System.out.println(driver.getTitle());

//        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
//        String title = javascriptExecutor.executeAsyncScript("return document.title").toString();
//        System.out.println(title+"from javaScript");

        String actualTitle = BrowserUtils.GetTitleWithJS(driver);
        String  expectedTitle = "Home Page - Techtorial ";
        Assert.assertEquals(actualTitle,expectedTitle);

    }

    @Test // I use this method often
    public  void ClickWithJS(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.techtorialacademy.com/");


        WebElement browserCourse = driver.findElement(By.xpath("//a[.='Browse Course']"));
        BrowserUtils.ClickWithJS(driver,browserCourse);
//        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
//        javascriptExecutor.executeScript("arguments[0].click()",browserCourse);

    }

    @Test
    public void ClickWIthJSPractice(){
        //click the student login
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.techtorialacademy.com/");
        driver.manage().window().maximize();

        WebElement studentLogin = driver.findElement(By.xpath("//div[@class='navigation hidden-xs']//a[.='Student login']"));

        BrowserUtils.ClickWithJS(driver,studentLogin);


    }

    @Test
    public  void ScrollIntoView(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.techtorialacademy.com/");

        WebElement copyright = driver.findElement(By.xpath("//p[contains(text(),'Copy')]"));

        JavascriptExecutor js = (JavascriptExecutor) driver ;
        js.executeScript("arguments[0].scrollIntoView(true)", copyright);

    }

    @Test
    public void BrowseCourse (){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.techtorialacademy.com/");

        WebElement BrowseCourse = driver.findElement(By.xpath("//a[.='Browse Course']"));
        BrowserUtils.ClickWithJS(driver,BrowseCourse);

        WebElement GetStarted = driver.findElement(By.xpath("//h4[.='On-Campus Course']//..//a"));

//        JavascriptExecutor js = (JavascriptExecutor) driver ;
//          js.executeScript("arguments[0].browseCourse(true)",GetStarted);

          BrowserUtils.ScrollWithJS(driver,GetStarted);
          BrowserUtils.ClickWithJS(driver,GetStarted);

    }
    @Test
    public void ScrollWithXandYCordinantTest(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.techtorialacademy.com/");

        WebElement copyright = driver.findElement(By.xpath("//p[contains(text(),'Copy')]"));

//        JavascriptExecutor js = (JavascriptExecutor) driver ;
//
//        Point location = copyright.getLocation();
//        System.out.println(location.getX());
//        System.out.println(location.getY());
//
//        int xCord = location.getX();
//        int yCord = location.getY();
//
//        js.executeScript("window.scrollTo("+xCord+","+yCord+")");

        BrowserUtils.ScrollWithXandYCordinantTest(driver,copyright);
    }



}
