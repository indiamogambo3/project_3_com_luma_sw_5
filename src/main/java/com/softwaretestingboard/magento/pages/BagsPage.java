package com.softwaretestingboard.magento.pages;

import com.aventstack.extentreports.Status;
import com.softwaretestingboard.magento.customlisteners.CustomListeners;
import com.softwaretestingboard.magento.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class BagsPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Overnight Duffle')]")
    WebElement productDuffle;

    public void clickOnOvernightDuffle() {
        clickOnElement(productDuffle);
        Reporter.log("Click on overnight duffle bag" + productDuffle.toString());
        CustomListeners.test.log(Status.PASS, "Click on overnight duffle bag");
    }

}
