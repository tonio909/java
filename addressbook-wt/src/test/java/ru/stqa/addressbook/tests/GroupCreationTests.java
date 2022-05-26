package ru.stqa.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.addressbook.model.GroupData;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() throws Exception {
        app.goToGroupPage();
        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillGroupForm(new GroupData("GroupName", "GroupHeader", "GroupFooter"));
        app.getGroupHelper().deleteGroup();
        app.returnToGroupPageAndLogout();
    }
}
