package pom.pages;

import org.openqa.selenium.By;

public class Locator {
    public static class Pigu {
        public static class CartPage {
            public static By categoryMenuSelector =
                    By.xpath("//a[@href='https://pigu.lt/lt/super/outlet']");

            public static By clickAddToCartButtonSelector =
                    By.xpath("//div[@class='c-btn--primary h-btn-intent--atc']");

            public static By clickContinueShoppingButtonSelector = By.xpath("//a[@id='continue']");

            public static By firstFavoriteProductNameSelector =
                    By.xpath("(//p[@class='product-name'])[1]");

            public static By firstFavoriteProductImageSelector =
                    By.xpath("(//div[@class='image-wrap'])[1]");

            public static By secondFavoriteProductNameSelector =
                    By.xpath("(//p[@class='product-name'])[2]");

            public static By secondFavoriteProductImageSelector =
                    By.xpath("(//div[@class='image-wrap'])[2]");

            public static By cartButtonSelector = By.xpath("(//i[@class='c-icon--cart'])[1]");

            public static By firstCartItemNameSelector =
                    By.xpath("//div[contains(@class, 'product-name')]/a");

            public static By secondCartItemNameSelector =
                    By.xpath("(//div[contains(@class, 'product-name')])[2]/a");
        }

        public static class MainPage {

            public static By categorySectionSelector(String number) {
                return By.xpath("(//h2[@class='h-h2--small h-fw--semibold h-mt--0'])["+number+"]");
            }

            public static By subCategorySelector(String number) {
                return By.xpath(
                        "(//div[@class='category-list-item-wrap all-categories-visible'])["+ number +"]");
            }

            public static class Buttons {
                public static By acceptCookieButton =
                        By.xpath("//button[contains(@class, 'cookies_accept-all')]");

                public static By submit = By.xpath("//button[@type='submit']");

                public static By allItemsDropdownButtonSelector = By.xpath("//li[@class='h-mr--24']");
            }

            public static class Text {
                public static By cityNameSelector = By.xpath("//a[@class='c-link']/descendant::span");
            }

            public static class Icons {
                public static By cityChangeIconSelector =
                        By.xpath("//i[contains(@class, 'c-icon--location')]");

                public static By infoIconSelector = By.xpath("//span[@class='h-td--none'][1]");
            }

            public static class Options {
                public static By cityOptionSelectorByIndex(int index) {
                    return By.xpath("//div[contains(@class, 'c-chip')][" + index + "]");
                }
            }
        }

        public static class ProductsPage {
            public static By minPriceFilterSelector = By.xpath("//input[@class='price-from']");

            public static By filterValuesSelector = By.xpath("//span[@class='c-tag']");
        }

        public static class SearchPage {
            public static By searchBoxSelector = By.cssSelector("input[id='searchInput']");

            public static By productNameSelector = By.cssSelector("p[class='product-name']");

            public static By itemsSelector = By.cssSelector("p[class='product-name']");

            public static By recommendedItemsHeaderSelector = By.cssSelector("div[class='site-block']");
        }

        public static class EmailReviewForm {
            public static By informationLinkSelector = By.xpath("//a[@widget-attachpoint='link']");
            public static By contactByEmailSelector = By.xpath("//div[@id='subject'][1]");
            public static By reviewTopicSelector = By.xpath("//li[@id='subjectpayments_info']");
            public static By reviewMessageSelector = By.xpath("//textarea[@name='message']");
            public static By reviewEmailSelector = By.xpath("//input[@name='email']");
            public static By reviewSubmitButtonSelector = By.xpath("//span[@role='button']");
            public static By successMsgSelector =
                    By.xpath(
                            "//div[@class='system-message system-message-notice gray_bg mt20 mb0']/descendant::div"
                    );
        }
    }
}
