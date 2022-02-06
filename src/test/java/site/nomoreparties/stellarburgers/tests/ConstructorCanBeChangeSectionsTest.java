package site.nomoreparties.stellarburgers.tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import site.nomoreparties.stellarburgers.BaseCondition;
import site.nomoreparties.stellarburgers.MainPage;

import static com.codeborne.selenide.Selenide.*;
import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class ConstructorCanBeChangeSectionsTest extends BaseCondition {

    @Test
    @DisplayName("check to go to the buns section")
    public void canGoBunsSectionTest() {
        MainPage mainPage = page(MainPage.class);
        mainPage.clickOnSaucesSection();
        mainPage.scrollSaucesSection();
        mainPage.clickOnBunsSection();

        assertThat("Section Buns can not be selected", mainPage.constructorBunsSection(),
                anyOf(containsString(mainPage.partOfNameClass)));
        assertThat("Section can not be visible", mainPage.displayedBunsSection());
    }

    @Test
    @DisplayName("check to go to the sauces section")
    public void canGoSaucesSectionTest() {
        MainPage mainPage = page(MainPage.class);
        mainPage.clickOnSaucesSection();

        assertThat("Section Sauces can not be selected", mainPage.constructorSaucesSection(),
                anyOf(containsString(mainPage.partOfNameClass)));
        assertThat("Section can not be visible", mainPage.displayedSaucesSection());
    }

    @Test
    @DisplayName("check to go to the fillings section")
    public void canGoFillingsSectionTest() {
        MainPage mainPage = page(MainPage.class);
        mainPage.clickOnFillingsSection();

        assertThat("Section Fillings can not be selected", mainPage.constructorFillingsSection(),
                anyOf(containsString(mainPage.partOfNameClass)));
        assertThat("Section can not be visible", mainPage.displayedFillingSection());
    }

}
