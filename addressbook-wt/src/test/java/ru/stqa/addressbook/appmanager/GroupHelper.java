package ru.stqa.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.addressbook.model.GroupData;

public class GroupHelper {
    private WebDriver wd;

    public GroupHelper(WebDriver wd) {
        this.wd = wd;
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
}
