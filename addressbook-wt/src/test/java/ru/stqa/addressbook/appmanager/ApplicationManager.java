package ru.stqa.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class ApplicationManager {

    private final GroupHelper groupHelper = new GroupHelper();

    public void init() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        groupHelper.wd = new ChromeDriver();
        groupHelper.wd.get("http://localhost/addressbook/");
        login("admin", "secret");
    }

    public void stop() {
        groupHelper.wd.quit();
    }

    public void login(String login, String password) {
        groupHelper.wd.findElement(By.xpath("//input[@name='user']")).sendKeys(login);
        groupHelper.wd.findElement(By.xpath("//input[@name='pass']")).sendKeys(password);
        groupHelper.wd.findElement(By.xpath("//input[@value='Login']")).click();
    }

    public void goToGroupPage() {
        groupHelper.wd.findElement(By.linkText("groups")).click();
    }

    public void returnToGroupPageAndLogout() {
        groupHelper.wd.findElement(By.linkText("groups")).click();
        groupHelper.wd.findElement(By.linkText("Logout")).click();
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }
}
