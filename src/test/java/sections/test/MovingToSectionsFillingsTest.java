package sections.test;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page_object.MainPage;

import static org.junit.Assert.assertTrue;

public class MovingToSectionsFillingsTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        //Настройки для проверки на яндекс Браузере
        //System.setProperty(StartWithYandex.YANDEX_BROWSER_DRIVERS_FILENAME,StartWithYandex.BROWSER_DRIVERS);
        //options.setBinary(StartWithYandex.YANDEX_BROWSER_PATH);
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, 15);
        driver.get("https://stellarburgers.nomoreparties.site/");
    }

    @Test
    @DisplayName("Проверка перехода по разделам")
    @Description("Проверка перехода к разделу Начинки")
    public void movingToSectionsFillings() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickButonFillings();
        assertTrue("Не получилось перейти в Начинки!", driver.findElements(mainPage.checkSuccessButtonFillings()).size() > 0);
    }

    @After
    public void teardown() {
        driver.quit();
    }

}
