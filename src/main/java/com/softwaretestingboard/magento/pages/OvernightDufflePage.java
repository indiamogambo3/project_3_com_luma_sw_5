package com.softwaretestingboard.magento.pages;

import com.aventstack.extentreports.Status;
import com.softwaretestingboard.magento.customlisteners.CustomListeners;
import com.softwaretestingboard.magento.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class OvernightDufflePage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Overnight Duffle')]")
    WebElement overnightDuffle;
    @CacheLookup
    @FindBy(id = "qty")
    WebElement quantity;
    @CacheLookup
    @FindBy(id = "product-addtocart-button")
    WebElement addToCart;
    @CacheLookup
    @FindBy(xpath = "//div[@data-bind = 'html: $parent.prepareMessageForHtml(message.text)']")
    WebElement duffleBagAddedToShoppingCart;
    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'shopping cart')]")
    WebElement shoppingCartLink;

    public String verifyOvernightDuffleText() {
        Reporter.log("Verify overnight duffle text" + overnightDuffle.toString());
        CustomListeners.test.log(Status.PASS, "Verify overnight duffle text");
        return getTextFromElement(overnightDuffle);
    }

    public void clearQuantity() {
        driver.findElement(By.id("qty")).clear();
        Reporter.log("Clear quantity");
        CustomListeners.test.log(Status.PASS, "Clear quantity");
    }

    public void inputQuantity(String number) {
        sendTextToElement(quantity, number);
        Reporter.log("Input quantity" + number + "to email field" + quantity.toString());
        CustomListeners.test.log(Status.PASS, "Input quantity " + number);
    }

    public void clickOnAddToCartButton() {
        clickOnElement(addToCart);
        Reporter.log("Click on add to cart button" + addToCart.toString());
        CustomListeners.test.log(Status.PASS, "Click on add to cart button");
    }

    public String verifyDuffleBagAddedToCartText() {
        Reporter.log("Verify duffle bag added to cart text" + duffleBagAddedToShoppingCart.toString());
        CustomListeners.test.log(Status.PASS, "Verify duffle bag added to cart text");
        return getTextFromElement(duffleBagAddedToShoppingCart);
    }

    public void clickOnShoppingCartLinkInMessage() {
        clickOnElement(shoppingCartLink);
        Reporter.log("Click on shopping cart link in message" + shoppingCartLink.toString());
        CustomListeners.test.log(Status.PASS, "Click on shopping cart link in message");
    }

}
