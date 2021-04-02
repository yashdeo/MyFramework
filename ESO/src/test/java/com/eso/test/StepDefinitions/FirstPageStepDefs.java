package com.eso.test.StepDefinitions;

import com.eso.test.framework.Helpers.BuilderURL;
import com.eso.test.framework.hooks.Screenshot.SetBrowser;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;


import java.io.IOException;

public class FirstPageStepDefs {
    BuilderURL builderURL;

    public FirstPageStepDefs(BuilderURL builderURL) throws IOException {
        this.builderURL = builderURL;
    }

    @Given("^User is on the home page$")
    public void User_is_on_the_home_page() throws Throwable {
        SetBrowser.openURL();
    }

}
