package com.openclassroom.testing;

import com.openclassroom.testing.service.ConversionCalculator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;

import static org.junit.jupiter.api.Assertions.assertEquals;



/*
 * Written in JUNIT 5
 */

/**
 * Unit test written to test the ConversionCalculator class
 */
@Tag("ConversionTests")
public class ConversionCaculatorTest {

    private static ConversionCalculator _cCalculator;

    /**
     * Initting an conversion calculator object before the test wil run
     */
    @BeforeAll
    public static void setUp(){
        _cCalculator = new ConversionCalculator();
    }

    @Nested
    @Tag("TemperatureTests")
    @DisplayName("We should be able to convert between different temperature units")
    class TemperatureTests {
        @Test
        @Tag("FahrenheitTests")
        @DisplayName("Converting Celsius to Fahrenheit, Given '0' degree Celsius, expected result in Fahrenheit '32.0' degree ")
        public void celToFar(){
            int expected = 32;
            double actual = _cCalculator.celsiusToFahrenheit(0.0);
            assertEquals(expected, actual);
        }
        @Tag("CelsiusTests")
        @DisplayName("Converting Fahrenheit to Celsius, Given '32' degree Fahrenheit, expected result in Celsius '0.0' degree ")
        @Test
        public void farToCel(){
            int expected = 0;
            double actual = _cCalculator.fahrenheitToCelsius(32.0);
            assertEquals(expected, actual);
        }
    }
    @Nested
    @Tag("VolumeTests")
    @DisplayName("We should be able to convert volumes to and from different units")
    class VolumeTests{
        @Test
        @Tag("GallonsTests")
        @DisplayName("Converting Litre to Gallon, Given '20' litre, expected result in Gallons '6.0' ")
        public void liToGal(){
            double expected = 6.0;
            double actual = _cCalculator.litresToGallons(20.0);
            assertEquals(expected, actual);
        }
        @Test
        @Tag("LiterTests")
        @DisplayName("Converting Gallon to Litre, Given '5.28344' Gallon, expected result in Litre '20.0' ")
        public void galToLi(){
            int expected = 20;
            double actual = _cCalculator.gallonsToLiters(5.28344);
            assertEquals(expected, actual);
        }
    }

    /**
     * I JUnit 5 we can work with tags an DisplayName to group and name the tests.
     */
    @Test
    @Tag("AreaOfCircleTest")
    @DisplayName("Giving an radius of '12', expected value is the area of an circle in this case '452.3893421169302'")
    public void radiusToAreaOfCircle(){
        double expected = 452.3893421169302;
        double actual = _cCalculator.radiusToAreaOfCircle(12.0);
        assertEquals(expected, actual);
    }
}
