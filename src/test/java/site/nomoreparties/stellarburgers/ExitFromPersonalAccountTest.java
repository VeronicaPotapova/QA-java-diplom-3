package site.nomoreparties.stellarburgers;

import com.UserOperations;
import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.MatcherAssert;
import org.junit.Test;

import java.util.Map;

import static com.codeborne.selenide.Selenide.*;

public class ExitFromPersonalAccountTest extends BaseCondition {

    @Test
    @DisplayName("check exit from personal account")
    public void shouldBeExitFromPersonalAccount() {
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

        // Нажатие на кнопку "Выход"
        AccountPage accountPage = page(AccountPage.class);
        accountPage.clickExitLink();

        MatcherAssert.assertThat("Exit from personal account is not possible",
                loginPage.showLoginButton());
    }

}
