package site.nomoreparties.stellarburgers;

import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.*;

public class SwitchToPersonalAccountNotAuthUserTest {
    MainPage mainPage = new MainPage();

    @Before
    public void before() {
        // Раскомментировать для теста в яндекс браузере
        // System.setProperty("webdriver.chrome.driver", "src/resources/yandexdriver.exe");
        mainPage = open(MainPage.URL, MainPage.class);
    }

    @Test
    @DisplayName("check switch to personal account for not authorisation user")
    public void shouldBeSwitchToPersonalAccountNotAuthUser() {
        // Нажатие на кнопку "Личный кабинет"
        mainPage.clickOnPersonalAccount();
        LoginPage loginPage = page(LoginPage.class);
        MatcherAssert.assertThat("Transfer to personal account is not possible", loginPage.showLoginButton());
    }

    @After
    public void teardown() {
        // Закрытие браузера
        closeWebDriver();
    }
}
