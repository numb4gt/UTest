package com.pavel.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends AbstractPage{
    private static final String HOMEPAGE_URL = "https://scentre.by/#";
    private final By salesButton = By.xpath("/html/body/div[8]/div/div/div/div/div/div/div/nav/div[2]/div/ul/li[2]/a");

    private final By LoginButton = By.xpath("/html/body/div[6]/div/div/div/div/div[2]/div/div[2]/div/div/div/div/span");

    private final By AutorizationButton = By.xpath("/html/body/div[6]/div/div/div/div/div[2]/div/div[2]/div/div/div/div/ul/li[1]/a");

    private final By LoginText = By.xpath("/html/body/div[6]/div/div/div/div/div[2]/div/div[2]/div/div/div/div/span");

    private final By FindString = By.xpath("/html/body/div[7]/div/div/div/div/div/div[2]/div/div/div/div/div/div[1]/input");

    private final By FindButton = By.xpath("/html/body/div[7]/div/div/div/div/div/div[2]/div/div/div/div/div/div[1]/button");

    private final By LogOutButton = By.xpath("/html/body/div[6]/div/div/div/div/div[2]/div/div[2]/div/div/div/div/ul/li[4]/a");

    public HomePage openPage() {
        driver. get(HOMEPAGE_URL);
        return this;
    }

    public SalesPage visitSalesPage() {
        driver.findElement(salesButton).click();
        return new SalesPage(driver);
    }

    public ProductPage findProduct(String productid){
        driver.findElement(FindString).sendKeys(productid);
        driver.findElement(FindButton).click();
        return new ProductPage(driver);
    }

    public LoginPage visitLoginPage() {
        WebElement loginButtonClick = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until((ExpectedConditions.elementToBeClickable(LoginButton)));
        loginButtonClick.click();
        WebElement autoButtonClick = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until((ExpectedConditions.elementToBeClickable(AutorizationButton)));
        autoButtonClick.click();
        return new LoginPage(driver);
    }

    public HomePage visitLogoutPage() {
        WebElement loginButtonClick = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until((ExpectedConditions.elementToBeClickable(LoginButton)));
        loginButtonClick.click();
        driver.findElement(LogOutButton).click();
        return this;
    }

    public String checkLoginText(){
        WebElement autoButtonClick = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until((ExpectedConditions.elementToBeClickable(LoginText)));
        return autoButtonClick.getText().trim();
    }
    public HomePage(WebDriver driver)
    {
        super(driver);
    }
}
