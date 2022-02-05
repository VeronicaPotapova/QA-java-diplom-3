package site.nomoreparties.stellarburgers;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.webdriver;

public class RegisterPage {
    // Переменная, содержащая имя пользователя
    public String userName = RandomStringUtils.randomAlphabetic(10);
    // Переменная, содержащая email пользователя
    public String userEmail = RandomStringUtils.randomAlphabetic(10) + "@yandex.ru";
    // Переменная, содержащая пароль пользователя
    public String userPassword = RandomStringUtils.randomAlphabetic(6);
    // Переменная, содержащая некорректный пароль пользователя
    public String userErrorPassword = RandomStringUtils.randomAlphabetic(5);
    // Переменная, содержащая пустой пароль пользователя
    public String userEmptyPassword = "";
    // Переменная, содержащая новый url после регистрации
    public String newUrlAfterRegistered = "https://stellarburgers.nomoreparties.site/login";

    // Локатор поля ввода name
    @FindBy(how = How.XPATH, using = "(.//input[@name='name'])[1]")
    private SelenideElement nameField;
    // Локатор поля ввода email
    @FindBy(how = How.XPATH, using = "(.//input[@name='name'])[2]")
    private SelenideElement emailField;
    // Локатор поля ввода пароля
    @FindBy(how = How.NAME, using = "Пароль")
    private SelenideElement passwordField;
    // Локатор кнопки "Зарегистрироваться"
    @FindBy(how = How.XPATH, using = ".//button[text()='Зарегистрироваться']")
    private SelenideElement registerButton;
    // Локатор ссылки "Войти"
    @FindBy(how = How.XPATH, using = ".//a[contains(@href,'/login')]")
    private SelenideElement logIn;
    // Локатор надписи "Некорректный пароль"
    @FindBy(how = How.XPATH, using = ".//p[text()='Некорректный пароль']")
    private SelenideElement messageErrorPassword;

    // Метод заполнения поля ввода имя
    @Step("set user name")
    public RegisterPage setName(String userName) {
        nameField.shouldBe(Condition.exist).setValue(userName);
        return this;
    }

    // Метод заполнения поля ввода email
    @Step("set user email")
    public RegisterPage setEmail(String userEmail) {
        emailField.shouldBe(Condition.exist).setValue(userEmail);
        return this;
    }

    // Метод заполнения поля ввода пароля
    @Step("set user password")
    public RegisterPage setPassword(String userPassword) {
        passwordField.shouldBe(Condition.exist).setValue(userPassword);
        return this;
    }

    // Метод нажатия на кнопку "Зарегистрироваться"
    @Step("click on the \"Register\"")
    public void clickRegisterButton() {
        registerButton.shouldBe(Condition.exist).click();
    }

    // Метод нажатия на ссылку "Войти"
    @Step("click on the \"Log in\"")
    public void clickLogIn() {
        logIn.shouldBe(Condition.exist).click();
    }

    // Метод регистрации пользоваетля: объединяет ввод имя, email, пароля и клик по кнопке "Зарегистрироваться"
    @Step("registration user")
    public RegisterPage registerUser() {
        setName(userName);
        setEmail(userEmail);
        setPassword(userPassword);
        clickRegisterButton();
        return this;
    }

    // Метод получение url страницы после регистрации пользоваетля
    @Step("get url page after register")
    public String urlAfterRegister() {
        registerButton.shouldNotBe(Condition.exist, Duration.ofSeconds(3));
        return webdriver().driver().url();
    }

    // Метод регистрации пользоваетля с неверным паролем: объединяет ввод имя, email, пароля и клик по кнопке "Зарегистрироваться"
    @Step("registration user with error password")
    public RegisterPage registerUserWithErrorPass() {
        setName(userName);
        setEmail(userEmail);
        setPassword(userErrorPassword);
        clickRegisterButton();
        return this;
    }

    // Метод регистрации пользоваетля с пустым паролем: объединяет ввод имя, email, пароля и клик по кнопке "Зарегистрироваться"
    @Step("registration user with empty password")
    public RegisterPage registerUserWithEmptyPass() {
        setName(userName);
        setEmail(userEmail);
        setPassword(userEmptyPassword);
        clickRegisterButton();
        return this;
    }

    // Метод поиска на странице надписи "Некорректный пароль"
    @Step("search message \"error password\"")
    public boolean showMessageErrorPassword() {
        return messageErrorPassword.shouldBe(Condition.exist).exists();
    }
}
