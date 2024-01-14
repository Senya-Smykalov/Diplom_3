package page_object;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginMainPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public LoginMainPage(WebDriver driver) {
        this.driver = driver;
    }

    //Проверка загрузки главной страницы
    private By mainPage = By.xpath(".//a[@aria-current='page' and @class='active']");
    //Кнопка войти
    private By logInAccount = (By.xpath("//main/section[2]/div/button"));
    //Ввести данные в поле емайл
    private By emailText = (By.xpath("//form/fieldset[1]//input"));
    //Ввести данные в поле пароль
    private By passwordText = (By.xpath("//form/fieldset[2]//input"));
    //кнопка войти
    private By buttonLogin = (By.xpath("//form/button[text()='Войти']"));
    //проверка успешного входа в профиль
    private By checkSuccessLogin = (By.xpath("//main/section[2]//button"));
    //Кнопка "личный кабинет"
    private By personalAccount = (By.xpath("//nav/a/p"));


    @Step("Открыть форму для ввода данных")
    public void clickLogin() {
        driver.findElement(logInAccount).click();
    }

    @Step("Ожидание загрузки домашней страницы")
    public void waitForOpenMainPage() {
        new WebDriverWait(driver, 50)
                .until(ExpectedConditions.visibilityOfElementLocated(mainPage));
    }

    @Step("Ввести email")
    public void enterEmail(String email) {
        driver.findElement(emailText).click();
        driver.findElement(emailText).sendKeys(email);
    }

    @Step("Ввести пароль")
    public void enterPassword(String password) {
        driver.findElement(passwordText).click();
        driver.findElement(passwordText).clear();
        driver.findElement(passwordText).sendKeys(password);
    }

    @Step("Клик по кнопке войти")
    public void clickButtonEnter() {
        driver.findElement(buttonLogin).click();
    }

    @Step("Открыть личный кабинет")
    public void clickButtonPersonalAccount() {
        driver.findElement(personalAccount).click();
    }

    @Step("Проверка успешного входа")
    public boolean checkLogin() {
        WebDriverWait explicitWait = new WebDriverWait(driver, 3);
        WebElement element = explicitWait.until(ExpectedConditions.presenceOfElementLocated(checkSuccessLogin));
        return element.isDisplayed();
    }


}
