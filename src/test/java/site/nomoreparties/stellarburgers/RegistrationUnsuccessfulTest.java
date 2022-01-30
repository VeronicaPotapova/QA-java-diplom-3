package site.nomoreparties.stellarburgers;

import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.*;

public class RegistrationUnsuccessfulTest {
    MainPage mainPage = new MainPage();

    @Before
    public void before() {
        // Раскомментировать для теста в яндекс браузере
        // System.setProperty("webdriver.chrome.driver", "src/resources/yandexdriver.exe");
        mainPage = open(MainPage.URL, MainPage.class);
    }

    @Test
    @DisplayName("check user with error password can not be registered")
    public void shouldNotBeRegistrationWithErrorPassword() {
        // Нажатие на кнопку "Личный кабинет"
        mainPage.clickOnPersonalAccount();
        // Нажатие на ссылку "Зарегистрироваться"
        LoginPage loginPage = page(LoginPage.class);
        loginPage.clickRegister();

        // Регистрация нового пользователя
        RegisterPage registerPage = page(RegisterPage.class)
                .registerUserWithErrorPass();

        MatcherAssert.assertThat("User with error password can be registered",
                registerPage.showMessageErrorPassword());
    }

    @Test
    @DisplayName("check user with empty password can not be registered")
    public void shouldNotBeRegistrationWithEmptyPassword() {
        // Нажатие на кнопку "Личный кабинет"
        mainPage.clickOnPersonalAccount();
        // Нажатие на ссылку "Зарегистрироваться"
        LoginPage loginPage = page(LoginPage.class);
        loginPage.clickRegister();

        // Регистрация нового пользователя
        RegisterPage registerPage = page(RegisterPage.class)
                .registerUserErrorWithEmptyPass();

        MatcherAssert.assertThat("User with error password can be registered",
                registerPage.showMessageErrorPassword());
    }

    @After
    public void teardown() {
        // Закрытие браузера
        closeWebDriver();
    }
}
