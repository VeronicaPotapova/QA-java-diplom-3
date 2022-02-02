package site.nomoreparties.stellarburgers;

import org.junit.After;
import org.junit.Before;
import com.UserOperations;
import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class BaseCondition {
    // URL тестового стенда
    public static final String URL = "https://stellarburgers.nomoreparties.site/";

    @Before
    // Переход на страницу тестового стенда
    public void beforeMethod() {
        Configuration.startMaximized = true;
        //  Раскомментировать для теста в яндекс браузере
        //  System.setProperty("webdriver.chrome.driver", "src/resources/yandexdriver.exe");
        open(URL);
    }

    @After

    public void afterMethod() {
        // Удаление пользователя (при необходимости)
        if (new UserOperations().register() != null) {
            new UserOperations().delete();
        }
        // Закрытие браузера
        closeWebDriver();
    }
}
