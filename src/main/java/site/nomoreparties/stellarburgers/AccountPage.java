package site.nomoreparties.stellarburgers;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AccountPage {
    // Локатор ссылки "Профиль"
    @FindBy(how = How.XPATH, using = ".//a[contains(@href,'/account/profile')]")
    public SelenideElement profileUser;
    // Локатор ссылки "Выход"
    @FindBy(how = How.XPATH, using = ".//button[text()='Выход']")
    private SelenideElement exitLink;

    // Метод поиска на странице ссылки "Профиль"
    @Step("search on the page \"Profile\"")
    public boolean showProfile() {
        return profileUser.shouldBe(Condition.exist).exists();
    }

    // Метод нажатия на ссылку "Выход"
    @Step("click on the \"Exit\"")
    public void clickExitLink() {
        exitLink.shouldBe(Condition.enabled).click();
    }
}
