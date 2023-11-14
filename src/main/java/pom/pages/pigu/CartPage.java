package pom.pages.pigu;


import pom.pages.Common;

import pom.pages.Locator;
import pom.utilities.Constants;


public class CartPage  extends BasePage {
    public void clickDeals()
    {
        Common.getElementWhenAvailable(
                Locator.Pigu.CartPage.categoryMenuSelector,
                Constants.waitSeconds).click();
    }

    public void addProductToCart()
    {
        Common.getElementWhenAvailable(
                Locator.Pigu.CartPage.clickAddToCartButtonSelector,
                Constants.waitSeconds).click();
    }

    public void clickContinueShopping()
    {
        Common.getElementWhenAvailable(
                Locator.Pigu.CartPage.clickContinueShoppingButtonSelector,
                Constants.waitSeconds).click();
    }
}

