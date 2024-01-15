package page_object;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageForgotPassword {
    private WebDriver driver;

    public PageForgotPassword(WebDriver driver) {
        this.driver = driver;
    }

    //Клик по кнопке "Восстановить пароль"
    private By buttonForgotPassword = (By.xpath("//div[@id='root']//p[2]/a"));
    //Клик по кнопке "Войти" на странице восстановления пароля
    private By loginForgotPassword = (By.xpath("//*[@id='root']//p/a"));

    @Step("Клик на кнопку Восстановить пароль на странице входа")
    public void clickButtonForgotPassword() {
        driver.findElement(buttonForgotPassword).click();
    }

    @Step("Клик на кнопку Войти на странице восстановления пароля")
    public void clickLoginForgotPassword() {
        driver.findElement(loginForgotPassword).click();
    }
}
