package site.nomoreparties.stellarburgers.tests;

import com.UserOperations;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import site.nomoreparties.stellarburgers.BaseCondition;
import site.nomoreparties.stellarburgers.LoginPage;
import site.nomoreparties.stellarburgers.MainPage;

import java.util.Map;

import static com.codeborne.selenide.Selenide.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class SwitchToConstructorFromPersonalAccountAuthUserTest extends BaseCondition {

    @Test
    @DisplayName("check switch to main page by link Constructor for authorisation user")
    public void shouldBeSwitchToMainPageByLinkConstructorAuthUser() {
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

        // Нажатие на кнопку "Личный кабинет"
        mainPage.clickOnPersonalAccount();

        //Переход в конструктор
        mainPage.clickOnConstructorHeader();

        assertThat("Transfer to main page is not possible", mainPage.showAssembleBurger());
    }

    @Test
    @DisplayName("check switch to main page by logo for authorisation user")
    public void shouldBeSwitchToMainPageByLogoAuthUser() {
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

        // Нажатие на кнопку "Личный кабинет"
        mainPage.clickOnPersonalAccount();

        //Переход в конструктор
        mainPage.clickOnLogoStellarBurgers();

        assertThat("Transfer to main page is not possible", mainPage.showAssembleBurger());
    }

}
