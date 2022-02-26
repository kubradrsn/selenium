package Utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Set;

public class BrowserUtils {

    public static void  selectBy(WebElement element,String value, String methodName){
        Select select = new Select(element);

        switch (methodName){

            case "text":
                select.selectByVisibleText(value);
                break;

            case "index":
                select.selectByIndex(Integer.parseInt(value));
                break;

            case "value":
                select.selectByValue(value);
                break;

            default:
                System.out.println("Method name is not available , use text value, or index for method name");

        }
    }


    public static  String getTextMethod(WebElement element){

        return element.getText().trim();

    }


    public static  String GetTitleWithJS(WebDriver driver){
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        String title = javascriptExecutor.executeScript("return document.title").toString();
        return title;

    }

    public  static  void ClickWithJS(WebDriver driver ,WebElement element){
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].click()",element);


    }


    public static void ScrollWithJS(WebDriver driver , WebElement element ){
        JavascriptExecutor js = (JavascriptExecutor) driver ;
        js.executeScript("arguments[0].browseCourse(true)",element);

    }


    public static void ScrollWithXandYCordinantTest(WebDriver driver , WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver ;

        Point location = element.getLocation();

//        System.out.println(location.getX());
//        System.out.println(location.getY());

        int xCord = location.getX();
        int yCord = location.getY();

        js.executeScript("window.scrollTo("+xCord+","+yCord+")");

    }


    public static void SwitchOnlyFor2Tabs(WebDriver driver, String mainPageId){
        Set<String> allPagesId = driver.getWindowHandles();

        for (String id :allPagesId){
            if (!id.equals(mainPageId)){
                driver.switchTo().window(id);
            }
        }

    }


    // in real work this will help you a lot once you test different tabs or windows:

    public static void switchByTitle(WebDriver driver , String title){
        Set<String>allPagesId = driver.getWindowHandles();

        for (String id :allPagesId){
            driver.switchTo().window(id);
            if (driver.getTitle().contains(title)){
                break;
            }
        }
    }

}
