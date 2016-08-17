package jojojo;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class RozetkaTest {
    WebDriver driver;
    SearchResultPage searchResultPage;
    MainPage mainPage;
    Cart cart;

    @Before
    public void precondition(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        mainPage = new MainPage(driver);
        searchResultPage = new SearchResultPage(driver);
        cart = new Cart(driver);
    }

//    @Test
    public void searchRozetka() throws InterruptedException {
        mainPage.open();
        mainPage.searchForProduct("розетка");
        Assert.assertEquals("розетка", searchResultPage.getSearchMessage());
    }

    @Test
    public void checkPriceCart() throws InterruptedException {
        mainPage.open();
        mainPage.searchForProduct("iphone");
        searchResultPage.addFirstItemToCart();
        cart.waitForCartToLoad();
        Integer priceForOne = Integer.parseInt(cart.getPrice());
        cart.increaseQuantity();
        Integer priceForTwo = Integer.parseInt(cart.getPrice());
        Assert.assertEquals(new Integer(priceForOne*2) ,priceForTwo);
    }

    @After
    public void poscondition(){
        driver.quit();
    }
}
