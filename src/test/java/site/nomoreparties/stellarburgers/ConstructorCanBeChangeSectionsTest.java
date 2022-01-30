package site.nomoreparties.stellarburgers;

import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.*;

public class ConstructorCanBeChangeSectionsTest {
    MainPage mainPage = new MainPage();

    @Before
    public void before() {
        // Раскомментировать для теста в яндекс браузере
        // System.setProperty("webdriver.chrome.driver", "src/resources/yandexdriver.exe");
        mainPage = open(MainPage.URL, MainPage.class);
    }

    @Test
    @DisplayName("check to go to the bun section")
    public void canGoBunSectionTest() {
        mainPage.clickOnSauceSection();
        mainPage.clickOnBunSection();
        MatcherAssert.assertThat("Section can not be visible", mainPage.textFromMenuBunSection().equals(mainPage.sectionBun));
    }

    @Test
    @DisplayName("check to go to the sauces section")
    public void canGoSaucesSectionTest() {
        mainPage.clickOnSauceSection();
        MatcherAssert.assertThat("Section can not be visible", mainPage.textFromMenuSauceSection().equals(mainPage.sectionSauce));
    }

    @Test
    @DisplayName("check to go to the filling section")
    public void canGoFillingSectionTest() {
        mainPage.clickOnFillingSection();
        MatcherAssert.assertThat("Section can not be visible", mainPage.textFromMenuFillingSection().equals(mainPage.sectionFilling));
    }

    @After
    public void teardown() {
        // Закрытие браузера
        closeWebDriver();
    }
}
