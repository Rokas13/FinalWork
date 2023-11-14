package pom.tests.pigu;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pom.pages.Common;
import pom.pages.Locator;
import pom.pages.pigu.CartPage;
import pom.pages.pigu.MainPage;
import pom.tests.TestBase;
import pom.utilities.Constants;


public class CartItemTest extends TestBase {
    private MainPage page;
    private CartPage cartPage;

    @BeforeMethod
    @Override
    public void setUp() {
        page = new MainPage();
        cartPage = new CartPage();
    }

    @Test
    public void cartTest() {
        page.open();

        cartPage.clickDeals();

        // Click on 1 product in popular section
        var firstFavoriteProduct = Common.getElementWhenAvailable(
                pigu.Locator.Pigu.CartPage.firstFavoriteProductNameSelector,
                Constants.waitSeconds);
        String firstFavoriteItemName = firstFavoriteProduct.getText().trim();
        firstFavoriteItemName = firstFavoriteItemName
                .substring(0, firstFavoriteItemName.length() / Constants.waitSeconds);

        firstFavoriteProduct = Common.getElementWhenAvailable(
                pigu.Locator.Pigu.CartPage.firstFavoriteProductImageSelector,
                Constants.waitSeconds);
        firstFavoriteProduct.click();

        cartPage.addProductToCart();
        cartPage.clickContinueShopping();

        page.driver.navigate().back();

        // Click on 2 product in popular section
        var secondFavoriteItem = Common
                .getElementWhenAvailable(
                        pigu.Locator.Pigu.CartPage.secondFavoriteProductNameSelector,
                        Constants.waitSeconds);
        String socondFavoriteItemName = secondFavoriteItem.getText().trim();
        socondFavoriteItemName = socondFavoriteItemName
                .substring(0, socondFavoriteItemName.length() / Constants.waitSeconds);

        secondFavoriteItem = Common
                .getElementWhenAvailable(
                        pigu.Locator.Pigu.CartPage.secondFavoriteProductImageSelector,
                        Constants.waitSeconds);
        secondFavoriteItem.click();

        cartPage.addProductToCart();
        cartPage.clickContinueShopping();

        page.driver.navigate().back();

        Common.getElementWhenAvailable(
                Locator.Pigu.CartPage.cartButtonSelector,
                Constants.waitSeconds).click();

        var firstCartItemName = Common.getElementWhenAvailable(
                Locator.Pigu.CartPage.firstCartItemNameSelector,
                Constants.waitSeconds).getText();

        var secondCartItemName = Common.getElementWhenAvailable(
                Locator.Pigu.CartPage.secondCartItemNameSelector,
                Constants.waitSeconds).getText();

        Assert.assertTrue(firstCartItemName.contains(firstFavoriteItemName));
        Assert.assertTrue(secondCartItemName.contains(socondFavoriteItemName));
    }
}
