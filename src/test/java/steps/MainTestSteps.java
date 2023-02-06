package steps;

import org.junit.Test;
import pages.BasketPage;
import pages.HomePage;
import pages.ProductDetailPage;
import pages.ProductListPage;
import utils.driver.Driver;

import java.io.IOException;

public class MainTestSteps extends Driver {
    @Test
    public void uiTestsOfBeymenWebsite() throws IOException, InterruptedException {
        HomePage homePage =new HomePage();
        homePage.navigateBeymen();
        homePage.acceptCookies();
        homePage.closeGenderSelectionPopup();
        homePage.verifyHomePage();
        homePage.searchText(0);
        homePage.clearText();
        Thread.sleep(2000);
        homePage.searchText(1);
        Thread.sleep(2000);
        homePage.enterbutton();
        ProductListPage productListPage =new ProductListPage();
        productListPage.clickProduct();
        ProductDetailPage productDetailPage =new ProductDetailPage();
        productDetailPage.writeProductInfos();
        productDetailPage.addToBasket();
        BasketPage basketPage = new BasketPage();
        basketPage.goToBasket();
        String basketPrice= basketPage.getProductPriceCart();
        String productPrice= productDetailPage.getProductPrice();
        productDetailPage.verifyAddedProductinCart(basketPrice,productPrice);
        basketPage.changeProductCount();
        basketPage.emptyBasket();


    }

}
