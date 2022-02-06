package site.nomoreparties.stellarburgers.tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import site.nomoreparties.stellarburgers.BaseCondition;
import site.nomoreparties.stellarburgers.LoginPage;
import site.nomoreparties.stellarburgers.MainPage;
import site.nomoreparties.stellarburgers.RegisterPage;

import static com.codeborne.selenide.Selenide.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class RegistrationSuccessfulTest extends BaseCondition {

    @Test
    @DisplayName("check to successful registration from link personal account")
    public void shouldBeSuccessfulRegistrationFromPersonalAccount() {
        // Нажатие на кнопку "Личный кабинет"
        MainPage mainPage = page(MainPage.class);
        mainPage.clickOnPersonalAccount();
        // Нажатие на ссылку "Зарегистрироваться"
        LoginPage loginPage = page(LoginPage.class);
        loginPage.clickRegister();

        // Регистрация нового пользователя
        RegisterPage registerPage = page(RegisterPage.class)
                .registerUser();

        assertThat("New user can not registered",
                registerPage.urlAfterRegister().equalsIgnoreCase(registerPage.newUrlAfterRegistered));
    }

    @Test
    @DisplayName("check to successful registration from button enter account")
    public void shouldBeSuccessfulRegistrationFromEnterAccount() {
        // Нажатие на кнопку "Войти в аккаунт"
        MainPage mainPage = page(MainPage.class);
        mainPage.clickOnPersonalAccount();
        // Нажатие на ссылку "Зарегистрироваться"
        LoginPage loginPage = page(LoginPage.class);
        loginPage.clickRegister();

        // Регистрация нового пользователя
        RegisterPage registerPage = page(RegisterPage.class)
                .registerUser();

        assertThat("New user can not registered",
                registerPage.urlAfterRegister().equalsIgnoreCase(registerPage.newUrlAfterRegistered));
    }

}
