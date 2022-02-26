package Homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class HhomeWwork {

    @Test
    public void ValidationOfSortButton () throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://demo.opencart.com/admin/");
        driver.manage().window().maximize();

        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

        WebElement catalogBar = driver.findElement(By.id("menu-catalog"));
        catalogBar.click();
        Thread.sleep(1000);

        WebElement options = driver.findElement(By.xpath("//a[.='Options']"));
        options.click();
        Thread.sleep(1000);

        //============================  HOMEWORK  =================================

        WebElement sortOrderButtonD = driver.findElement(By.xpath("//a[.='Sort Order']"));
        sortOrderButtonD.click();//is going to sort the elements is descending order
        Thread.sleep(1000);
        //validate that elements are in descending order
        List<WebElement> descendingSortOrderNumbers = driver.findElements(By.xpath("//tbody/tr/td[3]"));
        List<Integer> actualNumbersDesOrder = new LinkedList<>();
        List<Integer> expectedNumbersDesOrder = new ArrayList<>();
        for(int i=0; i < descendingSortOrderNumbers.size(); i++){
            actualNumbersDesOrder.add(Integer.valueOf(descendingSortOrderNumbers.get(i).getText().trim()));
            expectedNumbersDesOrder.add(Integer.valueOf(descendingSortOrderNumbers.get(i).getText().trim()));
        }
//        System.out.println("Act ord: " + actualNumbersDesOrder);
//        System.out.println("Exp ord: " + expectedNumbersDesOrder);
        Collections.sort(expectedNumbersDesOrder);
        Collections.reverse(expectedNumbersDesOrder);
        // now elements in expectedNumbersDesOrder are sorted in descendant order
//        System.out.println("Exp ord: " + expectedNumbersDesOrder);
        Assert.assertEquals(actualNumbersDesOrder, expectedNumbersDesOrder);

        //------------------------------------------------------------------------------

        WebElement sortOrderButtonA = driver.findElement(By.xpath("//a[.='Sort Order']"));
        sortOrderButtonA.click();//is going to sort the elements is descending order
        Thread.sleep(1000);

        List<WebElement> ascendingSortOrderNumbers = driver.findElements(By.xpath("//tbody/tr/td[3]"));
        Set<Integer> actualNumbersAscOrder = new LinkedHashSet<>();//accept insert order
        Set<Integer> expectedNumbersAscOrder = new TreeSet<>();//ascending order
        for(int i=0; i<ascendingSortOrderNumbers.size(); i++){
            actualNumbersAscOrder.add(Integer.valueOf(ascendingSortOrderNumbers.get(i).getText().trim()));
            expectedNumbersAscOrder.add(Integer.valueOf(ascendingSortOrderNumbers.get(i).getText().trim()));
        }
        Assert.assertEquals(actualNumbersAscOrder,expectedNumbersAscOrder);
    }

}
