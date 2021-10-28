package com.openclassrooms.calculator2.calculation;


import com.openclassrooms.calculator2.domain.Calculator;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The tests to test the basic calculation method of the class Calculator
 * The basic calculation includes follwing operations:
 *
 *  - addition
 *  - subtraction
 *  - division
 *  - multiplication
 */
@Tag("BasicCalculationTests")
public class BasicCalculationTests {
    private static Calculator _calculator;
    @BeforeAll
    public static void setUp(){
        _calculator = new Calculator();
    }

    @Nested
    @Tag("AddingNumbers")
    @DisplayName("We should be able to add 2 number with each other")
    class AdditionTest{
        @Test
        @DisplayName("Adding two positive numbers, Given '1' and '2', expected result '3'")
        public void addPositiveNumers(){
            int expected = 3;
            int actual = _calculator.add(1,2);
            assertEquals(expected, actual);
        }
        @Test
        @DisplayName("Adding two nevative numbers, Given '-1' and '-2', expected result '-3'")
        public void addPNegativeNumers(){
            int expected = -3;
            int actual = _calculator.add(-1,-2);
            assertEquals(expected, actual);
        }
    }

    @Tag("SubtractingNumbers")
    @Nested
    @DisplayName("We should be albe to subtract a number from another number")
    class SubtractionTest{
        @Test
        @DisplayName("Subtracting two positive numbers, Given '12' and '8', expected result '4'")
        public void subtractPositiveNumers(){

        }
    }
}
