package ru.stqa.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ApplicationManager {
    public WebDriver wd;
    public GroupHelper groupHelper;

    public void init() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        wd = new ChromeDriver();
        groupHelper = new GroupHelper(wd);
        wd.get("http://localhost/addressbook/");
        login("admin", "secret");
    }

    public void stop() {
        wd.quit();
    }

    public void login(String login, String password) {
        wd.findElement(By.xpath("//input[@name='user']")).sendKeys(login);
        wd.findElement(By.xpath("//input[@name='pass']")).sendKeys(password);
        wd.findElement(By.xpath("//input[@value='Login']")).click();
    }

    public void goToGroupPage() {
        wd.findElement(By.linkText("groups")).click();
    }

    public void returnToGroupPageAndLogout() {
        wd.findElement(By.linkText("groups")).click();
        wd.findElement(By.linkText("Logout")).click();
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }
}
