package com.softwaretestingboard.magento.testsuite;

import com.softwaretestingboard.magento.customlisteners.CustomListeners;
import com.softwaretestingboard.magento.pages.HomePage;
import com.softwaretestingboard.magento.pages.PantsPage;
import com.softwaretestingboard.magento.pages.ShoppingCartPage;
import com.softwaretestingboard.magento.testbase.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Listeners(CustomListeners.class)

public class MensTest extends BaseTest {

    HomePage homePage;
    PantsPage pantsPage;
    ShoppingCartPage shoppingCartPage;

    @BeforeMethod
    public void inIt() {

        homePage = new HomePage();
        pantsPage = new PantsPage();
        shoppingCartPage = new ShoppingCartPage();
    }

    @Test(groups = {"sanity", "regression"})
    public void userShouldAddProductSuccessFullyToShoppingCart() throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();

        //* Mouse Hover on Men Menu
        Thread.sleep(2000);
        homePage.mouseHoverOnMenMenu();
        //* Mouse Hover on Bottoms
        homePage.mouseHoverOnBottoms();
        //* Click on Pants
        homePage.clickOnPants();
        //‘Cronus Yoga Pant’ and click on size 32.
        pantsPage.mouseHoverAndClickOnSize32();
        //* Mouse Hover on product name ‘Cronus Yoga Pant’ and click on colour Black.
        pantsPage.mouseHoverAndClickOnBlack();
        //* Mouse Hover on product name ‘Cronus Yoga Pant’ and click on ‘Add To Cart’ Button.
        Thread.sleep(2000);
        pantsPage.mouseHoverAndClickOnAddToCartButton();
        //* Verify the text ‘You added Cronus Yoga Pant to your shopping cart.’
        softAssert.assertEquals(pantsPage.verifyAddedToCartText(), "You added Cronus Yoga Pant to your shopping cart.", "Unable to verify text.");
        //* Click on ‘shopping cart’ Link into message
        pantsPage.clickOnShoppingCartInMessage();
        //* Verify the text ‘Shopping Cart.’
        softAssert.assertEquals(shoppingCartPage.verifyShoppingCartText(), "Shopping Cart", "Unable to verify text.");
        //* Verify the product name ‘Cronus Yoga Pant’
        softAssert.assertEquals(shoppingCartPage.verifyProductName(), "Cronus Yoga Pant", "Unable to verify name.");
        //* Verify the product size ‘32’
        softAssert.assertEquals(shoppingCartPage.verifyProductSize32(), "32", "Unable to verify size.");
        //* Verify the product colour ‘Black’
        softAssert.assertEquals(shoppingCartPage.verifyColourBlack(), "Black", "Unable to verify colour");
        softAssert.assertAll();
    }

}
