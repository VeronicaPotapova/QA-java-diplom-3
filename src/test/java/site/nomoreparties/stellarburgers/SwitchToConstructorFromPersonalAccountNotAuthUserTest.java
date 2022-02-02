package site.nomoreparties.stellarburgers;

import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.MatcherAssert;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.*;

public class SwitchToConstructorFromPersonalAccountNotAuthUserTest extends BaseCondition {

    @Test
    @DisplayName("check switch to main page by link Constructor for not authorisation user")
    public void shouldBeSwitchToMainPageByLinkConstructorNotAuthUser() {
        // Нажатие на кнопку "Личный кабинет"
        MainPage mainPage = page(MainPage.class);
        mainPage.clickOnPersonalAccount();
        //Переход в конструктор
        mainPage.clickOnConstructorHeader();

        MatcherAssert.assertThat("Transfer to main page is not possible", mainPage.showAssembleBurger());
    }

    @Test
    @DisplayName("check switch to main page by logo for not authorisation user")
    public void shouldBeSwitchToMainPageByLogoNotAuthUser() {
        // Нажатие на кнопку "Личный кабинет"
        MainPage mainPage = page(MainPage.class);
        mainPage.clickOnPersonalAccount();
        //Переход в конструктор
        mainPage.clickOnLogoStellarBurgers();

        MatcherAssert.assertThat("Transfer to main page is not possible", mainPage.showAssembleBurger());
    }

}
