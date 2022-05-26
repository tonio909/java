package ru.stqa.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperBase {
    public WebDriver wd;

    public HelperBase (WebDriver wd) {
        this.wd = wd;
    }

    public void type(By locator, String login) {
        wd.findElement(locator).click();
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(login);
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }
}
