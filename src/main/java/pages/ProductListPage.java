package pages;

import helper.CommonHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.Keys;


import java.io.IOException;
import java.util.List;
import java.util.Random;

import static utils.driver.Driver.webDriver;

public class ProductListPage extends CommonHelper {
    @FindBy(css = "[class='o-productList__item']")
    public List<WebElement> products;
    public ProductListPage() {
        super(webDriver);
    }
    public void clickProduct(){
        int index = new Random().nextInt(products.size());
        products.get(index).click();
    }


}
