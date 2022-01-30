package site.nomoreparties.stellarburgers;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ForgotPassPage {
    // Локатор ссылки "Войти"
    @FindBy(how = How.XPATH, using = ".//a[contains(@href,'/login')]")
    private SelenideElement logIn;

    // Метод нажатия на ссылку "Войти"
    @Step("click on the \"Log in\"")
    public void clickLogIn() {
        logIn.shouldBe(Condition.exist).click();
    }
}
