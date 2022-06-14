package ru.stqa.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.addressbook.model.GroupData;
import java.util.ArrayList;
import java.util.List;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() throws Exception {
        app.getNavigationHelper().goToGroupPage();
        int before = app.getGroupHelper().getGroupsList().size();
        app.getGroupHelper().createGroup(new GroupData(null,"GroupName", "GroupHeader", "GroupFooter"));
        app.getNavigationHelper().goToGroupPage();
        int after = app.getGroupHelper().getGroupsList().size();
        Assert.assertEquals(before + 1, after, "1 group added");
        app.logout();
    }
}
