package jojojo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Cart {
    private WebDriver driver;
    private final By plusButton = By.className("cart-amount-plus-icon");
    private final By price = By.cssSelector(".cart-sum-uah span[name=sum]");

    public Cart(WebDriver driver){
        this.driver = driver;
    }

    public void increaseQuantity() {
        driver.findElement(plusButton).click();
    }

    public String getPrice(){
        return driver.findElement(price).getText();
    }

    public void waitForCartToLoad(){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(plusButton));
    }

}
