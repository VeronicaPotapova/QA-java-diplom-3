package site.nomoreparties.stellarburgers.tests;

import com.UserOperations;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import site.nomoreparties.stellarburgers.*;

import java.util.Map;

import static com.codeborne.selenide.Selenide.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class AuthorizationUserTest extends BaseCondition {

    @Test
    @DisplayName("check authorization by button Log in to account")
    public void shouldBeAuthorizationByButtonLogInAccount() {
        // Создать пользователя
        UserOperations userOperations = new UserOperations();
        Map<String, String> userData = userOperations.register();
        String email = userData.get("email");
        String password = userData.get("password");

        // Нажатие на кнопку "Войти в аккаунт"
        MainPage mainPage = page(MainPage.class);
        mainPage.clickOnLogInAccount();

        // Авторизоваться
        LoginPage loginPage = page(LoginPage.class);
        loginPage.login(email, password);

        assertThat("Log in is not possible",
                mainPage.showButtonSetOrder());
    }

    @Test
    @DisplayName("check authorization by button Personal account")
    public void shouldBeAuthorizationByButtonPersonalAccount() {
        // Создать пользователя
        UserOperations userOperations = new UserOperations();
        Map<String, String> userData = userOperations.register();
        String email = userData.get("email");
        String password = userData.get("password");

        // Нажатие на кнопку "Личный кабинет"
        MainPage mainPage = page(MainPage.class);
        mainPage.clickOnLogInAccount();

        // Авторизоваться
        LoginPage loginPage = page(LoginPage.class);
        loginPage.login(email, password);

        assertThat("Log in is not possible",
                mainPage.showButtonSetOrder());
    }

    @Test
    @DisplayName("check authorization by button in form registration")
    public void shouldBeAuthorizationByButtonFormRegistration() {
        // Создать пользователя
        UserOperations userOperations = new UserOperations();
        Map<String, String> userData = userOperations.register();
        String email = userData.get("email");
        String password = userData.get("password");

        // Нажатие на кнопку "Личный кабинет"
        MainPage mainPage = page(MainPage.class);
        mainPage.clickOnLogInAccount();

        // Нажатие на ссылку "Зарегистрироваться"
        LoginPage loginPage = page(LoginPage.class);
        loginPage.clickRegister();

        // Нажатие на ссылку "Войти"
        RegisterPage registerPage = page(RegisterPage.class);
        registerPage.clickLogIn();

        // Авторизоваться
        loginPage.login(email, password);

        assertThat("Log in is not possible",
                mainPage.showButtonSetOrder());
    }

    @Test
    @DisplayName("check authorization by button in form password recovery")
    public void shouldBeAuthorizationByButtonFormPasswordRecovery() {
        // Создать пользователя
        UserOperations userOperations = new UserOperations();
        Map<String, String> userData = userOperations.register();
        String email = userData.get("email");
        String password = userData.get("password");

        // Нажатие на кнопку "Личный кабинет"
        MainPage mainPage = page(MainPage.class);
        mainPage.clickOnLogInAccount();

        // Нажатие на ссылку "Восстановить пароль"
        LoginPage loginPage = page(LoginPage.class);
        loginPage.clickPasswordRecovery();

        // Нажатие на ссылку "Войти"
        ForgotPassPage forgotPassPage = page(ForgotPassPage.class);
        forgotPassPage.clickLogIn();

        // Авторизоваться
        loginPage.login(email, password);

        assertThat("Log in is not possible",
                mainPage.showButtonSetOrder());
    }

}
