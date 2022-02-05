package site.nomoreparties.stellarburgers.tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import site.nomoreparties.stellarburgers.BaseCondition;
import site.nomoreparties.stellarburgers.LoginPage;
import site.nomoreparties.stellarburgers.MainPage;

import static com.codeborne.selenide.Selenide.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class SwitchToPersonalAccountNotAuthUserTest extends BaseCondition {

    @Test
    @DisplayName("check switch to personal account for not authorisation user")
    public void shouldBeSwitchToPersonalAccountNotAuthUser() {
        // Нажатие на кнопку "Личный кабинет"
        MainPage mainPage = page(MainPage.class);
        mainPage.clickOnPersonalAccount();
        LoginPage loginPage = page(LoginPage.class);

        assertThat("Transfer to personal account is not possible", loginPage.showLoginButton());
    }

}
