package ru.stqa.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.addressbook.model.GroupData;

public class GroupDeletionTests extends TestBase {

    @Test
    public void testGroupCreation() throws Exception {
        app.getNavigationHelper().goToGroupPage();
        int before = app.getGroupHelper().getGroupsList().size();
        if (app.getGroupHelper().isElementMissing(By.name("selected[]"))) {
            app.getGroupHelper().createGroup(new GroupData("GroupToDelete", "GroupHeaderToDelete", "GroupFiiterToDelete"));
        }
        app.getGroupHelper().deleteGroup(0);
        app.getNavigationHelper().goToGroupPage();
        int after = app.getGroupHelper().getGroupsList().size();
        Assert.assertEquals(before - 1, after, "1 group deleted");
        app.logout();
    }
}
