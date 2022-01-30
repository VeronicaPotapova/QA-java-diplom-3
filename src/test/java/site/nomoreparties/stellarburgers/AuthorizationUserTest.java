package site.nomoreparties.stellarburgers;

import com.UserOperations;
import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static com.codeborne.selenide.Selenide.*;

public class AuthorizationUserTest {
    MainPage mainPage = new MainPage();

    @Before
    public void before() {
        // Раскомментировать для теста в яндекс браузере
        // System.setProperty("webdriver.chrome.driver", "src/resources/yandexdriver.exe");
        mainPage = open(MainPage.URL, MainPage.class);
    }

    @Test
    @DisplayName("check authorization by button Log in to account")
    public void shouldBeAuthorizationByButtonLogInAccount() {
        // Создать пользователя
        UserOperations userOperations = new UserOperations();
        Map<String, String> userData = userOperations.register();
        String email = userData.get("email");
        String password = userData.get("password");

        // Нажатие на кнопку "Войти в аккаунт"
        mainPage.clickOnLogInAccount();

        // Авторизоваться
        LoginPage loginPage = page(LoginPage.class);
        loginPage.login(email, password);

        MatcherAssert.assertThat("Log in is not possible",
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
        mainPage.clickOnLogInAccount();

        // Авторизоваться
        LoginPage loginPage = page(LoginPage.class);
        loginPage.login(email, password);

        MatcherAssert.assertThat("Log in is not possible",
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
        mainPage.clickOnLogInAccount();

        // Нажатие на ссылку "Зарегистрироваться"
        LoginPage loginPage = page(LoginPage.class);
        loginPage.clickRegister();

        // Нажатие на ссылку "Войти"
        RegisterPage registerPage = page(RegisterPage.class);
        registerPage.clickLogIn();

        // Авторизоваться
        loginPage.login(email, password);

        MatcherAssert.assertThat("Log in is not possible",
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
        mainPage.clickOnLogInAccount();

        // Нажатие на ссылку "Восстановить пароль"
        LoginPage loginPage = page(LoginPage.class);
        loginPage.clickPasswordRecovery();

        // Нажатие на ссылку "Войти"
        ForgotPassPage forgotPassPage = page(ForgotPassPage.class);
        forgotPassPage.clickLogIn();

        // Авторизоваться
        loginPage.login(email, password);

        MatcherAssert.assertThat("Log in is not possible",
                mainPage.showButtonSetOrder());
    }

    @After
    public void teardown() {
        new UserOperations().delete();
        // Закрытие браузера
        closeWebDriver();
    }
}
