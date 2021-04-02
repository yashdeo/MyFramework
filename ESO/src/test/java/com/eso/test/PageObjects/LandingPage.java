package com.eso.test.PageObjects;

import com.eso.test.framework.CommonMethods.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class LandingPage extends CommonMethods {

    public LandingPage() {
        PageFactory.initElements(webDriver, this);
    }

    //Elements needs to be identified using CSSSelectors

    @FindBy(css = "div[class='search-row'] input[id='query']")
    private WebElement searchBox;

    @FindBy(css = "a[class='suggestions-location']")
    private WebElement myLocation;

    @FindBy(css = "button[class='btn btn-red btn-buy']")
    private WebElement forSaleButton;

    @FindBy(css = "button[class='btn btn-red btn-rent']")
    private WebElement forRentButton;

    @FindBy(css = "div[class='mainnav-menu'] a[class*='is-active']")
    private WebElement activeMenuName;

    @FindBy(css = "p[class='noresults-intro']")
    private WebElement messageNoResultsFound;

    @FindBy(css = "div > h1")
    private WebElement searchCriteria;

    @FindBy(css = "span[class='propbox-town'] span[class='text-ib']")
    private WebElement postcodeInAddress;

    @FindBy(css = "div[class='propbox-details'] span[class='propbox-town']")
    private List<WebElement> propertyListings;

    @FindBy(css="h1[class='noresults-heading']")
    private WebElement msgNoResultsFound;

    @FindBy(css="input[value='My Location']")
    private WebElement mySearchLocation;

    @FindBy(css="button[mode='primary']")
    private WebElement acceptCookies;

    // Page specific methods and calling the common methods prent in the Common methods class

    public void searchUsingText(String searchCriteria) {
        searchBox.sendKeys(searchCriteria);
    }

    public void clickInTheSearchBox() {
        waitTillElementVisible(acceptCookies).click();
        waitTillElementVisible(searchBox);
        searchBox.click();
    }

    public void clickButtonSale_Rent(String buttonPurpose) {
        if (buttonPurpose.contains("FOR SALE")) {
            forSaleButton.click();
        } else {
            forRentButton.click();
        }
    }

    public boolean properties_containts_search_criteria(String searchCriteria) {
        return propertyListings.get(0).getText().contains(searchCriteria);
    }

    public String selectedMenu() {
        return waitTillElementVisible(activeMenuName).getAttribute("data-section");
    }

    public boolean searchCriteriaTextIsInString(String searchString){
       return waitTillElementVisible(searchCriteria).getText().contains(searchString);
    }

    public void selectMyLocation(){waitTillElementVisible(myLocation).click();}

    public String noPropertiesFound(){
        return waitTillElementVisible(msgNoResultsFound).getText();
    }

    public boolean ifMyLocationPageDisplays(){
        return mySearchLocation.isDisplayed();
    }
}
