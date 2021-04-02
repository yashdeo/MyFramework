package com.eso.test.PageObjects;

import com.eso.test.framework.CommonMethods.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewHomesPage extends CommonMethods {
    public NewHomesPage(){
        PageFactory.initElements(webDriver,this);
    }

    @FindBy(css = "div[class='mainnav-menu'] a[href*='new-homes']")
    private WebElement newProperty;

    public void clickNewProperty(){
        System.out.println("YESSSSS");
        waitTillElementVisible(newProperty).click();
    }
}
