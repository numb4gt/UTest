package com.pavel.page;

import org.openqa.selenium.WebDriver;

public class SalesPage extends AbstractPage {

    private static final String HOMEPAGE_URL = "https://scentre.by/#";

    protected SalesPage(WebDriver driver) {
        super(driver);
    }

    public String getPageUrl() {
        return driver.getCurrentUrl();
    }

    @Override
    protected SalesPage openPage() {
        driver.navigate().to(HOMEPAGE_URL);
        return this;
    }

}
