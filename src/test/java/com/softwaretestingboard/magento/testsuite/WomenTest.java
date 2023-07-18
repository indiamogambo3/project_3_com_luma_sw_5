package com.softwaretestingboard.magento.testsuite;

import com.softwaretestingboard.magento.customlisteners.CustomListeners;
import com.softwaretestingboard.magento.pages.HomePage;
import com.softwaretestingboard.magento.testbase.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Listeners(CustomListeners.class)

public class WomenTest extends BaseTest {

    HomePage homePage;

    @BeforeMethod
    public void inIt() {

        homePage = new HomePage();
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyTheSortByProductNameFilter() throws InterruptedException {

        //* Mouse Hover on Women Menu
        Thread.sleep(2000);
        homePage.mouseHoverOnWomenMenu();
        //* Mouse Hover on Tops
        Thread.sleep(2000);
        homePage.mouseHoverOnTops();
        //* Click on Jackets
        homePage.clickOnJackets();
    }

    public void verifyProductNameInAlphabeticalOrder() {

        //* Select Sort By filter “Product Name” and Verify the products name display in alphabetical order

        List<WebElement> jacketsElementsList = driver.findElements(By.xpath("//strong[@class='product name product-item-name']//a"));
        List<String> jacketsNameListBefore = new ArrayList<>();
        for (WebElement value : jacketsElementsList) {
            jacketsNameListBefore.add(value.getText());
        }

        selectByVisibleTextFromDropDown(By.xpath("(//select[@id='sorter'])[1]"), "Product Name");

        jacketsElementsList = driver.findElements(By.xpath("//strong[@class='product name product-item-name']//a"));
        List<String> jacketsNameListAfter = new ArrayList<>();
        for (WebElement value : jacketsElementsList) {
            jacketsNameListAfter.add(value.getText());

            jacketsNameListBefore.sort(String.CASE_INSENSITIVE_ORDER);

            Assert.assertEquals(jacketsNameListAfter, jacketsNameListBefore, "Unable to verify order.");
        }
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyTheSortByPriceFilter() throws InterruptedException {

        //* Mouse Hover on Women Menu
        Thread.sleep(2000);
        homePage.mouseHoverOnWomenMenu();
        //* Mouse Hover on Tops
        Thread.sleep(2000);
        homePage.mouseHoverOnTops();
        //* Click on Jackets
        homePage.clickOnJackets();
    }

    public void verifyProductByPriceLowToHigh() {

        //* Select Sort By filter “Price” and Verify the products price display in Low to High

        List<WebElement> jacketsPriceElementList = driver.findElements(By.xpath("//span[@class='price-wrapper ']//span"));
        List<Double> jacketsPriceListBefore = new ArrayList<>();
        for (WebElement value : jacketsPriceElementList) {
            jacketsPriceListBefore.add(Double.valueOf(value.getText().replace("$", "")));
        }

        selectByVisibleTextFromDropDown(By.xpath("(//select[@id='sorter'])[1]"), "Price");

        jacketsPriceElementList = driver.findElements(By.xpath("//span[@class='price-wrapper ']//span"));
        List<Double> jacketsPriceListAfter = new ArrayList<>();
        for (WebElement value : jacketsPriceElementList) {
            jacketsPriceListAfter.add(Double.valueOf(value.getText().replace("$", "")));
        }

        Collections.sort(jacketsPriceListBefore);

        Assert.assertEquals(jacketsPriceListAfter, jacketsPriceListBefore);
    }

}
