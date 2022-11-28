package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SonyPagePF extends BasePage {
    @FindBy(xpath = "/html/body/div[10]/div/div[3]/div/div/div/div/div[1]/div[3]/div/div/div/ul/li[2]/a")
    private WebElement specs;

    @FindBy(xpath = "/html/body/div[10]/div/div[3]/div/div/div/div/div[1]/div[3]/div/div/div/div/div[2]/div/div/div/div[2]/div[2]/ul/li[2]/div[2]/span")
    private WebElement sonyGamePad;

    public WebElement getSonyGamePad() {
        return sonyGamePad;
    }

    public SonyPagePF(WebDriver driver) {
        super(driver);
    }

    public SonyPagePF clickOnSpecs(){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(
                        ExpectedConditions.elementToBeClickable(specs))
                .click();

        return this;
    }


    public String getPageUrl() {
        return driver.getCurrentUrl();
    }

    @Override
    protected BasePage openPage() {
        throw new RuntimeException("Not needed for this page");
    }
}