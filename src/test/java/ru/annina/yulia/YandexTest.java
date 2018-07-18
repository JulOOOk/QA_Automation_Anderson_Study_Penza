package ru.annina.yulia;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.annina.yulia.pages.SearchPage;

import java.util.concurrent.TimeUnit;

public class YandexTest extends BaseTest {

    SearchPage page;

    @BeforeTest
    @Override
    public void beforeTest() {
        super.beforeTest();
        browser.get("https://ya.ru/");
        page = new SearchPage(browser);
    }

    @Test
    public void search() {
        page.search("погода пенза");
        Assert.assertTrue(page.getFirstLink().toLowerCase().contains("погода"), "О.Р. слово погода в первой строке результатов");
    }
}
