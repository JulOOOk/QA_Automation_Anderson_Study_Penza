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

import java.util.concurrent.TimeUnit;

public class YandexTest {

    WebDriver browser;

    @BeforeSuite
    public void beforeSuite() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
    }

    @BeforeTest
    public void beforeTest() {
        browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        browser.get("https://ya.ru/");
    }

    @Test
    public void search() {
        WebElement searchInput = browser.findElement(By.name("text"));
        searchInput.clear();
        searchInput.sendKeys("погода пенза");
        WebElement searchButton = browser.findElement(By.className("button_theme_websearch"));
        searchButton.click();
        WebElement firstLink = browser.findElement(By.cssSelector("[accesskey='1']"));
        Assert.assertTrue(firstLink.getText().toLowerCase().contains("погода"), "О.Р. слово погода в первой строке результатов");
    }

    @AfterTest
    public void afterTest() {
        browser.quit();
    }
}
