package com.pavel.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage extends AbstractPage {
    private static final String HOMEPAGE_URL = "https://scentre.by/#";

    private final By ddButton = By.xpath("/html/body/div[10]/div/div[3]/div/div/div/div[2]/div/div/div/div/div[1]/div/div/div/div/div/div/div[3]/div[1]/div[3]/div[2]/div/div/div/div/div[2]/div/a");

    private final By closeButton = By.xpath("/html/body/div[14]/div/div/div[1]/button");

    private final By shopCartOpen = By.xpath("/html/body/div[7]/div/div/div/div/div/div[4]/div/div/div/div/div[1]/a");

    private final By productLink = By.xpath("/html/body/div[10]/div/div[3]/div/div/div/div[2]/div/div/div/div/div[1]/div/div/div/div/div/div/div[2]/div[1]/div[1]/a");


    private final By ReviewLink = By.xpath("/html/body/div[10]/div/div[3]/div/div/div/div/div[1]/div[3]/div/div/div/ul/li[3]/a");

    private final By ReviewButton = By.xpath("/html/body/div[10]/div/div[3]/div/div/div/div/div[1]/div[3]/div/div/div/div/div[3]/div/div/div/div/div/div/button");

    //Review
    private final By Name = By.xpath("/html/body/div[10]/div/div[3]/div/div/div/div/div[1]/div[3]/div/div/div/div/div[3]/div/div/div/div/div/div/div[2]/div/div/div[2]/div/div/div/form/div[1]/div[1]/input");

    private final By Title = By.xpath("/html/body/div[10]/div/div[3]/div/div/div/div/div[1]/div[3]/div/div/div/div/div[3]/div/div/div/div/div/div/div[2]/div/div/div[2]/div/div/div/form/div[1]/div[2]/input");

    private final By MainText = By.xpath("/html/body/div[10]/div/div[3]/div/div/div/div/div[1]/div[3]/div/div/div/div/div[3]/div/div/div/div/div/div/div[2]/div/div/div[2]/div/div/div/form/div[1]/div[3]/textarea");

    private final By TextPlus = By.xpath("/html/body/div[10]/div/div[3]/div/div/div/div/div[1]/div[3]/div/div/div/div/div[3]/div/div/div/div/div/div/div[2]/div/div/div[2]/div/div/div/form/div[1]/div[4]/div[1]/div/textarea");

    private final By TextMinus = By.xpath("/html/body/div[10]/div/div[3]/div/div/div/div/div[1]/div[3]/div/div/div/div/div[3]/div/div/div/div/div/div/div[2]/div/div/div[2]/div/div/div/form/div[1]/div[4]/div[2]/div/textarea");

    private final By Stars = By.xpath("/html/body/div[10]/div/div[3]/div/div/div/div/div[1]/div[3]/div/div/div/div/div[3]/div/div/div/div/div/div/div[2]/div/div/div[2]/div/div/div/form/div[1]/div[6]/div/div/span[1]/span[5]");
    private final By Review = By.xpath("/html/body/div[10]/div/div[3]/div/div/div/div/div[1]/div[3]/div/div/div/div/div[3]/div/div/div/div/div/div/div[2]/div/div/div[1]/h4");

    private final By AddButton = By.xpath("/html/body/div[10]/div/div[3]/div/div/div/div/div[1]/div[3]/div/div/div/div/div[3]/div/div/div/div/div/div/div[2]/div/div/div[2]/div/div/div/form/div[1]/button");


    private final By AddToFavorites = By.xpath("/html/body/div[10]/div/div[3]/div/div/div/div[2]/div/div/div/div/div[1]/div/div/div/div[1]/div/div/div[3]/div[2]/div/a[1]");

    private final By Favorites = By.xpath("/html/body/div[2]/div/div/div/div/div/div/div[1]/div[3]/div/div[2]");


    private final By Close = By.xpath("/html/body/div[14]/div/div/div[3]/button");

    private final By ProductFavoriteName = By.xpath("/html/body/div[14]/div/div/div[2]/div/div/div/div/div/table/tbody/tr/td[1]/div[2]/a");

    private final By ProductNameCode = By.xpath("/html/body/div[10]/div/div[3]/div/div/div/div[2]/div/div/div/div/div[1]/div/div/div/div/div/div/div[2]/div[1]/div[1]/a");

    private final By CountInput = By.xpath("/html/body/div[10]/div/div[3]/div/div/div/div[2]/div/div/div/div/div[1]/div/div/div/div/div/div/div[3]/div[1]/div[3]/div[2]/div/div/div/div/div[1]/input");
    public ProductPage addToShopCartClick(){
        driver.findElement(ddButton).click();
        driver.findElement(closeButton).click();
        return this;
    }

    public ProductPage addToShopCartClickwithCount(){

        driver.findElement(CountInput).sendKeys("10");
        driver.findElement(ddButton).click();
        driver.findElement(closeButton).click();

        return this;
    }

    public ProductPage goProductOnly(){
        driver.findElement(productLink).click();
        return this;
    }

    public ProductPage addReview(String Name1, String Title1, String Main1, String Plus, String Minus){
        driver.findElement(Name).sendKeys(Name1);
        driver.findElement(Title).sendKeys(Title1);
        driver.findElement(MainText).sendKeys(Main1);
        driver.findElement(TextPlus).sendKeys(Plus);
        driver.findElement(TextMinus).sendKeys(Minus);
        driver.findElement(Stars).click();
        driver.findElement(AddButton).click();
        return this;
    }

    public ProductPage addToFavorites(){
        driver.findElement(AddToFavorites).click();
        driver.findElement(Close).click();
        return this;
    }

    public String FindFavorite(){
        driver.findElement(Favorites).click();
        return driver.findElement(ProductFavoriteName).getAttribute("value");
    }

    public String findName(){
        return driver.findElement(ProductNameCode).getText().trim();
    }

    public String getReviewText(){
        return driver.findElement(Review).getText().trim();
    }

    public ProductPage goReviewPage(){
        driver.findElement(ReviewLink).click();
        driver.findElement(ReviewButton).click();
        return this;
    }

    public ShopCartPage goToShopCart(){
        WebElement autoButtonClick = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until((ExpectedConditions.elementToBeClickable(shopCartOpen)));
        autoButtonClick.click();
        return new ShopCartPage(driver);
    }

    protected ProductPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected ProductPage openPage() {
        driver.navigate().to(HOMEPAGE_URL);
        return this;
    }
}
