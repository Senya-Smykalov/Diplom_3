package page_object;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageRegistration {
    private WebDriver driver;

    // Для ввода данных в поле "имя"
    private By fieldName = (By.xpath("//form/fieldset[1]/div/div/input"));
    // Для ввода данных в поле "емайл"
    private By fieldEmail = (By.xpath("//form/fieldset[2]/div/div/input"));
    // Для ввода данных в поле "пароль"
    private By fieldPassword = (By.xpath("//form/fieldset[3]/div/div/input"));
    //Кнопка "Зарегистрироваться"
    private By buttonRegistration = (By.xpath("//button[contains(@class, 'button_button_type_primary')]"));
    //Сообщение об ошибке пароля
    private By errorPasword = (By.xpath("//form//fieldset[3]//div//p"));
    private By clickLogin = (By.xpath("//main/div/div/p/a"));


    public PageRegistration(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Заполнении формы регистрации")
    public void registrarion(String name, String email, String password) {
        driver.findElement(fieldName).click();
        driver.findElement(fieldName).clear();
        driver.findElement(fieldName).sendKeys(name);
        driver.findElement(fieldEmail).click();
        driver.findElement(fieldEmail).clear();
        driver.findElement(fieldEmail).sendKeys(email);
        driver.findElement(fieldPassword).click();
        driver.findElement(fieldPassword).clear();
        driver.findElement(fieldPassword).sendKeys(password);
    }

    @Step("Заврешение регистрации")
    public void clickRegistration() {
        driver.findElement(buttonRegistration).click();
    }

    @Step("Сообщение о некорректном пароле")
    public By getErrorPasswordLocator() {
        return errorPasword;
    }

    @Step("Регистрация с некорректным паролем")
    public void badPasswordRegistration(String name, String email, String password) {
        driver.findElement(fieldName).click();
        driver.findElement(fieldName).clear();
        driver.findElement(fieldName).sendKeys(name);
        driver.findElement(fieldEmail).click();
        driver.findElement(fieldEmail).clear();
        driver.findElement(fieldEmail).sendKeys(email);
        driver.findElement(fieldPassword).click();
        driver.findElement(fieldPassword).clear();
        driver.findElement(fieldPassword).sendKeys(password);
    }

    @Step("Клик по кнопке Войти на странице регистрации")
    public void clickLogin() {
        driver.findElement(clickLogin).click();
    }


}
