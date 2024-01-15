package personal.account;

import api.UserClient;
import yandex.StartWithYandex;
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
import page_object.PersonalAccountPage;

public class ExitFromProfileTest {
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
        wait = new WebDriverWait(driver, 15);
        driver.get("https://stellarburgers.nomoreparties.site/");


    }

    @Test
    @DisplayName("Проверка выхода из профиля")
    @Description("Позитивная проверка - выход из профиля")
    public void exitFromProfile() {
        LoginMainPage loginMainPage = new LoginMainPage(driver);
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        loginMainPage.clickLogin();
        loginMainPage.enterEmail(userClient.email);
        loginMainPage.enterPassword(userClient.password);
        loginMainPage.clickButtonEnter();
        loginMainPage.checkLogin();
        loginMainPage.clickButtonPersonalAccount();
        personalAccountPage.exitFromProfile();
        personalAccountPage.checkSuccessExitFromProfile();

    }

    @After
    public void teardown() {
        String accessToken = userClient.authUser().extract().jsonPath().getString("accessToken");
        userClient.deleteUser(accessToken);
        driver.quit();
    }
}
