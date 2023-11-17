package pom.tests.pigu;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pom.pages.pigu.CartItemPage;
import pom.pages.pigu.MainPage;
import pom.tests.TestBase;


public class CartItemTest extends TestBase {
    private MainPage page;
    private CartItemPage cartPage;

    @BeforeMethod
    @Override
    public void setUp() {
        page = new MainPage();
        cartPage = new CartItemPage();
    }

    @Test
    public void cartTest() {
        page.open();

        cartPage.clickDeals();

        // Click on 1 product in popular section
        String firstFavoriteItemName = cartPage.openAndGetFavoriteItemNameByIndex("1");

        cartPage.addProductToCart();
        cartPage.clickContinueShopping();

        page.driver.navigate().back();

        // Click on 2 product in popular section
        String secondFavoriteItemName = cartPage.openAndGetFavoriteItemNameByIndex("2");

        cartPage.addProductToCart();
        cartPage.clickContinueShopping();

        page.driver.navigate().back();

        cartPage.openCartPage();

        var firstCartItemName = cartPage.getCartItemNameByIndex("1");
        var secondCartItemName = cartPage.getCartItemNameByIndex("2");

        Assert.assertTrue(firstCartItemName.contains(firstFavoriteItemName));
        Assert.assertTrue(secondCartItemName.contains(secondFavoriteItemName));
    }
}
