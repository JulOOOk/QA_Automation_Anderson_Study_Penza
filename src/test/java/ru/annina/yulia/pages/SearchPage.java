package ru.annina.yulia.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchPage {

    WebDriver browser;
    private By searchInput = By.name("text");
    private By searchButton = By.className("button_theme_websearch");
    private By firstLink = By.cssSelector("[accesskey='1']");
    private By geolocationLink = By.className("geolink");
    private By geolocationInput = By.id("city__front-input");
    private By tabsMoreLink = By.cssSelector("[data-statlog='tabs.more']");
    private By tabsMoreList = By.className("home-tabs__more-item");

    public SearchPage(WebDriver browser) {
        this.browser = browser;
    }

    public void search(String text) {
        WebElement searchInput = browser.findElement(this.searchInput);
        searchInput.clear();
        searchInput.sendKeys(text);
        WebElement searchButton = browser.findElement(this.searchButton);
        searchButton.click();
    }

    public String getFirstLink() {
        WebElement firstLink = browser.findElement(this.firstLink);
        return firstLink.getText();
    }

    public void changeGeolocation(String text) {
        WebElement geolocationLink = browser.findElement(this.geolocationLink);
        geolocationLink.click();
        WebElement geolocationInput = browser.findElement(this.geolocationInput);
        geolocationInput.clear();
        geolocationInput.sendKeys(text);
        geolocationInput.submit();
    }

    public String[] getListMore() {
        WebElement tabsMoreLink = browser.findElement(this.tabsMoreLink);
        tabsMoreLink.click();
        List<WebElement> tabsMoreList = browser.findElements(this.tabsMoreList);
        String[] titlesMore = new String[tabsMoreList.size()];
        for (int i = 0; i < tabsMoreList.size(); i++) {
            WebElement tabsMore = tabsMoreList.get(i);
            titlesMore[i] = tabsMore.getText();
        }
        return titlesMore;
    }
}
