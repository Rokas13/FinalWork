package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pigu.Common;
import pigu.MainPage;

public class CartItemTest extends TestBase {
    private  final MainPage page = new MainPage();
    @BeforeMethod
    @Override
    public void setUp() {

    }

    @Test
    public void cartTest() {
        page.open();

        clickIsparduotuve();

        //Paspausti ant pirmos prekes is Populiariausi 1
        var FavoriteProductSelector = By.xpath("(//p[@class='product-name'])[1]");
        var FavoriteProduct = Common.getElementWhenAvailable(FavoriteProductSelector, 2);
        String FavoriteProductName = FavoriteProduct.getText().trim();
        FavoriteProductName = FavoriteProductName.substring(0, FavoriteProductName.length() / 2);

        FavoriteProductSelector = By.xpath("(//div[@class='image-wrap'])[1]");
        FavoriteProduct = Common.getElementWhenAvailable(FavoriteProductSelector, 2);
        FavoriteProduct.click();

        addProductToCart();
        clickContinueShopping();

        page.driver.navigate().back();

        //Paspausti ant antros prekes is Populiariausi 2
        var FavoriteProductSelector1 = By.xpath("(//p[@class='product-name'])[2]");
        var FavoriteProduct1 = Common.getElementWhenAvailable(FavoriteProductSelector1, 2);
        String FavoriteProduct1Name = FavoriteProduct1.getText().trim();
        FavoriteProduct1Name = FavoriteProduct1Name.substring(0, FavoriteProduct1Name.length() / 2);

        FavoriteProductSelector1 = By.xpath("(//div[@class='image-wrap'])[2]");
        FavoriteProduct1 = Common.getElementWhenAvailable(FavoriteProductSelector1, 2);
        FavoriteProduct1.click();

        addProductToCart();
        clickContinueShopping();

        page.driver.navigate().back();

        var ClickCartButtonSelector = By.xpath("(//i[@class='c-icon--cart'])[1]");
        var ClickCartButton = Common.getElementWhenAvailable(ClickCartButtonSelector, 2);
        ClickCartButton.click();

        var cartItemsNamesSelector = By.xpath("//div[contains(@class, 'product-name')]/a");
        var cartItemsNames = Common.getElementWhenAvailable(cartItemsNamesSelector, 2).getText();

        var cartItemsNamesSelector1 = By.xpath("(//div[contains(@class, 'product-name')])[2]/a");
        var cartItemsNames1 = Common.getElementWhenAvailable(cartItemsNamesSelector1, 2).getText();

        Assert.assertTrue(cartItemsNames.contains(FavoriteProductName));
        Assert.assertTrue(cartItemsNames1.contains(FavoriteProduct1Name));
    }

    public void clickIsparduotuve()
    {
        var CategoryMenuSelector = By.xpath("//a[@href='https://pigu.lt/lt/super/outlet']");
        Common.getElementWhenAvailable(CategoryMenuSelector, 2).click();
    }

    public void addProductToCart()
    {
        var ClickAddToCartButtonSelector = By.xpath("//div[@class='c-btn--primary h-btn-intent--atc']");
        Common.getElementWhenAvailable(ClickAddToCartButtonSelector, 2).click();
    }

    public void clickContinueShopping()
    {
        var ClickContinueShoppingButtonSelector = By.xpath("//a[@id='continue']");
        Common.getElementWhenAvailable(ClickContinueShoppingButtonSelector, 2).click();
    }
}
