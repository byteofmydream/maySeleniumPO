package jojojo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    private WebDriver driver;

    private final By searchField =  By.cssSelector("[name=header-search-input-text-wrap]>input");
    private final By searchButton = By.name("search-button");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("http://rozetka.com.ua");
    }

    public void searchForProduct(String product){
        driver.findElement(searchField).sendKeys(product);
        driver.findElement(searchButton).click();
    }
}