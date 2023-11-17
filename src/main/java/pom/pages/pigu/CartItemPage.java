package pom.pages.pigu;


import pom.pages.Common;

import pom.pages.Locator;
import pom.utilities.Constants;


public class CartItemPage extends BasePage {
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

    public void openCartPage() {
        Common.getElementWhenAvailable(
                Locator.Pigu.CartPage.cartButtonSelector,
                Constants.waitSeconds).click();
    }

    public String openAndGetFavoriteItemNameByIndex(String index) {
        var firstFavoriteProduct = Common.getElementWhenAvailable(
                Locator.Pigu.CartPage.favoriteProductNameByIndexSelector(index),
                Constants.waitSeconds);
        String firstFavoriteItemName = firstFavoriteProduct.getText().trim();
        firstFavoriteItemName = firstFavoriteItemName
                .substring(0, firstFavoriteItemName.length() / Constants.waitSeconds);

        firstFavoriteProduct = Common.getElementWhenAvailable(
                Locator.Pigu.CartPage.favoriteProductImageByIndexSelector(index),
                Constants.waitSeconds);
        firstFavoriteProduct.click();
        return firstFavoriteItemName;
    }

    public String getCartItemNameByIndex(String index) {
        return Common.getElementWhenAvailable(
                Locator.Pigu.CartPage.cartItemNameByIndexSelector(index),
                Constants.waitSeconds).getText();
    }
}
