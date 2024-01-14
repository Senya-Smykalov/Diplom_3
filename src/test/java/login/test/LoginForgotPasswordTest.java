package login.test;

import api.UserClient;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import jdk.jfr.Description;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page_object.LoginMainPage;
import page_object.PageForgotPassword;

public class LoginForgotPasswordTest {
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
        //System.setProperty("webdriver.chrome.driver","src/test/resources/chromeDriver2/chromedriver.exe");
        //options.setBinary("C:\\Users\\ManUtdChemp\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, 15);
        driver.get("https://stellarburgers.nomoreparties.site/login");
    }

    @Test
    @DisplayName("Проверка входа в профиль через страницу восстановления пароля")
    @Description("Позитивная проверка - Проверка входа в профиль через страницу восстановления пароля")
    public void loginForgotPassword() {
        PageForgotPassword pageForgotPassword = new PageForgotPassword(driver);
        LoginMainPage loginMainPage = new LoginMainPage(driver);
        pageForgotPassword.clickButtonForgotPassword();
        pageForgotPassword.clickLoginForgotPassword();
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
