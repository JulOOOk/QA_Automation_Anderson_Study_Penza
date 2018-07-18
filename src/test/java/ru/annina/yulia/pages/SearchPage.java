package ru.annina.yulia.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage {

    WebDriver browser;
    private By searchInput = By.name("text");
    private By searchButton = By.className("button_theme_websearch");
    private By firstLink = By.cssSelector("[accesskey='1']");

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
}
