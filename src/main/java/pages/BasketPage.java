package pages;

import helper.CommonHelper;
import org.apache.poi.ss.formula.functions.Code;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

import static utils.driver.Driver.webDriver;

public class BasketPage extends CommonHelper {
    @FindBy(css = "[id='quantitySelect0-key-0y']")
    public WebElement countoptions;
    @FindBy(css = "[id='removeCartItemBtn0-key-0']")
    public WebElement cleanicon;
    @FindBy(css = "[class='m-empty__messageTitle\n']")
    public WebElement emptyCartText;
    @FindBy(css = "[class='icon icon-cart']")
    public WebElement basketicon;
    @FindBy(css = "[class='m-productPrice__salePrice']")
    public WebElement productBasketPrice;
    public BasketPage() {
        super(webDriver);
    }
    public void goToBasket(){
        basketicon.click();
    }
    public String getProductPriceCart(){
       return productBasketPrice.getText();
    }
    public void changeProductCount(){
        Select options = new Select(countoptions);
        options.selectByVisibleText("3 Adet");
    }
    public void emptyBasket(){
        cleanicon.click();
        emptyCartText.isDisplayed();
    }

}
