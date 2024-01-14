package page_object;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageLogin {
    private WebDriver driver;
    //Заполнения поля емайл для входа
    private By loginEmail = (By.xpath(".//input[@type='text']"));
    //Заполнения поля Пароль для входа
    private By loginPassword = (By.xpath(".//input[@type='password']"));
    //Клик кнопки "войти"
    private By loginButton = (By.xpath(".//button[text()='Войти']"));

    public PageLogin(WebDriver driver) {
        this.driver = driver;
    }


    @Step("Проверка входа в аккаунт после регистрации")
    public void checkRegistrarionSuccess(String email, String password) {
        driver.findElement(loginEmail).click();
        driver.findElement(loginEmail).clear();
        driver.findElement(loginEmail).sendKeys(email);
        driver.findElement(loginPassword).click();
        driver.findElement(loginPassword).clear();
        driver.findElement(loginPassword).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    @Step("Ожидание, пока кнопка Войти станет кликабельна")
    public void waitForLoginButton() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(loginButton));
    }
}