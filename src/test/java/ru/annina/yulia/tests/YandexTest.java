package ru.annina.yulia.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.annina.yulia.pages.SearchPage;

public class YandexTest extends BaseTest {

    SearchPage searchPage;

    @BeforeTest
    @Override
    public void beforeClass() {
        super.beforeClass();
        browser.get("https://ya.ru/");
        searchPage = new SearchPage(browser);
    }

    @Test
    public void search() {
        searchPage.search("погода пенза");
        Assert.assertTrue(searchPage.getFirstLink().toLowerCase().contains("погода"), "О.Р. слово погода в первой строке результатов");
    }
}
