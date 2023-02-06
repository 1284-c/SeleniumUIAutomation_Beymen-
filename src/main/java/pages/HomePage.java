package pages;

import helper.CommonHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.Keys;


import java.io.IOException;

import static utils.driver.Driver.webDriver;

public class HomePage extends CommonHelper {
    String url="https://www.beymen.com/";
    @FindBy(css = "[id='onetrust-accept-btn-handler']")
    public WebElement acceptcokiesbutton;
    @FindBy(css = "[class='o-modal__closeButton bwi-close']")
    public WebElement genderPopupClosebutton;
    @FindBy(css = "[class='o-header__logo']")
    public WebElement homePageHeader;
    @FindBy(css = "[class='default-input o-header__search--input']")
    public WebElement searchbar;
    @FindBy(css = "[class='o-header__search--btn bmi-search']")
    public WebElement searchbutton;

    public HomePage() {
        super(webDriver);
    }
    public void navigateBeymen() {
        navigate(url);
    }
    public void verifyHomePage(){
        waitUntilElementIsVisible(homePageHeader);
    }
    public void acceptCookies(){
        acceptcokiesbutton.click();
    }
    public void closeGenderSelectionPopup(){
        genderPopupClosebutton.click();
    }
    public void searchText(int index) throws IOException {
        String text=readFile(index);
        searchbar.sendKeys(text);
    }
    public void clearText(){
        searchbar.click();
        for(int i=0;i<4;i++) {
            searchbar.sendKeys(Keys.BACK_SPACE);
        }
       /* searchbar.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        searchbar.sendKeys(Keys.BACK_SPACE); */
    }
    public void enterbutton() {
     //  searchbar.sendKeys(Keys.ENTER);
        searchbutton.click();
    }

}
