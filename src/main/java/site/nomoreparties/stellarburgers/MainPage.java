package site.nomoreparties.stellarburgers;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.time.Duration;

public class MainPage {
    // URL тестового стенда
    public static final String URL = "https://stellarburgers.nomoreparties.site/";

    // Локатор ссылки "Личный кабинет"
    @FindBy(how = How.XPATH, using = ".//a[contains(@href,'/account')]")
    private SelenideElement personalAccount;
    // Локатор кнопки "Войти в аккаунт"
    @FindBy(how = How.XPATH, using = ".//button[text()='Войти в аккаунт']")
    private SelenideElement logInAccount;

    // Локатор ссылки "Конструктор" в меню
    @FindBy(how = How.XPATH, using = "(.//a[contains(@class,'AppHeader_header__link__3D_hX')])[1]")
    private SelenideElement constructorHeader;
    // Локатор логотип Stellar Burgers
    @FindBy(how = How.CLASS_NAME, using = "AppHeader_header__logo__2D0X2")
    private SelenideElement logoStellarBurgers;
    // Локатор надписи "Соберите бургер"
    @FindBy(how = How.XPATH, using = ".//h1[text()='Соберите бургер']")
    private SelenideElement assembleBurger;

    // Локатор кнопки "Оформить заказ"
    @FindBy(how = How.XPATH, using = ".//button[text()='Оформить заказ']")
    private SelenideElement setOrder;

    // Локатор названия раздела "Булки"
    @FindBy(how = How.XPATH, using = ".//span[text()='Булки']")
    private SelenideElement headerSectionBun;
    // Локатор блока "Булки"
    @FindBy(how = How.XPATH, using = ".//h2[text()='Булки']")
    private SelenideElement menuSectionBun;
    // Переменная, содержащая названия раздела "Булки"
    public String sectionBun = "Булки";

    // Локатор названия раздела "Соусы2
    @FindBy(how = How.XPATH, using = ".//span[text()='Соусы']")
    private SelenideElement headerSectionSauce;
    // Локатор блока "Соусы"
    @FindBy(how = How.XPATH, using = ".//h2[text()='Соусы']")
    private SelenideElement menuSectionSauce;
    // Переменная, содержащая названия раздела "Соусы"
    public String sectionSauce = "Соусы";

    // Локатор названия раздела "Начинки"
    @FindBy(how = How.XPATH, using = ".//span[text()='Начинки']")
    private SelenideElement headerSectionFilling;
    // Локатор блока "Начинки"
    @FindBy(how = How.XPATH, using = ".//h2[text()='Начинки']")
    private SelenideElement menuSectionFilling;
    // Переменная, содержащая названия раздела "Начинки"
    public String sectionFilling = "Начинки";

    // Метод нажатия на кнопку "Личный кабинет"
    @Step("click on the \"Personal Account\" button")
    public void clickOnPersonalAccount() {
        personalAccount.shouldBe(Condition.exist).click();
    }

    // Метод нажатия на кнопку "Войти в аккаунт"
    @Step("click on the \"Log in Account\" button")
    public void clickOnLogInAccount() {
        logInAccount.shouldBe(Condition.exist).click();
    }

    // Метод нажатия на ссылку "Конструктор" в меню
    @Step("click on the \"Constructor\"")
    public void clickOnConstructorHeader() {
        constructorHeader.shouldBe(Condition.exist).click();
    }

    // Метод нажатия на логотип Stellar Burgers
    @Step("click on the logo Stellar Burgers")
    public void clickOnLogoStellarBurgers() {
        logoStellarBurgers.shouldBe(Condition.exist).click();
    }

    // Метод поиска на странице надписи "Соберите бургер"
    @Step("search on the page \"Assemble burger\"")
    public boolean showAssembleBurger() {
        return assembleBurger.shouldBe(Condition.exist, Duration.ofSeconds(3)).exists();
    }

    // Метод поиска на странице кнопки "Оформить заказ"
    @Step("search on the page button \"Set order\"")
    public boolean showButtonSetOrder() {
        return setOrder.shouldBe(Condition.exist, Duration.ofSeconds(3)).exists();
    }

    // Метод нажатия на раздел Булки
    @Step("click on the section Bun")
    public void clickOnBunSection() {
        headerSectionBun.click();
    }

    // Метод получения текста в конструкторе после прокрутки на раздел Булки
    @Step("take text from menu in the section Bun")
    public String textFromMenuBunSection() {
        return menuSectionBun.shouldBe(Condition.visible).getText();
    }

    // Метод нажатия на раздел Соусы
    @Step("click on the section Sauce")
    public void clickOnSauceSection() {
        headerSectionSauce.click();
    }

    // Метод получения текста в конструкторе после прокрутки на раздел Соусы
    @Step("take text from menu in the section Sauce")
    public String textFromMenuSauceSection() {
        return menuSectionSauce.shouldBe(Condition.visible).getText();
    }

    // Метод нажатия на раздел Начинки
    @Step("click on the section Filling")
    public void clickOnFillingSection() {
        headerSectionFilling.click();
    }

    // Метод получения текста в конструкторе после прокрутки на раздел Начинки
    @Step("take text from menu in the section Filling")
    public String textFromMenuFillingSection() {
        return menuSectionFilling.shouldBe(Condition.visible).getText();
    }
}
