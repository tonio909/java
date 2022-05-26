package ru.stqa.addressbook.tests;

import org.testng.annotations.*;

public class GroupDeletionTests extends TestBase {

    @Test
    public void testGroupCreation() throws Exception {
        app.goToGroupPage();
        app.getGroupHelper().deleteGroup();
        app.returnToGroupPageAndLogout();
    }
}
