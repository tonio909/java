package ru.stqa.addressbook.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.addressbook.model.GroupData;

import java.util.List;

public class GroupModificationTests extends TestBase {

    @Test
    public void testGroupModification() {
        app.getNavigationHelper().goToGroupPage();
        if (app.getGroupHelper().isElementMissing(By.name("selected[]"))) {
            app.getGroupHelper().createGroup(new GroupData("GroupToDelete", "GroupHeaderToDelete", "GroupFiiterToDelete"));
        }
        List<GroupData> before = app.getGroupHelper().getGroupsList();
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupForm(new GroupData("GroupNameUpdated", "HeaderUpdated", "FooterUpdated"));
        app.getGroupHelper().submitGroupModification();
        app.getNavigationHelper().goToGroupPage();
        List<GroupData> after = app.getGroupHelper().getGroupsList();
        Assert.assertEquals(before.size(), after.size(), "1 group modified, groups count was not changed");
        app.logout();
    }
}
