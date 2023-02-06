package helper;

import com.github.webdriverextensions.WebDriverExtensionFieldDecorator;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public abstract class CommonHelper {
    private WebDriver webDriver;
    private WebDriverWait wait;
    int counter = 0;

    public CommonHelper(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(new WebDriverExtensionFieldDecorator(webDriver), this);
        wait = new WebDriverWait(webDriver, 10);
    }
    public void navigate(String url){webDriver.get(url);}

    public void waitUntilElementIsVisible(WebElement element) {
        WebDriverWait wait =new WebDriverWait(webDriver,30);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public String readFile(int index) throws IOException {
        FileInputStream files = new FileInputStream(new File("src/main/resource/searchtext.xlsx"));
        XSSFWorkbook workbook = new XSSFWorkbook(files);
        XSSFSheet sheet = workbook.getSheetAt(0);
        String text= sheet.getRow(0).getCell(index).getStringCellValue();
        return text;
    }
    public void compareElements(String text1, String text2){
        if(text2.equals(text1))
            System.out.println("text is same with expected value");
    }

}