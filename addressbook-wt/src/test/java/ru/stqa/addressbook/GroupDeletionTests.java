package ru.stqa.addressbook;

import org.testng.annotations.*;

public class GroupDeletionTests extends TestBase {

    @Test
    public void testGroupCreation() throws Exception {
        goToGroupPage();
        deleteGroup();
        returnToGroupPageAndLogout();
    }
}
