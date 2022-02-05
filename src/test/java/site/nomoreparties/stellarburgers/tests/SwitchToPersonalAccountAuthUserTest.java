package site.nomoreparties.stellarburgers.tests;

import com.UserOperations;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import site.nomoreparties.stellarburgers.AccountPage;
import site.nomoreparties.stellarburgers.BaseCondition;
import site.nomoreparties.stellarburgers.LoginPage;
import site.nomoreparties.stellarburgers.MainPage;

import java.util.Map;

import static com.codeborne.selenide.Selenide.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class SwitchToPersonalAccountAuthUserTest extends BaseCondition {

    @Test
    @DisplayName("check switch to personal account for authorisation user")
    public void shouldBeSwitchToPersonalAccountAuthUser() {
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
        AccountPage accountPage = page(AccountPage.class);

        assertThat("Transfer to personal account is not possible",
                accountPage.showProfile());
    }

}
