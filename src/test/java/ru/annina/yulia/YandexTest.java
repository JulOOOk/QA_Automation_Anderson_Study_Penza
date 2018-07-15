package ru.annina.yulia;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class YandexTest {

    @Test
    public void search() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        browser.get("https://ya.ru/");

        WebElement searchInput = browser.findElement(By.name("text"));
        searchInput.clear();
        searchInput.sendKeys("погода пенза");
        WebElement fistSearchText = browser.findElement(By.className("suggest2-item__text"));
        Assert.assertTrue(fistSearchText.getText().contains("пенза"), "О.Р. слово пенза в первой строке");

        browser.quit();
    }
}
