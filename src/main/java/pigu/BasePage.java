package pigu;


public class BasePage {
    public void openChrome(String url) {
        Common.setUpChrome();
        Common.openUrl(url);
    }
}