package pages;

import helper.CommonHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.Keys;


import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import static utils.driver.Driver.webDriver;

public class ProductDetailPage extends CommonHelper {
    @FindBy(css = "[class='o-productList__item']")
    public List<WebElement> products;
    @FindBy(css = "[class='o-productDetail__description']")
    public WebElement productDescription;
    @FindBy(css = "[id='priceNew']")
    public WebElement productNewPrice;
    @FindBy(css = "[id='priceOld']")
    public WebElement productOldPrice;
    @FindBy(css = "[id='addBasket']")
    public WebElement addToBasket;
    @FindBy(css = "[class='m-variation__item']")
    public List<WebElement> sizes;
    @FindBy(css = "[class='m-notification success']")
    public List<WebElement> addTobasketSuccessmessage;


    public ProductDetailPage() {
        super(webDriver);
    }
    public void writeProductInfos() throws IOException {
        System.out.println("product name:"+ productDescription.getText());
        System.out.println("product price new:"+ productNewPrice.getText());
        FileWriter file = new FileWriter("src/main/resource/productinfo.txt", true);
        file.write(productDescription.getText());
        file.write("\n");
        file.write(productNewPrice.getText());
        file.write("\n");
        file.close();
    }
    public void addToBasket(){
        //select size
        sizes.get(0).click();
        addToBasket.click();
        if(addTobasketSuccessmessage.isEmpty())
        System.out.println("Product cannot add to basket");
    }
    public String getProductPrice()
    {return productNewPrice.getText();}

    public void verifyAddedProductinCart(String productPrice,String cartPrice){
     /*   String priceInproduct= productNewPrice.getText();
        String priceInCart = productBasketPrice.getText(); */
        compareElements(productPrice,cartPrice);

    }


}
