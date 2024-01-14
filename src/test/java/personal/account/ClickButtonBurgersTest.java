package personal.account;

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
import org.openqa.selenium.support.ui.WebDriverWait;
import page_object.LoginMainPage;
import page_object.PersonalAccountPage;

public class ClickButtonBurgersTest {
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
        driver.get("https://stellarburgers.nomoreparties.site/");


    }

    @Test
    @DisplayName("Проверка перехода на главную страницу из личного кабинета по кнопке Бургер")
    @Description("Позитивная проверка - Проверка перехода на главную страницу из личного кабинета по кнопке Бургер")
    public void clickButtonBurger() {
        LoginMainPage loginMainPage = new LoginMainPage(driver);
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        loginMainPage.clickLogin();
        loginMainPage.enterEmail(userClient.email);
        loginMainPage.enterPassword(userClient.password);
        loginMainPage.clickButtonEnter();

        loginMainPage.clickButtonPersonalAccount();
        personalAccountPage.checkSuccessLogInPersonalAccount();
        personalAccountPage.clickButtonBurgers();
        loginMainPage.checkLogin();
    }

    @After
    public void teardown() {
        String accessToken = userClient.authUser().extract().jsonPath().getString("accessToken");
        userClient.deleteUser(accessToken);
        driver.quit();
    }
}
