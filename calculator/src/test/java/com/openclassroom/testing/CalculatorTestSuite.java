package com.openclassroom.testing;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Suite with this class can we group tests together in an test.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses(value = {CalculatorTest.class, ConversionCaculatorTest.class})
public class CalculatorTestSuite {

}
