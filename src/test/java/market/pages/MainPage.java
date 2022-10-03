package market.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class MainPage {

    private SelenideElement
            searchField = $("#search-field"),
            searchButton = $(".btn-mt-search"),
            showButton = $(".btn-mr-search"),
            searchPage = $(".search-page"),
            goods = $("#goods"),
            searchDropdown1 = $$(".text").first(),
            electronics = $(byText("Электроника")),
            phonesAndGadgets = $(byText("Телефоны, гаджеты")),
            smartwatches = $(byText("Смарт-часы")),
            personalClothes = $(byText("Личные вещи")),
            clothes = $(byText("Одежда")),
            hobbies = $(".hobby-otdyh"),
            travels = $(byText("Путешествия")),
            krishaButton = $$(".header-nav-logo-links__link").get(1),
            freeCheckBox = $$(".fi-check-big").first(),
            priceValue = $$(".a-card__price").first();


    @Step("Открываем страницу")
    public MainPage openPage() {
        open(Configuration.baseUrl);

        return this;
    }

    @Step("Ввод значения \"{value}\" в строку поиска")
    public MainPage search(final String value) {
        searchField.click();
        searchField.setValue(value);

        return this;
    }

    @Step("Нажать на кнопку поиска")
    public MainPage clickOnSearchButton() {
        searchButton.click();

        return this;
    }

    @Step("Нажать на кнопку \"Показать\"")
    public MainPage clickOnShowButton() {
        showButton.click();

        return this;
    }

    @Step("Проверяем заголовок по запросу \"{value}\"")
    public MainPage checkSearchPageContainsValue(final String value) {
        searchPage.shouldHave(Condition.text(value + " в Казахстане"));

        return this;
    }

    @Step("Проверяем цену \"{value}\"")
    public MainPage checkPriceContainsValue(final String value) {
        priceValue.shouldHave(Condition.text(value));

        return this;
    }

    @Step("Проверяем отображение объявлений по запросу \"{value}\"")
    public MainPage checkItemsContainsValue(final String value) {
        goods.shouldHave(Condition.text(value));

        return this;
    }


    @Step("Открыть выбор города или региона")
    public MainPage openChapter() {
        searchDropdown1.click();

        return this;
    }


    @Step("Проверяем отображение категории \"Смарт-часы\"")
    public MainPage checkCategory() {
        electronics.hover();
        phonesAndGadgets.hover();
        smartwatches.shouldBe(Condition.visible);

        return this;
    }

    @Step("Открыть категорию \"Путешествия\"")
    public MainPage openCategoryTravels() {
        hobbies.hover();
        travels.click();
        searchPage.shouldHave(Condition.text("Товары для путешествия в Казахстане"));

        return this;
    }

    @Step("Открыть категорию \"Одежда\"")
    public MainPage openCategoryClothes() {
        personalClothes.hover();
        clothes.click();
        searchPage.shouldHave(Condition.text("Купить одежду в Казахстане"));

        return this;
    }

    @Step("Отметить чек-бокс \"Бесплатно\"")
    public MainPage clickOnFreeCheckBox() {
        freeCheckBox.click();

        return this;
    }

    @Step("Открыть сайт \"Krisha.kz\"")
    public MainPage openKrisha() {
        krishaButton.click();
        webdriver().shouldHave(url("https://krisha.kz/"));

        return this;
    }
}