package registration.test;

import api.UserClient;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import page_object.PageLogin;
import page_object.PageRegistration;

public class RegistrationTest {
    private WebDriver driver;

    UserClient userClient = new UserClient();


    @Before
    public void setUp() {
        RestAssured.baseURI = "https://stellarburgers.nomoreparties.site";
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        //Настройки для проверки на яндекс Браузере
        //System.setProperty(StartWithYandex.YANDEX_BROWSER_DRIVERS_FILENAME,StartWithYandex.BROWSER_DRIVERS);
        //options.setBinary(StartWithYandex.YANDEX_BROWSER_PATH);
        driver = new ChromeDriver(options);
        driver.get("https://stellarburgers.nomoreparties.site/register");

    }

    @Test
    @DisplayName("Регистрация пользователя")
    @Description("Позитивный сценарий - Регистрация пользователя")

    public void registrationTest() {
        PageRegistration pageRegistration = new PageRegistration(driver);
        pageRegistration.registrarion("Jonny", "muBest@exmaple.com", "zxcvbnm");
        pageRegistration.clickRegistration();
        PageLogin pageLogin = new PageLogin(driver);
        pageLogin.waitForLoginButton();
        pageLogin.checkRegistrarionSuccess("muBest@exmaple.com", "zxcvbnm");

    }

    @After
    public void teardown() {
        String accessToken = userClient.authUser().extract().jsonPath().getString("accessToken");
        userClient.deleteUser(accessToken);
        driver.quit();
    }
}
