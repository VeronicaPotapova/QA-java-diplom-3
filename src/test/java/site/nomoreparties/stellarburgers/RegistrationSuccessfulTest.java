package site.nomoreparties.stellarburgers;

import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.MatcherAssert;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.*;

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

        MatcherAssert.assertThat("New user can not registered",
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

        MatcherAssert.assertThat("New user can not registered",
                registerPage.urlAfterRegister().equalsIgnoreCase(registerPage.newUrlAfterRegistered));
    }

}
