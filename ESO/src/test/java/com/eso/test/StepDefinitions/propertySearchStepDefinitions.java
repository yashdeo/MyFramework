package com.eso.test.StepDefinitions;

import com.eso.test.PageObjects.LandingPage;
import com.eso.test.PageObjects.NewHomesPage;
import com.eso.test.framework.Helpers.BuilderURL;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

public class propertySearchStepDefinitions {

    private LandingPage landingPage;
    private NewHomesPage newHomesPage;

    private String buttonPurpose;
    private String searchText;

    public propertySearchStepDefinitions(LandingPage landingPage,BuilderURL builderURL,NewHomesPage newHomesPage){
        this.landingPage = landingPage;
        this.newHomesPage = newHomesPage;
    }

    @When("^user clicks on search area$")
    public void user_clicks_on_search_area() throws Throwable {
       landingPage.clickInTheSearchBox();
    }

    @When("^clicks on My Location icon$")
    public void clicks_on_My_Location_icon() throws Throwable {
        landingPage.selectMyLocation();
        searchText = "My Location";
    }

    @Then("^the search criteria should start populating in the Search box$")
    public void the_search_criteria_should_start_populating_in_the_Search_box() throws Throwable {

    }

    @When("^clicks on button \"([^\"]*)\"$")
    public void clicks_on_button(String buttonPurpose) throws Throwable {
        this.buttonPurpose = buttonPurpose;
        landingPage.clickButtonSale_Rent(buttonPurpose);
    }

    @Then("^the matching records should start populating on the page$")
    public void the_matching_records_should_start_populating_on_the_page() throws Throwable {
       /*
       1. Asserting that correct menu has selected
       2. Mentioned search criteria has present on the page
       3.

        */
      //  Assert.assertTrue(buttonPurpose.toUpperCase().contains(landingPage.selectedMenu()));
        Assert.assertTrue(landingPage.searchCriteriaTextIsInString(searchText));
        Assert.assertTrue(landingPage.properties_containts_search_criteria(searchText));

    }

    @When("^enters the search criteria as \"([^\"]*)\" in the searchbox$")
    public void enters_the_search_criteria_as_in_the_searchbox(String searchText) throws Throwable {
        this.searchText = searchText;
        landingPage.searchUsingText(searchText);
    }

    @Then("^no records should be found for the incorrect search$")
    public void no_records_should_be_found_for_the_incorrect_search() throws Throwable {
        Assert.assertTrue(landingPage.noPropertiesFound().toUpperCase().contains("SORRY, NO PROPERTIES FOUND"));
    }

    @Then("^the matching records should start populating on the page for My Location$")
    public void theMatchingRecordsShouldStartPopulatingOnThePageForMyLocation() {
        Assert.assertTrue(landingPage.ifMyLocationPageDisplays());
    }

    @And("^user clicks on the new homes$")
    public void userClicksOnTheNewHomes() {
        newHomesPage.clickNewProperty();
    }
}
