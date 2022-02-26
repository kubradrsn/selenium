package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice1 {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/horizontal_slider");
        WebElement title = driver.findElement(By.xpath("//h3"));
        System.out.println(title.getText());

        WebElement paragraph = driver.findElement(By.xpath("//h4[@class= 'subheader']"));
        System.out.println(paragraph.getText());

        /*
        CONTAINS: its work will text
        tagname [contains(text(),'HorizontalLine')]// 60
         */

        WebElement containsmethod = driver.findElement(By.xpath("//h3[contains(text(),'Horizontal Slider')]"));
        System.out.println(containsmethod.getText());

        /*
        Test : it works with text as well. this is for simplier that contains method.
         */


    }
}
