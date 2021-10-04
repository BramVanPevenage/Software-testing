package com.openclassroom.testing;

/*
 * Needed for JUnit 4 where we work with the @Category annotation this annotation needs real classes or
 * interfaces to categorize tests.
 * In JUnit 5 we work with the @Tag annotation this annotation doesn't need real classes or interfaces.
 */
public interface TestCategories {
    interface CalculatorTests {}
    interface TemperatureTests {}
    interface FahrenheitTests {}
    interface ConversionTests {}
    interface CircleAreaTests {}
    interface VolumeTests {}
}
