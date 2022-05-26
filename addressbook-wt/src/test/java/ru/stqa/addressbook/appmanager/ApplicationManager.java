package ru.stqa.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ApplicationManager {
    public WebDriver wd;
    public NavigationHelper navigationHelper;
    public GroupHelper groupHelper;
    public SessionHelper sessionHelper;

    public void init() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        wd = new ChromeDriver();
        groupHelper = new GroupHelper(wd);
        navigationHelper = new NavigationHelper(wd);
        sessionHelper = new SessionHelper(wd);
        wd.get("http://localhost/addressbook/");
        sessionHelper.login("admin", "secret");
    }

    public void stop() {
        wd.quit();
    }

    public void returnToGroupPageAndLogout() {
        wd.findElement(By.linkText("groups")).click();
        wd.findElement(By.linkText("Logout")).click();
    }

    ///getters
    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }
}
