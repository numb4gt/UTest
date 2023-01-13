package test;

import java.time.Duration;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import page.SonyPagePF;
import page.SonyHomePagePF;

public class SonyTest extends CommonConditions {
//    private WebDriver driver;
//
//    @BeforeEach
//    public void initializeDriver() {
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\USER\\Desktop\\ВУЗ\\3 курс\\UTest\\lab10\\chromedriver.exe");
//        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.manage().window().maximize();
//    }

    @Test
    void openSalesPageSony()
            throws InterruptedException {
        SonyPagePF sonyPagePF =
                new SonyHomePagePF(driver).openPage()
                                .visitSalesPage();
        Assertions.assertEquals(
                "https://scentre.by/catalogs/discounts",
                sonyPagePF.getPageUrl());
    }

    @Test
    @DisplayName("Test: search the playstation gamepad")
    void createTestMethodThatThrowsInterruptedExceptionAndReturnsVoidInBody() throws InterruptedException {


        String gamePad = "DualShock";
        SonyPagePF sonyPagePF =
                new SonyHomePagePF(driver).openPage().searchForGood(gamePad)
                        .clickOnSpecs();
        Assertions.assertEquals(
                        sonyPagePF.getSonyGamePad().getAttribute("innerHTML").trim(), "Sony PlayStation 4"
        );


    }

    @AfterEach
    @DisplayName("Close Chrome Driver")
    public void tearDown() {
        driver.quit();
        driver = null;
    }
}
