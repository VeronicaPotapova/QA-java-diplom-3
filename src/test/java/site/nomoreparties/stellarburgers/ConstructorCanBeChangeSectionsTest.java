package site.nomoreparties.stellarburgers;

import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.MatcherAssert;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.*;

public class ConstructorCanBeChangeSectionsTest extends BaseCondition {

    @Test
    @DisplayName("check to go to the bun section")
    public void canGoBunSectionTest() {
        MainPage mainPage = page(MainPage.class);
        mainPage.clickOnSauceSection();
        mainPage.clickOnBunSection();

        MatcherAssert.assertThat("Section can not be visible", mainPage.displayedBunSection());
    }

    @Test
    @DisplayName("check to go to the sauces section")
    public void canGoSaucesSectionTest() {
        MainPage mainPage = page(MainPage.class);
        mainPage.clickOnSauceSection();

        MatcherAssert.assertThat("Section can not be visible", mainPage.displayedSauceSection());
    }

    @Test
    @DisplayName("check to go to the filling section")
    public void canGoFillingSectionTest() {
        MainPage mainPage = page(MainPage.class);
        mainPage.clickOnFillingSection();

        MatcherAssert.assertThat("Section can not be visible", mainPage.displayedFillingSection());
    }

}
