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

public class MovingToSectionsSaucesTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        //Настройки для проверки на яндекс Браузере
        //System.setProperty("webdriver.chrome.driver","src/test/resources/chromeDriver2/chromedriver.exe");
        //options.setBinary("C:\\Users\\ManUtdChemp\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, 15);
        driver.get("https://stellarburgers.nomoreparties.site/");
    }

    @Test
    @DisplayName("Проверка перехода по разделам")
    @Description("Проверка перехода к разделу соусы")
    public void movingToSectionsSauces() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickButtonSauces();
        assertTrue("Не получилось перейти в Соусы!", driver.findElements(mainPage.checkSuccessButtonSauces()).size() > 0);
        mainPage.clickButonFillings();
        assertTrue("Не получилось перейти в Начинки!", driver.findElements(mainPage.checkSuccessButtonFillings()).size() > 0);
        mainPage.clickButtonBread();
        assertTrue("Не получилось перейти в Булки!", driver.findElements(mainPage.checkSuccessButtonBread()).size() > 0);
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
