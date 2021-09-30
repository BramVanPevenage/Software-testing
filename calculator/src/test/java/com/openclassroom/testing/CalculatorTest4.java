package com.openclassroom.testing;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * geschrevn in JUNIT 4
 */
public class CalculatorTest4 {
    Calculator calculator;

    //wordt voor elke test klasse uitgevoert in dit geval 4 keer.
    @Before
    public void initCalc(){
        calculator = new Calculator();
    }


    @Test
    public void add_shouldReturnTheSum_ofTwoNumbers(){

        //arange
        int expected = 3; // 1 + 2
        //act
        Integer actual = calculator.addTwoNumbers(1,2);
        //assert
        Assert.assertSame(expected, actual);
    }

    @Test
    public void retractingfromnumbers(){
        //argande
        int expected = 5; // 10 - 5 = 5
        //act
        int actual = calculator.subtractTwoNumbers(10,5);
        //assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void multiplyTwoNumbers(){
        //arange
        int expected = 49; // 7*7 = 49
        //act
        int actual = calculator.multiplyTwoNumbers(7,7);
        //assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void  divideTwoNumbers(){
        //arange
        int expected = 8; //64/8 = 8
        //act
        float actual = calculator.divideTwoNumbers(64,8);
        //assert
        Assert.assertEquals(expected, actual,0F);

        float actual2 = calculator.divideTwoNumbers(75,6);
        //assert
        Assert.assertEquals(12.5, actual2,1F);
    }

    //werken met exceptions -> UnsupportedOperationException
    @Test(expected = UnsupportedOperationException.class)
    public void cos(){
        calculator.cos(0.8);
    }
    //test will fail if the test takes to long
    @Test(timeout = 2000L)
    public void slowCalculation(){
        calculator.slowCalculation(2000L);
    }
    @Test
    @DisplayName("Power")
    public void powerOfNUmber(){
        //arange
        int expected = 9; // 3² = 9
        //act
        int actual = calculator.powerOfNumber(3);
        //assert
        Assert.assertEquals(expected,actual);
    }
}
