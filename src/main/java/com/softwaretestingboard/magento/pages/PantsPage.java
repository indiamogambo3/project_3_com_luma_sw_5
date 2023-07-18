package com.softwaretestingboard.magento.pages;

import com.aventstack.extentreports.Status;
import com.softwaretestingboard.magento.customlisteners.CustomListeners;
import com.softwaretestingboard.magento.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class PantsPage extends Utility {

    @CacheLookup
    @FindBy(id = "option-label-size-143-item-175")
    WebElement size32;
    @CacheLookup
    @FindBy(id = "option-label-color-93-item-49")
    WebElement colorBlack;
    @CacheLookup
    @FindBy(xpath = "//li[1]/div[1]/div[1]/div[3]/div[1]/div[1]/form[1]/button[1]/span[1]")
    WebElement addToCart;
    @CacheLookup
    @FindBy(xpath = "//div[@data-bind = 'html: $parent.prepareMessageForHtml(message.text)']")
    WebElement verifyAddedToCart;
    @CacheLookup
    @FindBy(xpath = "//a[(text() = 'shopping cart')]")
    WebElement clickOnCartInMessage;

    public void mouseHoverAndClickOnSize32() {
        mouseHoverToElementAndClick(size32);
        Reporter.log("Mouse hover and click on size 32" + size32.toString());
        CustomListeners.test.log(Status.PASS, "Mouse hover and click on size 32");
    }

    public void mouseHoverAndClickOnBlack() {
        mouseHoverToElementAndClick(colorBlack);
        Reporter.log("Mouse hover and click on colour black" + colorBlack.toString());
        CustomListeners.test.log(Status.PASS, "Mouse hover and click on colour black");
    }

    public void mouseHoverAndClickOnAddToCartButton() {
        mouseHoverToElementAndClick(addToCart);
        Reporter.log("Mouse hover and click on add to cart button" + addToCart.toString());
        CustomListeners.test.log(Status.PASS, "Mouse hover and click on add to cart button");
    }

    public String verifyAddedToCartText() {
        Reporter.log("Verify added to cart" + verifyAddedToCart.toString());
        CustomListeners.test.log(Status.PASS, "Verify added to cart");
        return getTextFromElement(verifyAddedToCart);
    }

    public void clickOnShoppingCartInMessage() {
        clickOnElement(clickOnCartInMessage);
        Reporter.log("Click on shopping cart in message" + clickOnCartInMessage.toString());
        CustomListeners.test.log(Status.PASS, "Click on shopping cart in message");
    }

}
