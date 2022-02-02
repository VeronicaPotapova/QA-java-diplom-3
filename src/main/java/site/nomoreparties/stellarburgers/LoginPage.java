package site.nomoreparties.stellarburgers;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
    // Локатор ссылки "Зарегистрироваться"
    @FindBy(how = How.XPATH, using = ".//a[contains(@href,'/register')]")
    private SelenideElement register;
    // Локатор кнопки "Войти"
    @FindBy(how = How.XPATH, using = ".//button[text()='Войти']")
    private SelenideElement loginButton;
    // Локатор ссылки "Восстановить пароль"
    @FindBy(how = How.XPATH, using = ".//a[contains(@href,'/forgot-password')]")
    private SelenideElement passwordRecovery;
    // Локатор поля ввода email
    @FindBy(how = How.XPATH, using = ".//input[@name='name']")
    private SelenideElement emailField;
    // Локатор поля ввода пароля
    @FindBy(how = How.NAME, using = "Пароль")
    private SelenideElement passwordField;

    // Метод нажатия на ссылку "Зарегистрироваться"
    @Step("click on the \"Register\" button")
    public void clickRegister() {
        register.shouldBe(Condition.exist).click();
    }

    // Метод поиска на странице кнопки "Войти"
    @Step("search on the page \"Log in\" button")
    public boolean showLoginButton() {
        return loginButton.shouldBe(Condition.exist).exists();
    }

    // Метод нажатия на кнопку "Войти"
    @Step("click on the \"Log in\" button")
    public void clickLoginButton() {
        loginButton.shouldBe(Condition.exist).click();
    }

    // Метод нажатия на ссылку "Восстановить пароль"
    @Step("click on the \"Password recovery\"")
    public void clickPasswordRecovery() {
        passwordRecovery.shouldBe(Condition.exist).click();
    }

    // Метод заполнения поля ввода email
    @Step("set user email")
    public void setUserEmail(String userEmail) {
        emailField.shouldBe(Condition.exist).setValue(userEmail);
    }

    // Метод заполнения поля ввода пароля
    @Step("set user password")
    public void setUserPassword(String userPassword) {
        passwordField.shouldBe(Condition.exist).setValue(userPassword);
    }

    // Метод авторизации: объединяет ввод email, пароля и клик по кнопке "Войти"
    @Step("authorization user")
    public LoginPage login(String email, String password) {
        setUserEmail(email);
        setUserPassword(password);
        clickLoginButton();
        return this;
    }
}
