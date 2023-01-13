package com.pavel.page;

import com.pavel.model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends AbstractPage {
    private static final String HOMEPAGE_URL = "https://scentre.by/#";

    private final By loginInput = By.xpath("/html/body/div[12]/div/div/div/div[2]/div[1]/form/div[1]/input");

    private final By passwordInput = By.xpath("/html/body/div[12]/div/div/div/div[2]/div[1]/form/div[2]/input");

    private final By loginButton = By.xpath("/html/body/div[12]/div/div/div/div[2]/div[1]/form/a");

    protected LoginPage(WebDriver driver) {
        super(driver);
    }

    public HomePage login(User user){
        driver.findElement(loginInput).sendKeys(user.getUsername());
        driver.findElement(passwordInput).sendKeys(user.getPassword());
        driver.findElement(loginButton).click();
        return new HomePage(driver);
    }

    @Override
    protected LoginPage openPage() {
        driver.navigate().to(HOMEPAGE_URL);
        return this;
    }

}
