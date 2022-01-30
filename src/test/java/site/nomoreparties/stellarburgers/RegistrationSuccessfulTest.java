package site.nomoreparties.stellarburgers;

import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.*;

public class RegistrationSuccessfulTest {
    MainPage mainPage = new MainPage();

    @Before
    public void before() {
        // Раскомментировать для теста в яндекс браузере
        // System.setProperty("webdriver.chrome.driver", "src/resources/yandexdriver.exe");
        mainPage = open(MainPage.URL, MainPage.class);
    }

    @Test
    @DisplayName("check to successful registration from link personal account")
    public void shouldBeSuccessfulRegistrationFromPersonalAccount() {
        // Нажатие на кнопку "Личный кабинет"
        mainPage.clickOnPersonalAccount();
        // Нажатие на ссылку "Зарегистрироваться"
        LoginPage loginPage = page(LoginPage.class);
        loginPage.clickRegister();

        // Регистрация нового пользователя
        RegisterPage registerPage = page(RegisterPage.class)
                .registerUser();

        MatcherAssert.assertThat("New user can not registered",
                registerPage.urlAfterRegister().equalsIgnoreCase(registerPage.newUrlAfterRegistered));
    }

    @Test
    @DisplayName("check to successful registration from button enter account")
    public void shouldBeSuccessfulRegistrationFromEnterAccount() {
        // Нажатие на кнопку "Войти в аккаунт"
        mainPage.clickOnPersonalAccount();
        // Нажатие на ссылку "Зарегистрироваться"
        LoginPage loginPage = page(LoginPage.class);
        loginPage.clickRegister();

        // Регистрация нового пользователя
        RegisterPage registerPage = page(RegisterPage.class)
                .registerUser();

        MatcherAssert.assertThat("New user can not registered",
                registerPage.urlAfterRegister().equalsIgnoreCase(registerPage.newUrlAfterRegistered));
    }

    @After
    public void teardown() {
        // Закрытие браузера
        closeWebDriver();
    }
}
