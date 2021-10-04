package com.openclassroom.testing;

/*
 * Written in JUNIT 4
 */

import com.openclassroom.testing.service.ConversionCalculator;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test written to test the ConversionCalculator class
 */
@Category(TestCategories.ConversionTests.class)
//to run the static inner classes
@RunWith(Enclosed.class)
public class ConversionCalculatorTest4 {

    private static ConversionCalculator _cCalculator;

    @Before
    public void initCalc(){
        _cCalculator = new ConversionCalculator();
    }

    @Category(TestCategories.TemperatureTests.class)

    static class  TemperatureTests {
        @Test
        public void celToFar(){
            int expected = 32;
            double actual = _cCalculator.celsiusToFahrenheit(0.0);
            assertEquals(expected, actual);
        }
        @Test
        public void farToCel(){
            int expected = 0;
            double actual = _cCalculator.fahrenheitToCelsius(32.0);
            assertEquals(expected, actual);
        }
    }
    @Category(TestCategories.VolumeTests.class)
    static class VolumeTests{
        @Test
        public void liToGal(){
            double expected = 6.0;
            double actual = _cCalculator.litresToGallons(20.0);
            assertEquals(expected, actual);
        }
        @Test
        public void galToLi(){
            int expected = 20;
            double actual = _cCalculator.gallonsToLiters(5.28344);
            assertEquals(expected, actual);
        }
    }

    /**
     * JUnit 4 works withj categories to group tests
     */
    @Test
    @Category(TestCategories.CircleAreaTests.class)
    public void radiusToAreaOfCircle(){
        double expected = 452.3893421169302;
        double actual = _cCalculator.radiusToAreaOfCircle(12.0);
        assertEquals(expected, actual);
    }
}
