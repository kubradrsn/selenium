package SeleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FindElements {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");

        List<WebElement>allLinks = driver.findElements(By.xpath("//li/a"));
        for (WebElement link: allLinks){
            System.out.println(link.getText());
        }

        // can you find only links that its size less than equal 12 ant count how many we have>

        int count =0;
        for(WebElement size: allLinks){
            if(size.getText().length()<=12) {
                System.out.println(size.getText());
                count++;
            }
        }
        System.out.println(count);

        WebElement abtesting= driver.findElement(By.linkText("A/B Testing"));
        System.out.println(abtesting.getText());



    }
}
