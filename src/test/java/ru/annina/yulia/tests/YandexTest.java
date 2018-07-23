package ru.annina.yulia.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.annina.yulia.pages.SearchPage;

import java.util.HashMap;

public class YandexTest extends BaseTest {

    SearchPage searchPage;

    @BeforeClass
    @Override
    public void beforeClass() {
        super.beforeClass();
        searchPage = new SearchPage(browser);
    }

    @Test
    public void search() {
        browser.get("https://ya.ru/");
        searchPage.search("погода пенза");
        Assert.assertTrue(searchPage.getFirstLink().toLowerCase().contains("погода"), "О.Р. слово погода в первой строке результатов");
    }

    @Test
    public void checkGeolocationMore() {
        browser.get("https://yandex.ru/");
        searchPage.changeGeolocation("Новороссийск");
        String[] tabsFirstMore = searchPage.getListMore();
        searchPage.changeGeolocation("Сызрань");
        String[] tabsSecondMore = searchPage.getListMore();
        for (int i = 0; i < tabsFirstMore.length; i++) {
            Assert.assertEquals(tabsFirstMore[i], tabsSecondMore[i], "О.Р. название вкладок должны совпадать");
        }
    }
}
