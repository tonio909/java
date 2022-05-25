package ru.stqa.addressbook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    public WebDriver wd;

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        wd = new ChromeDriver();
        wd.get("http://localhost/addressbook/");
        login("admin", "secret");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() throws Exception {
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

    public void initGroupCreation() {
        wd.findElement(By.name("new")).click();
    }

    public void fillGroupForm(GroupData gd) {
        wd.findElement(By.name("group_name")).sendKeys(gd.getName());
        wd.findElement(By.name("group_header")).sendKeys(gd.getHeader());
        wd.findElement(By.name("group_footer")).sendKeys(gd.getFooter());
        wd.findElement(By.name("submit")).click();
        wd.findElement(By.linkText("groups")).click();
    }

    public void deleteGroup() {
        wd.findElement(By.name("selected[]")).click();
        wd.findElement(By.name("delete")).click();
    }

    public void returnToGroupPageAndLogout() {
        wd.findElement(By.linkText("groups")).click();
        wd.findElement(By.linkText("Logout")).click();
    }
}
