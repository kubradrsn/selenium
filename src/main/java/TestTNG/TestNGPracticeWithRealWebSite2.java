package TestTNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class TestNGPracticeWithRealWebSite2 {

    @Test
    public void validationOfAscendingOrderOfOption() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://demo.opencart.com/admin/");
        driver.manage().window().maximize();

        WebElement loginButton=driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

        WebElement catalogBar=driver.findElement(By.id("menu-catalog"));
        catalogBar.click();
        Thread.sleep(1000);

        WebElement options = driver.findElement(By.xpath("//a[.='Options']"));
        options.click();

        Thread.sleep(1000);


        List<WebElement> alloptions = driver.findElements(By.xpath("//tbody/tr/td[2]"));
        Set<String> actualOptionsOrder = new LinkedHashSet<>(); // --> it accepts insertion order
        Set<String> expectedOptionsOrder = new TreeSet<>();

        for(WebElement option : alloptions){
            actualOptionsOrder.add(option.getText().trim());
            expectedOptionsOrder.add(option.getText().trim());
            Assert.assertEquals(actualOptionsOrder,expectedOptionsOrder);
        }
    }

    @Test
    public  void validationOfDescendingOrderOptions() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://demo.opencart.com/admin/");
        driver.manage().window().maximize();

        WebElement loginButton=driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

        WebElement catalogBar=driver.findElement(By.id("menu-catalog"));
        catalogBar.click();
        Thread.sleep(1000);

        WebElement options = driver.findElement(By.xpath("//a[.='Options']"));
        options.click();

        Thread.sleep(1000);

        WebElement optionNameButton = driver.findElement(By.xpath(" //a[.='Option Name']"));
        optionNameButton.click();

        List<WebElement> descendingallOptions = driver.findElements(By.xpath("//tbody/tr//td[2]"));
        List<String>actualDescendingOrder = new LinkedList<>();
        List<String>expectedDescendingOrder = new ArrayList<>();

        for (int i = 0 ;i<descendingallOptions.size(); i ++){
            actualDescendingOrder.add(descendingallOptions.get(i).getText().trim());
            expectedDescendingOrder.add(descendingallOptions.get(i).getText().trim());

            Collections.sort(expectedDescendingOrder);
            Collections.reverse(expectedDescendingOrder);
        }
        Assert.assertEquals(actualDescendingOrder,expectedDescendingOrder);

    }
}
