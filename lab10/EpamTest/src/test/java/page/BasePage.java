package page;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    protected final Duration WAIT_TIMEOUT_SECONDS = Duration.ofSeconds(10);
    protected WebDriver driver;

    protected BasePage(WebDriver driver)
    {
        this.driver = driver;
    }

    protected abstract BasePage openPage();
}