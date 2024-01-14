package page_object;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    //Кнопка Соусы
    private By buttonSauces = (By.xpath(".//span[text()='Соусы']"));
    //Кнопка Начинки
    private By buttonFillings = (By.xpath(".//span[text()='Начинки']"));
    //Кнопка Булки
    private By buttonBread = (By.xpath(".//span[text()='Булки']"));
    //Проверка успешного перехода во кнопке Соусы
    private By successButtonSauces = (By.xpath("//*[@id='root']//section[1]/div[2]//a[p[contains(text(), 'Соус Spicy-X')]]"));
    //Проверка успешного перехода по кнопке Начинки
    private By successButtonFillings = (By.xpath("//*[@id='root']//section[1]/div[2]//ul[3]/a[1]/img"));
    //Проверка успешного перехода по кнопке Булки
    private By successButtonBread = (By.xpath("//*[@id='root']//section[1]/div[2]/ul[1]/a[1]/img"));

    @Step("Клик по вкладке Соусы")
    public void clickButtonSauces() {
        driver.findElement(buttonSauces).click();
    }

    @Step("Клик по вкладке начинки")
    public void clickButonFillings() {
        driver.findElement(buttonFillings).click();
    }

    @Step("Клик по вкладке Булки")
    public void clickButtonBread() {
        driver.findElement(buttonBread).click();
    }

    @Step("Проверка успешного перехода во вкладку Соусы")
    public By checkSuccessButtonSauces() {
        return successButtonSauces;
    }

    @Step("Проверка успешного перехода во вкладку Начинки")
    public By checkSuccessButtonFillings() {
        return successButtonFillings;
    }

    @Step("Проверка успешного перехода во вкладку Булки")
    public By checkSuccessButtonBread() {
        return successButtonBread;
    }

}
