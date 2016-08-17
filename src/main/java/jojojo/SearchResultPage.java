package jojojo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultPage {

    private WebDriver driver;

    private final By buyButton = By.name("topurchasesfromcatalog");

    public SearchResultPage(WebDriver driver){
        this.driver = driver;
    }

    public String getSearchMessage(){
        return driver.findElement(By.cssSelector(".search-result-title-text")).getText();
    }

    public void addFirstItemToCart(){
        driver.findElement(buyButton).click();
    }
}
