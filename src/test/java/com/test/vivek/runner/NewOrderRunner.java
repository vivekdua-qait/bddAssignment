package com.test.vivek.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions( monochrome = true,
        features = "src/test/resources/features/NewOrder.feature",
        glue = "com.test.vivek.stepdefinitions",
        plugin = {"pretty",
                "html:target/cucumber-report/cucumber-report.html",
                "json:target/cucumber-report/cucumber-report.json"}
)
public class NewOrderRunner extends AbstractTestNGCucumberTests {

}