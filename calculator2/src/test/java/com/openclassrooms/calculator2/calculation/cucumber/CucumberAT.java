package com.openclassrooms.calculator2.calculation.cucumber;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", plugin = {"pretty", "html:target/html-cucumber-report"})

public class CucumberAT {

}
