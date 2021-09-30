package com.openclassroom.testing;


import org.junit.jupiter.api.*;
import java.time.Duration;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

/**
 * geschreven in JUnit 5
 */
public class CalculatorTest {

    static Calculator calculator;
    static Instant startTime;

    //gebeurt voor alle test klassen -> meestal gebeurt hier de setup in
    @BeforeAll
    public static void initCalc(){
        calculator = new Calculator();
        startTime = Instant.now();
    }

    //region pure JUnit
    @Test
    public void add_shouldReturnTheSum_ofTwoNumbers(){

        //arange
        int expected = 3; // 1 + 2
        //act
        Integer actual = calculator.addTwoNumbers(1,2);
        //assert
        assertSame(expected, actual);
    }

    @Test
    public void retractingfromnumbers(){
        //argande
        int expected = 5; // 10 - 5 = 5
        //act
        int actual = calculator.subtractTwoNumbers(10,5);
        //assert
        assertEquals(expected, actual);
    }

    @Test
    public void multiplyTwoNumbers(){
        //arange
        int expected = 49; // 7*7 = 49
        //act
        int actual = calculator.multiplyTwoNumbers(7,7);
        //assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Divide")
    public void  divideTwoNumbers(){
        //arange
        int expected = 8; //64/8 = 8
        //act
        float actual = calculator.divideTwoNumbers(64,8);
        //assert
        assertEquals(expected, actual,0F);

        float actual2 = calculator.divideTwoNumbers(75,6);
        //assert
        assertEquals(12.5, actual2,1F);
    }
    //enkel na alle test klassen afgewerkt zijn -> mmestalk gebeurt hier de opkuis van de testen in verwerkt.
    @AfterAll
    public static void printTime(){
        Instant endtime = Instant.now();
        Duration duration = Duration.between(startTime, endtime);
        System.out.println("Test duration: "+duration.toMillis()+"ms");
    }

    //werken met exceptions -> UnsupportedOperationException
    @Test()
    public void cos(){

        Assertions.assertThrows(UnsupportedOperationException.class, () ->{
            calculator.cos(0.8);
        });
    }

    //test will fail if the test takes to long
    @Test()
    @Timeout(2) //timeout in seconds
    public void slowCalculation(){
        calculator.slowCalculation(300L);
    }
    //endregion


    //region JUnit + Hamcrest
    @Test
    @DisplayName("Power")
    public void powerOfNUmber(){
        //arange
        int expected = 9; // 3² = 9
        //act
        int actual = calculator.powerOfNumber(3);
        //assert
        assertEquals(expected,actual);
    }
    //endregion
}


