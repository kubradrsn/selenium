package TestTNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGAssertion {

    //create one method that takes two parameter and return the multiplication of these numbers

    public double getMulti(double number1 , double number2){
        return number1*number2;

    }



    @Test
    public  void validateMultiplications(){
        double ActualResult = getMulti(5,6);
        double ExpectedResult =30 ;

//        if (ActualResult==ExpectedResult){
//            System.out.println("passed");
//        }

        // it is going to show up it fails (massage)
        Assert.assertEquals(ActualResult,ExpectedResult,"my number are 5 and 6 ");


    }

    public double getDivision (double number1, double number2){
        if (number1>=number2){
            return  number1/number2;
        }
        return number2/number1;
    }

    public int substraction(int number1, int number2){
        if (number1>=number2){
            return  number1-number2;
        }
        return number2-number1;
    }

    @Test
    public void validateDivision(){
        double actualResult = getDivision(8,2);
        double expectResult = 4;
        Assert.assertEquals(actualResult,expectResult);
    }

@Test
    public void validateSubstraction(){
        int actualResult = substraction(65,43);
        int expectResult =22;
        Assert.assertEquals(actualResult,expectResult);
}


}
