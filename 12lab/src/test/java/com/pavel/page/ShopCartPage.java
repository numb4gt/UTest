package com.pavel.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShopCartPage extends AbstractPage {
    private static final String HOMEPAGE_URL = "https://scentre.by/#";

    private final By nameOfProduct = By.xpath("/html/body/div[10]/div/section/div/div[2]/div/div[1]/div[2]/div[1]/div/div[1]/div/div/div/div/table/tbody/tr/td[1]/div[2]/a");

    private final By nameOfProduct2 = By.xpath("/html/body/div[10]/div/section/div/div[2]/div/div[1]/div[2]/div[1]/div/div[1]/div/div/div/div/table/tbody/tr[2]/td[1]/div[2]/a");

    private final By inputCount = By.xpath("/html/body/div[10]/div/section/div/div[2]/div/div[1]/div[2]/div[1]/div/div[1]/div/div/div/div/table/tbody/tr/td[3]/span/input");

    public String getProductName(){
        return driver.findElement(nameOfProduct).getText();
    }

    public String getProductName2(){
        return driver.findElement(nameOfProduct2).getText();
    }

    public String getProductCount(){

        System.out.println(driver.findElement(inputCount).getText());
        return driver.findElement(inputCount).getAttribute("value");
    }

    protected ShopCartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected ShopCartPage openPage() {
        driver.navigate().to(HOMEPAGE_URL);
        return this;
    }
}
