package page_object;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PersonalAccountPage {
    private WebDriver driver;

    public PersonalAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    private By buttonExit = (By.xpath(".//button[text()='Выход']"));
    private By successLogInPersonalAccount = (By.xpath("//a[@href='/account/profile']"));

    private By successExitFromProfile = (By.xpath(".//button[text()='Войти']"));
    private By buttonConstructor = (By.xpath("//nav/ul/li[1]/a/p"));
    private By buttonBurgers = (By.xpath(".//div/header/nav/div[contains(@class, 'AppHeader_header')]"));

    @Step("Выход из профиля")
    public void exitFromProfile() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement exitButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//button[text()='Выход']")));
        driver.findElement(buttonExit).click();
    }

    @Step("Проверка успешного выхода из профиля")
    public boolean checkSuccessExitFromProfile() {
        WebDriverWait explicitWait = new WebDriverWait(driver, 3);
        WebElement element = explicitWait.until(ExpectedConditions.presenceOfElementLocated(successExitFromProfile));
        return element.isDisplayed();
    }

    @Step("Клик по кнопке Конструктор")
    public void clickButtonConstructor() {
        driver.findElement(buttonConstructor).click();
    }

    @Step("Клик по кнопке Бургер")
    public void clickButtonBurgers() {
        driver.findElement(buttonBurgers).click();
    }

    @Step("Проверка успешного входа в личный кабинет")
    public boolean checkSuccessLogInPersonalAccount() {
        WebDriverWait explicitWait = new WebDriverWait(driver, 3);
        WebElement element = explicitWait.until(ExpectedConditions.presenceOfElementLocated(successLogInPersonalAccount));
        return element.isDisplayed();
    }


}
