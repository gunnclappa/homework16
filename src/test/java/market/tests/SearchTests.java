package market.tests;

import market.pages.MainPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;

public class SearchTests extends TestBase {

    @Test
    @DisplayName("Проверка поиска объявлений")
    @Story("market.kz Tests")
    @Owner("Kayrat")
    @Link(value = "market.kz", url = "https://market.kz/")
    void searchTest() {
        String searchValue = "iphone 13";
        MainPage mainPage = new MainPage();

        mainPage.openPage()
                .search(searchValue)
                .clickOnSearchButton()
                .checkSearchPageContainsValue(searchValue)
                .checkItemsContainsValue(searchValue);
    }

    @Test
    @DisplayName("Проверка существования категории \"Смарт-часы\"")
    @Story("market.kz Tests")
    @Owner("Kayrat")
    @Link(value = "market.kz", url = "https://market.kz/")
    void checkCategoryTest() {
        MainPage mainPage = new MainPage();

        mainPage.openPage()
                .openChapter()
                .checkCategory();
    }

    @Test
    @DisplayName("Проверка открытия категории \"Путешествия\"")
    @Story("market.kz Tests")
    @Owner("Kayrat")
    @Link(value = "market.kz", url = "https://market.kz/")
    void openCategoryTest() {
        MainPage mainPage = new MainPage();

        mainPage.openPage().
                openCategoryTravels();
    }

    @Test
    @DisplayName("Проверка открытия сайта \"Krisha.kz\"")
    @Story("market.kz Tests")
    @Owner("Kayrat")
    @Link(value = "market.kz", url = "https://market.kz/")
    void openKrishaTest() {
        MainPage mainPage = new MainPage();

        mainPage.openPage().
                openKrisha();
    }

    @Test
    @DisplayName("Проверка отображения бесплатных объявлений")
    @Story("market.kz Tests")
    @Owner("Kayrat")
    @Link(value = "market.kz", url = "https://market.kz/")
    void contractPriceTest() {
        String headerValue = "Одежда: отдам даром";
        String priceValue = "Отдам даром";
        MainPage mainPage = new MainPage();

        mainPage.openPage().
                openCategoryClothes()
                .clickOnFreeCheckBox()
                .clickOnShowButton()
                .checkSearchPageContainsValue(headerValue)
                .checkPriceContainsValue(priceValue);
    }
}
