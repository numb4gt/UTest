package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SonyHomePagePF extends BasePage {
    private static final String HOMEPAGE_URL = "https://scentre.by/#";

    @FindBy(xpath = "/html/body/div[8]/div/div/div/div/div/div/div/nav/div[2]/div/ul/li[2]/a")
    private WebElement salesButton;

    @FindBy(xpath = "/html/body/div[7]/div/div/div/div/div/div[2]/div/div/div/div/div/div[1]/input")
    private WebElement searchField;

    @FindBy(xpath = "/html/body/div[7]/div/div/div/div/div/div[2]/div/div/div/div/div/div[2]/div[1]/div[2]/div[1]/a")
    private WebElement productHref;

    public SonyPagePF searchForGood(String product) {
        searchField.sendKeys(product);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(
                ExpectedConditions.elementToBeClickable(productHref)).click();
        return new SonyPagePF(driver);

    }

    public SonyHomePagePF(WebDriver driver) {
        super(driver);
    }

    public SonyHomePagePF openPage() {
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public SonyPagePF visitSalesPage() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(
                ExpectedConditions.elementToBeClickable(salesButton)).click();
        return new SonyPagePF(driver);
    }
}
