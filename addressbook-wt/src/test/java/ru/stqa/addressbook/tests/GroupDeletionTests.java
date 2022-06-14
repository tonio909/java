package ru.stqa.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.addressbook.model.GroupData;

import java.util.List;

public class GroupDeletionTests extends TestBase {

    @Test
    public void testGroupCreation() throws Exception {
        app.getNavigationHelper().goToGroupPage();
        if (app.getGroupHelper().isElementMissing(By.name("selected[]"))) {
            app.getGroupHelper().createGroup(new GroupData(null,"GroupToDelete", "GroupHeaderToDelete", "GroupFooterToDelete"));
        }
        List<GroupData> before = app.getGroupHelper().getGroupsList();
        app.getGroupHelper().deleteGroup(0);
        app.getNavigationHelper().goToGroupPage();
        List<GroupData> after = app.getGroupHelper().getGroupsList();
        Assert.assertEquals(before.size(), after.size() + 1, "1 group deleted");

        before.remove(before.size() - 1);
        Assert.assertEquals(before, after, "test");

        app.logout();
    }
}
