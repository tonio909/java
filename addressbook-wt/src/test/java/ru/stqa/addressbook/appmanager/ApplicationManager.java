package ru.stqa.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

public class ApplicationManager {
    public WebDriver wd;
    public NavigationHelper navigationHelper;
    public GroupHelper groupHelper;
    public SessionHelper sessionHelper;
    public ContactHelper contactHelper;
    public String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public void init() {
         if (browser.equals(BrowserType.CHROME)) {
            wd = new ChromeDriver();
        } else if (browser.equals(BrowserType.FIREFOX)) {
             wd = new FirefoxDriver();
        } else if (browser.equals(BrowserType.EDGE)) {
             wd = new EdgeDriver();
        }
        groupHelper = new GroupHelper(wd);
        navigationHelper = new NavigationHelper(wd);
        sessionHelper = new SessionHelper(wd);
        contactHelper = new ContactHelper(wd);
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

    public void saveForm() {
        wd.findElement(By.name("submit")).click();
    }

    public void logout() {
        wd.findElement(By.xpath("//a[normalize-space()='Logout']")).click();
    }

    ///getters
    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public ContactHelper getContactHelper() {
        return contactHelper;
    }
}
