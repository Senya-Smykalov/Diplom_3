package registration.test;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page_object.PageRegistration;

import static org.junit.Assert.assertTrue;

public class BadRegistrationTest {
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
        driver.get("https://stellarburgers.nomoreparties.site/register");
    }

    @Test
    @DisplayName("Проверка появления ошибки, если введён некорректный пароль")
    @Description("Негативная проверка - пользователь вводит некорректный пароль")

    public void badRegistration() {
        PageRegistration pageRegistration = new PageRegistration(driver);
        pageRegistration.badPasswordRegistration("Semen", "Semen", "12345");
        pageRegistration.clickRegistration();
        assertTrue("Элемент 'Некорректный пароль' не найден", driver.findElements(pageRegistration.getErrorPasswordLocator()).size() > 0);

    }

    @After
    public void teardown() {
        driver.quit();
    }


}
