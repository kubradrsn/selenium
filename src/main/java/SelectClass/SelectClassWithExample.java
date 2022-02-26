package SelectClass;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SelectClassWithExample {

  @Test
     public void ValidationTripButton(){
      WebDriverManager.chromedriver().setup();// please get used to this process
      WebDriver driver = new ChromeDriver();
      driver.get("https://demo.guru99.com/test/newtours/reservation.php");

      WebElement onewayButton = driver.findElement(By.xpath("//input[@value='oneway']"));
      onewayButton.click();


      Assert.assertTrue(onewayButton.isDisplayed()); // it must be true to pass the assertion
      Assert.assertTrue(onewayButton.isSelected());

      WebElement roundTripButton = driver.findElement(By.xpath("//input[@value='roundtrip']"));
      Assert.assertTrue(roundTripButton.isDisplayed()); // it must be true to pass the assertion
      Assert.assertTrue(roundTripButton.isSelected());
  }

  @Test
    public void SelectMethod() throws InterruptedException {

      WebDriverManager.chromedriver().setup();// please get used to this process
      WebDriver driver = new ChromeDriver();
      driver.get("https://demo.guru99.com/test/newtours/reservation.php");

      WebElement onewayButton = driver.findElement(By.xpath("//input[@value='oneway']"));
      onewayButton.click();

      WebElement passengerCount = driver.findElement(By.name("passCount"));

      Thread.sleep(1000);

      Select psnger = new Select(passengerCount);
      psnger.selectByIndex(1);

      Thread.sleep(1000);

      WebElement departfrom = driver.findElement(By.name("fromPort"));
      Select depart= new Select(departfrom);
      depart.selectByValue("Sydney");

      Thread.sleep(1000);

      WebElement month = driver.findElement(By.name("fromMonth"));
      Select mnth = new Select(month);
      mnth.selectByVisibleText("April");

      Thread.sleep(1000);


      WebElement fromDay = driver.findElement(By.name("fromDay"));
      Select frmday = new Select(fromDay);
      frmday.selectByIndex(19);

      Thread.sleep(1000);


      WebElement arriving = driver.findElement(By.name("toPort"));
      Select arrvg = new Select(arriving);
      arrvg.selectByValue("Paris");

      Thread.sleep(1000);


      WebElement Returning = driver.findElement(By.name("toMonth"));
      Select rtrn = new Select(Returning);
      rtrn.selectByVisibleText("May");

      Thread.sleep(1000);

      WebElement toReturning = driver.findElement(By.name("toDay"));
      Select tortrn = new Select(toReturning);
      tortrn.selectByIndex(25);

      Thread.sleep(1000);



     //WebElement FirstClass = driver.findElement(By.xpath("//input[@type='radio']"));
     //FirstClass.click();

      //Thread.sleep(1000);

//      WebElement airline = driver.findElement(By.name("Airline"));
//      Select airlne =new Select(airline);
//      airlne.selectByValue("Unified Airlines");
//
//      Thread.sleep(1000);
//
//
//      WebElement Continue = driver.findElement(By.name("continue"));
//      Select cntn = new Select(Continue);
//      cntn.selectByValue("findFlights");
//
//      Thread.sleep(1000);

  }




  @Test
  public void SecondWay(){
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    driver.get("https://demo.guru99.com/test/newtours/reservation.php");
    driver.manage().window().maximize();


    WebElement trip = driver.findElement(By.xpath("//input[@value='oneway']"));
    trip.click();

    WebElement passenger = driver.findElement(By.name("passCount"));
    BrowserUtils.selectBy(passenger,"2","value");


    WebElement departingFrom = driver.findElement(By.name("fromPort"));
    BrowserUtils.selectBy(departingFrom,"Paris","text");
//        Select depart = new Select(departingFrom);
//        depart.selectByVisibleText("Paris");


    WebElement frommonth = driver.findElement(By.name("fromMonth"));
    BrowserUtils.selectBy(frommonth,"7","index");
    //Select month = new Select(frommonth);
    //month.selectByIndex(7);


    WebElement fromday = driver.findElement(By.name("fromDay"));
    BrowserUtils.selectBy(fromday,"13","Value");
    //Select day = new Select(fromday);
    //day.selectByValue("13");


    WebElement arrivingIn = driver.findElement(By.name("toPort"));
    BrowserUtils.selectBy(arrivingIn,"Sydney","Text");
    //Select arriving = new Select(arrivingIn);
    //arriving.selectByVisibleText("Sydney");


    WebElement tomonth = driver.findElement(By.name("toMonth"));
    BrowserUtils.selectBy(tomonth,"9","index");

//    Select toomonth = new Select(tomonth);
//    toomonth.selectByIndex(9);


    WebElement toDay = driver.findElement(By.name("toDay"));
    BrowserUtils.selectBy(toDay,"3","value");
//    Select tooDay = new Select(toDay);
//    tooDay.selectByValue("3");


    WebElement Services = driver.findElement(By.xpath("//input[@value='First']"));
    Services.click();

    WebElement airlines = driver.findElement(By.name("airline"));
    Select airline = new Select(airlines);

    List<WebElement> allairlines = airline.getOptions();

    List<String> actualAirlines = Arrays.asList("No Preference", "Blue Skies Airlines", "Unified Airlines", "Pangea Airlines");

    List<String> expectedairlines = new ArrayList<>();

    for (WebElement line : allairlines) {
      expectedairlines.add(line.getText().trim());
    }

    Assert.assertEquals(actualAirlines, expectedairlines);
    WebElement continueButton = driver.findElement(By.name("findFlights"));
    continueButton.click();


    WebElement message = driver.findElement(By.xpath("//font[@face='Arial, Helvetica, sans-serif']//font[@size='4']"));
    String actual = message.getText().trim();

    String expected = "After flight finder - No Seats Available";
    Assert.assertEquals(actual, expected);
  }
}


