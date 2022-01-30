package site.nomoreparties.stellarburgers;

import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.*;

public class SwitchToConstructorFromPersonalAccountNotAuthUserTest {
    MainPage mainPage = new MainPage();

    @Before
    public void before() {
        // Раскомментировать для теста в яндекс браузере
        // System.setProperty("webdriver.chrome.driver", "src/resources/yandexdriver.exe");
        mainPage = open(MainPage.URL, MainPage.class);
    }

    @Test
    @DisplayName("check switch to main page by link Constructor for not authorisation user")
    public void shouldBeSwitchToMainPageByLinkConstructorNotAuthUser() {
        // Нажатие на кнопку "Личный кабинет"
        mainPage.clickOnPersonalAccount();
        //Переход в конструктор
        mainPage.clickOnConstructorHeader();

        MatcherAssert.assertThat("Transfer to main page is not possible", mainPage.showAssembleBurger());
    }

    @Test
    @DisplayName("check switch to main page by logo for not authorisation user")
    public void shouldBeSwitchToMainPageByLogoNotAuthUser() {
        // Нажатие на кнопку "Личный кабинет"
        mainPage.clickOnPersonalAccount();
        //Переход в конструктор
        mainPage.clickOnLogoStellarBurgers();

        MatcherAssert.assertThat("Transfer to main page is not possible", mainPage.showAssembleBurger());
    }

    @After
    public void teardown() {
        // Закрытие браузера
        closeWebDriver();
    }
}
