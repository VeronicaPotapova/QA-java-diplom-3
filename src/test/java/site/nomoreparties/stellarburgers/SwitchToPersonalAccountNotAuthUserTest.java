package site.nomoreparties.stellarburgers;

import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.MatcherAssert;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.*;

public class SwitchToPersonalAccountNotAuthUserTest extends BaseCondition {

    @Test
    @DisplayName("check switch to personal account for not authorisation user")
    public void shouldBeSwitchToPersonalAccountNotAuthUser() {
        // Нажатие на кнопку "Личный кабинет"
        MainPage mainPage = page(MainPage.class);
        mainPage.clickOnPersonalAccount();
        LoginPage loginPage = page(LoginPage.class);

        MatcherAssert.assertThat("Transfer to personal account is not possible", loginPage.showLoginButton());
    }

}
