package com.softwaretestingboard.magento.pages;

import com.aventstack.extentreports.Status;
import com.softwaretestingboard.magento.customlisteners.CustomListeners;
import com.softwaretestingboard.magento.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class ShoppingCartPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//span[@class = 'base']")
    WebElement shoppingCartText;
    @CacheLookup
    @FindBy(xpath = "//td[1]/div[1]/strong[1]/a[1]")
    WebElement productName;
    @CacheLookup
    @FindBy(xpath = "//dd[contains(text(),'32')]")
    WebElement size32;
    @CacheLookup
    @FindBy(xpath = "//dd[contains(text(),'Black')]")
    WebElement colourBlack;
    @CacheLookup
    @FindBy(xpath = "/div[@class = 'control qty']//input[@type= 'number']")
    WebElement totalQuantity;
    @CacheLookup
    @FindBy(xpath = "//body[1]/div[1]/main[1]/div[3]/div[1]/div[2]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[4]/span[1]/span[1]/span[1]")
    WebElement totalPrice;
    @CacheLookup
    @FindBy(xpath = "//body[1]/div[1]/main[1]/div[3]/div[1]/div[2]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[3]/div[1]/div[1]/label[1]/input[1]")
    WebElement quantity;
    @CacheLookup
    @FindBy(xpath = "//button[@class = 'action update']")
    WebElement updateCart;
    @CacheLookup
    @FindBy(xpath = "//tbody/tr[1]/td[4]/span[1]/span[1]/span[1]")
    WebElement updateTotal;

    public String verifyShoppingCartText() {
        Reporter.log("Verify shopping cart text" + shoppingCartText.toString());
        CustomListeners.test.log(Status.PASS, "Verify shopping cart text");
        return getTextFromElement(shoppingCartText);
    }

    public String verifyProductName() {
        Reporter.log("Verify product name" + productName.toString());
        CustomListeners.test.log(Status.PASS, "Verify product name");
        return getTextFromElement(productName);
    }

    public String verifyProductSize32() {
        Reporter.log("Verify product size 32" + size32.toString());
        CustomListeners.test.log(Status.PASS, "Verify product size 32");
        return getTextFromElement(size32);
    }

    public String verifyColourBlack() {
        Reporter.log("Verify colour black" + colourBlack.toString());
        CustomListeners.test.log(Status.PASS, "Verify colour black");
        return getTextFromElement(colourBlack);
    }

    public String verifyTotalPrice() {
        Reporter.log("Verify total price" + totalPrice.toString());
        CustomListeners.test.log(Status.PASS, "Verify total price");
        return getTextFromElement(totalPrice);
    }

    public void clearQuantity() {
        Reporter.log("Clear quantity");
        CustomListeners.test.log(Status.PASS, "Clear quantity");
        driver.findElement(By.xpath("//body[1]/div[1]/main[1]/div[3]/div[1]/div[2]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[3]/div[1]/div[1]/label[1]/input[1]")).clear();
    }

    public void inputQuantity(String number) {
        Reporter.log("Input quantity" + quantity.toString());
        CustomListeners.test.log(Status.PASS, "Input quantity");
        sendTextToElement(quantity, number);
    }

    public void clickOnUpdateShoppingCartButton() {
        Reporter.log("Click on update shopping cart button" + updateCart.toString());
        CustomListeners.test.log(Status.PASS, "Click on update shopping cart button");
        clickOnElement(updateCart);
    }

    public String verifyTotal() {
        Reporter.log("Verify updated total" + updateTotal.toString());
        CustomListeners.test.log(Status.PASS, "Verify updated total");
        return getTextFromElement(updateTotal);
    }

}
