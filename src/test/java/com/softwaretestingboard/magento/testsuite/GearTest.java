package com.softwaretestingboard.magento.testsuite;

import com.softwaretestingboard.magento.customlisteners.CustomListeners;
import com.softwaretestingboard.magento.pages.BagsPage;
import com.softwaretestingboard.magento.pages.HomePage;
import com.softwaretestingboard.magento.pages.OvernightDufflePage;
import com.softwaretestingboard.magento.pages.ShoppingCartPage;
import com.softwaretestingboard.magento.testbase.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Listeners(CustomListeners.class)

public class GearTest extends BaseTest {

    HomePage homePage;
    BagsPage bagsPage;
    OvernightDufflePage overnightDufflePage;
    ShoppingCartPage shoppingCartPage;

    @BeforeMethod
    public void inIt() {

        homePage = new HomePage();
        bagsPage = new BagsPage();
        overnightDufflePage = new OvernightDufflePage();
        shoppingCartPage = new ShoppingCartPage();
    }

    @Test(groups = {"sanity", "regression"})
    public void userShouldAddProductSuccessFullyToShoppingCart() throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();

        //* Mouse Hover on Gear Menu
        Thread.sleep(2000);
        homePage.mouseHoverOnGearMenu();
        //* Click on Bags
        homePage.clickOnBags();
        //* Click on Product Name ‘Overnight Duffle’
        bagsPage.clickOnOvernightDuffle();
        //* Verify the text ‘Overnight Duffle’
        softAssert.assertEquals(overnightDufflePage.verifyOvernightDuffleText(), "Overnight Duffle", "Unable to verify text.");
        //* Change Qty 3
        overnightDufflePage.clearQuantity();
        overnightDufflePage.inputQuantity("3");
        //* Click on ‘Add to Cart’ Button.
        overnightDufflePage.clickOnAddToCartButton();
        //* Verify the text ‘You added Overnight Duffle to your shopping cart.’
        softAssert.assertEquals(overnightDufflePage.verifyDuffleBagAddedToCartText(), "You added Overnight Duffle to your shopping cart.", "Unable to verify text.");
        //* Click on ‘shopping cart’ Link into message
        overnightDufflePage.clickOnShoppingCartLinkInMessage();
        //* Verify the product name ‘Cronus Yoga Pant’
        softAssert.assertEquals(shoppingCartPage.verifyProductName(), "Overnight Duffle", "Unable to verify name.");
        //* Verify the Qty is ‘3’
        String actualQuantity = driver.findElement(By.xpath("//div[@class = 'control qty']//input[@type= 'number']")).getAttribute("value");
        softAssert.assertEquals(actualQuantity, "3", "Unable to verify quantity.");
        //* Verify the product price ‘$135.00’
        softAssert.assertEquals(shoppingCartPage.verifyTotalPrice(), "$135.00", "Unable to verify price.");
        //* Change Qty to ‘5’
        shoppingCartPage.clearQuantity();
        shoppingCartPage.inputQuantity("5");
        //* Click on ‘Update Shopping Cart’ button
        shoppingCartPage.clickOnUpdateShoppingCartButton();
        //* Verify the product price ‘$225.00’
        Thread.sleep(2000);
        softAssert.assertEquals(shoppingCartPage.verifyTotal(), "$225.00", "Unable to verify price.");
        softAssert.assertAll();
    }

}
