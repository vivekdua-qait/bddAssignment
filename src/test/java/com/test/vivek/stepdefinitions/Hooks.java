package com.test.vivek.stepdefinitions;

import com.test.vivek.TestSessionInitiator;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.io.IOException;

public class Hooks {

    private TestDependencyInjector testinjector;
    private TestSessionInitiator test;

    public Hooks(TestDependencyInjector testinjector){
        this.testinjector = testinjector;
    }

    @Before()
    public void startTest() throws IOException {
        this.testinjector.test = new TestSessionInitiator("CukeTest");
        test = this.testinjector.test;
    }

    @After()
    public void closeBrowser(Scenario s) {
        test.closeTestSession();
    }
}
