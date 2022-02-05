package site.nomoreparties.stellarburgers.tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import site.nomoreparties.stellarburgers.BaseCondition;
import site.nomoreparties.stellarburgers.MainPage;

import static com.codeborne.selenide.Selenide.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class SwitchToConstructorFromPersonalAccountNotAuthUserTest extends BaseCondition {

    @Test
    @DisplayName("check switch to main page by link Constructor for not authorisation user")
    public void shouldBeSwitchToMainPageByLinkConstructorNotAuthUser() {
        // Нажатие на кнопку "Личный кабинет"
        MainPage mainPage = page(MainPage.class);
        mainPage.clickOnPersonalAccount();
        //Переход в конструктор
        mainPage.clickOnConstructorHeader();

        assertThat("Transfer to main page is not possible", mainPage.showAssembleBurger());
    }

    @Test
    @DisplayName("check switch to main page by logo for not authorisation user")
    public void shouldBeSwitchToMainPageByLogoNotAuthUser() {
        // Нажатие на кнопку "Личный кабинет"
        MainPage mainPage = page(MainPage.class);
        mainPage.clickOnPersonalAccount();
        //Переход в конструктор
        mainPage.clickOnLogoStellarBurgers();

        assertThat("Transfer to main page is not possible", mainPage.showAssembleBurger());
    }

}
