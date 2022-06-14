package ru.stqa.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.addressbook.model.GroupData;

public class GroupModificationTests extends TestBase {

    @Test
    public void testGroupModification() {
        app.getNavigationHelper().goToGroupPage();
        int before = app.getGroupHelper().getGroupsList().size();
        if (app.getGroupHelper().isElementMissing(By.name("selected[]"))) {
            app.getGroupHelper().createGroup(new GroupData("GroupToDelete", "GroupHeaderToDelete", "GroupFiiterToDelete"));
        }
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupForm(new GroupData("GroupNameUpdated", "HeaderUpdated", "FooterUpdated"));
        app.getGroupHelper().submitGroupModification();
        app.getNavigationHelper().goToGroupPage();
        int after = app.getGroupHelper().getGroupsList().size();
        Assert.assertEquals(before, after, "1 group modified, groups count was not changed");
        app.logout();
    }
}
