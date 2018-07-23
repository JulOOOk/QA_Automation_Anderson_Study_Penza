package ru.annina.yulia.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import ru.annina.yulia.pages.SearchPage;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    WebDriver browser;

    @BeforeSuite
    public void beforeSuite() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
    }

    @BeforeClass
    public void beforeClass() {
        browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @AfterClass
    public void afterClass() {
        browser.quit();
    }
}