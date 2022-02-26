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

public class AlertIntro {

    @Test
    public  void JSBAlertAcceptTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();

        WebElement clickJsAlert = driver.findElement(By.xpath("//button[.='Click for JS Alert']"));
        Thread.sleep(2000);
        clickJsAlert.click();

//        WebElement header = driver.findElement(By.tagName("h3")); // UnhandledAlertexception
//        System.out.println(header.getText());

        Alert alert = driver.switchTo().alert();
        String actualText = alert.getText();
        String expectedText = "I am a JS Alert";
        Assert.assertEquals(actualText,expectedText);
        alert.accept();

        WebElement message  = driver.findElement(By.xpath("//p[@id='result']"));

        String actuelMessage = BrowserUtils.getTextMethod(message);
        String expectedMessage = "You successfully clicked an alert";

        Assert.assertEquals(actuelMessage,expectedMessage);

    }

    @Test
    public void JSAlertDismissMethod() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        WebElement clickForJsConfirm  = driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));
        Thread.sleep(2000);
        clickForJsConfirm.click();

        Alert alert = driver.switchTo().alert();

        String actualText = alert.getText();
        String expectedText = "I am a JS Confirm";
        Assert.assertEquals(actualText,expectedText);
        alert.dismiss();

        WebElement message  = driver.findElement(By.xpath("//p[@id='result']"));

        String actuelMessage = BrowserUtils.getTextMethod(message);
        String expectedMessage = "You clicked: Cancel";

        Assert.assertEquals(actuelMessage,expectedMessage);


    }

    @Test
    public  void AlertClassSendKeys() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        WebElement clickForJsPrompt = driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));
        Thread.sleep(2000);
        clickForJsPrompt.click();

        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Grigore");
        alert.accept();

        WebElement message  = driver.findElement(By.xpath("//p[@id='result']"));

        Thread.sleep(2000);

        String actuelMessage = BrowserUtils.getTextMethod(message);
        String expectedMessage = "You entered: Grigore";

        Assert.assertEquals(actuelMessage,expectedMessage);



    }

}
