package com.softwaretestingboard.magento.pages;

import com.aventstack.extentreports.Status;
import com.softwaretestingboard.magento.customlisteners.CustomListeners;
import com.softwaretestingboard.magento.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class HomePage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Women')]")
    WebElement hoverOnWomenMenu;
    @CacheLookup
    @FindBy(id = "ui-id-9")
    WebElement hoverOnTops;
    @CacheLookup
    @FindBy(id = "ui-id-11")
    WebElement jackets;
    @CacheLookup
    @FindBy(id = "ui-id-5")
    WebElement menMenu;
    @CacheLookup
    @FindBy(id = "ui-id-18")
    WebElement bottoms;
    @CacheLookup
    @FindBy(id = "ui-id-23")
    WebElement pants;
    @CacheLookup
    @FindBy(xpath = "//span[(text() = 'Gear')]")
    WebElement hoverOnGear;
    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Bags')]")
    WebElement selectBags;

    public void mouseHoverOnWomenMenu() {
        mouseHoverToElement(hoverOnWomenMenu);
        Reporter.log("Mouse hover on women menu" + hoverOnWomenMenu.toString());
        CustomListeners.test.log(Status.PASS, "Mouse hover on women menu");
    }

    public void mouseHoverOnTops() {
        mouseHoverToElement(hoverOnTops);
        Reporter.log("Mouse hover on tops" + hoverOnTops.toString());
        CustomListeners.test.log(Status.PASS, "Mouse hover on tops");
    }

    public void clickOnJackets() {
        clickOnElement(jackets);
        Reporter.log("Click on jackets" + jackets.toString());
        CustomListeners.test.log(Status.PASS, "Click on jackets");
    }

    public void mouseHoverOnMenMenu() {
        mouseHoverToElement(menMenu);
        Reporter.log("Mouse hover on men menu" + menMenu.toString());
        CustomListeners.test.log(Status.PASS, "Mouse hover on men menu");
    }

    public void mouseHoverOnBottoms() {
        mouseHoverToElement(bottoms);
        Reporter.log("Mouse hover on bottoms" + bottoms.toString());
        CustomListeners.test.log(Status.PASS, "Mouse hover on bottoms");
    }

    public void clickOnPants() {
        clickOnElement(pants);
        Reporter.log("Click on pants" + pants.toString());
        CustomListeners.test.log(Status.PASS, "Click on pants");
    }

    public void mouseHoverOnGearMenu() {
        mouseHoverToElement(hoverOnGear);
        Reporter.log("Mouse hover on gear menu" + hoverOnGear.toString());
        CustomListeners.test.log(Status.PASS, "Mouse hover on gear menu");
    }

    public void clickOnBags() {
        clickOnElement(selectBags);
        Reporter.log("Click on bags" + selectBags.toString());
        CustomListeners.test.log(Status.PASS, "Click on bags");
    }

}
