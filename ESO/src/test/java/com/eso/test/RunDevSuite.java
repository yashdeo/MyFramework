package com.eso.test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "./src/test/resources",tags = {"@regression"}, monochrome = true, plugin = {
        "pretty", "html:target/cucumber-report/",
        "json:target/cucumber-report/cucumber.json",
        "com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:target/html/ExtentReport.html"
},      glue = "com.eso.test")

public class RunDevSuite extends AbstractTestNGCucumberTests {
    }
