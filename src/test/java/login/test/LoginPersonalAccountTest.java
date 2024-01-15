package login.test;

import api.UserClient;
import yandex.StartWithYandex;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page_object.LoginMainPage;

public class LoginPersonalAccountTest {
    private WebDriver driver;
    private WebDriverWait wait;

    UserClient userClient = new UserClient();

    @Before
    public void setUp() {
        RestAssured.baseURI = "https://stellarburgers.nomoreparties.site";
        userClient.createUser();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        //Настройки для проверки на яндекс Браузере
        //System.setProperty(StartWithYandex.YANDEX_BROWSER_DRIVERS_FILENAME,StartWithYandex.BROWSER_DRIVERS);
        //options.setBinary(StartWithYandex.YANDEX_BROWSER_PATH);
        driver = new ChromeDriver(options);
        driver.get("https://stellarburgers.nomoreparties.site/");
    }

    @Test
    @DisplayName("Проверка входа через личный кабинет")
    @Description("Позитивная проверка - Проверка входа через личный кабинет")
    public void loginPersonalAccount() {
        LoginMainPage loginMainPage = new LoginMainPage(driver);
        loginMainPage.clickButtonPersonalAccount();
        loginMainPage.enterEmail(userClient.email);
        loginMainPage.enterPassword(userClient.password);
        loginMainPage.clickButtonEnter();
        loginMainPage.checkLogin();
    }

    @After
    public void teardown() {
        String accessToken = userClient.authUser().extract().jsonPath().getString("accessToken");
        userClient.deleteUser(accessToken);
        driver.quit();
    }
}
