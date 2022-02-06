package site.nomoreparties.stellarburgers;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.time.Duration;

public class MainPage {
    // Переменная, содержащая часть названия класса, при выборе раздела
    public String partOfNameClass = "tab_tab_type_current__2BEPc";
    // Переменная, содержащая названия раздела "Булки"
    public String sectionBuns = "Булки";
    // Переменная, содержащая названия раздела "Соусы"
    public String sectionSauces = "Соусы";
    // Переменная, содержащая названия раздела "Начинки"
    public String sectionFillings = "Начинки";

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
    private SelenideElement headerSectionBuns;
    // Локатор блока выбранного раздела "Булки"
    @FindBy(how = How.XPATH, using = ".//span[text()='Булки']/..")
    private SelenideElement headerSelectedSectionBuns;
    // Локатор блока "Булки"
    @FindBy(how = How.XPATH, using = ".//h2[text()='Булки']")
    private SelenideElement menuSectionBuns;
    // Локатор названия раздела "Соусы"
    @FindBy(how = How.XPATH, using = ".//span[text()='Соусы']")
    private SelenideElement headerSectionSauces;
    // Локатор блока выбранного раздела "Соусы"
    @FindBy(how = How.XPATH, using = ".//span[text()='Соусы']/..")
    private SelenideElement headerSelectedSectionSauces;
    // Локатор блока "Соусы"
    @FindBy(how = How.XPATH, using = ".//h2[text()='Соусы']")
    private SelenideElement menuSectionSauces;
    // Локатор названия раздела "Начинки"
    @FindBy(how = How.XPATH, using = ".//span[text()='Начинки']")
    private SelenideElement headerSectionFillings;
    // Локатор блока выбранного раздела "Начинки"
    @FindBy(how = How.XPATH, using = ".//span[text()='Начинки']/..")
    private SelenideElement headerSelectedSectionFillings;
    // Локатор блока "Начинки"
    @FindBy(how = How.XPATH, using = ".//h2[text()='Начинки']")
    private SelenideElement menuSectionFillings;

    // Метод нажатия на кнопку "Личный кабинет"
    @Step("click on the \"Personal Account\" button")
    public void clickOnPersonalAccount() {
        personalAccount.shouldBe(Condition.enabled).click();
    }

    // Метод нажатия на кнопку "Войти в аккаунт"
    @Step("click on the \"Log in Account\" button")
    public void clickOnLogInAccount() {
        logInAccount.shouldBe(Condition.exist).shouldBe(Condition.enabled).click();
    }

    // Метод нажатия на ссылку "Конструктор" в меню
    @Step("click on the \"Constructor\"")
    public void clickOnConstructorHeader() {
        constructorHeader.shouldBe(Condition.enabled).click();
    }

    // Метод нажатия на логотип Stellar Burgers
    @Step("click on the logo Stellar Burgers")
    public void clickOnLogoStellarBurgers() {
        logoStellarBurgers.shouldBe(Condition.enabled).click();
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
    @Step("click on the section Buns")
    public void clickOnBunsSection() {
        headerSectionBuns.shouldBe(Condition.exist).click();
    }

    // Метод получения названия блока выбранного раздела Булки
    @Step("get classname from the section Buns")
    public String constructorBunsSection() {
        return headerSelectedSectionBuns.shouldBe(Condition.exist).toString();
    }

    // Метод отображения в конструкторе раздела Булки
    @Step("section Buns is displayed")
    public boolean displayedBunsSection() {
        return menuSectionBuns.shouldBe(Condition.visible).isDisplayed();
    }

    // Метод нажатия на раздел Соусы
    @Step("click on the section Sauces")
    public void clickOnSaucesSection() {
        headerSectionSauces.shouldBe(Condition.exist).click();
    }

    // Метод получения названия блока выбранного раздела Соусы
    @Step("get classname from the section Sauces")
    public String constructorSaucesSection() {
        return headerSelectedSectionSauces.shouldBe(Condition.exist).toString();
    }

    // Метод отображения в конструкторе раздела Соусы
    @Step("section Sauces is displayed")
    public boolean displayedSaucesSection() {
        return menuSectionSauces.shouldBe(Condition.visible).isDisplayed();
    }

    // Метод проекрутки до раздела Соусы
    @Step("scroll to section Sauces")
    public void scrollSaucesSection() {
        menuSectionSauces.scrollTo();
    }

    // Метод нажатия на раздел Начинки
    @Step("click on the section Fillings")
    public void clickOnFillingsSection() {
        headerSectionFillings.shouldBe(Condition.exist).click();
    }

    // Метод получения названия блока выбранного раздела Начинки
    @Step("get classname from the section Fillings")
    public String constructorFillingsSection() {
        return headerSelectedSectionFillings.shouldBe(Condition.exist).toString();
    }

    // Метод отображения в конструкторе раздела Начинки
    @Step("section Fillings is displayed")
    public boolean displayedFillingSection() {
        return menuSectionFillings.shouldBe(Condition.visible).isDisplayed();
    }
}
