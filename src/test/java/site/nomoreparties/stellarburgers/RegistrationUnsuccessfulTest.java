package site.nomoreparties.stellarburgers;

import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.MatcherAssert;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.*;

public class RegistrationUnsuccessfulTest extends BaseCondition {

    @Test
    @DisplayName("check user with error password can not be registered")
    public void shouldNotBeRegistrationWithErrorPassword() {
        // Нажатие на кнопку "Личный кабинет"
        MainPage mainPage = page(MainPage.class);
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
        MainPage mainPage = page(MainPage.class);
        mainPage.clickOnPersonalAccount();
        // Нажатие на ссылку "Зарегистрироваться"
        LoginPage loginPage = page(LoginPage.class);
        loginPage.clickRegister();

        // Регистрация нового пользователя
        RegisterPage registerPage = page(RegisterPage.class)
                .registerUserWithEmptyPass();

        MatcherAssert.assertThat("User with error password can be registered",
                registerPage.showMessageErrorPassword());
    }

}
