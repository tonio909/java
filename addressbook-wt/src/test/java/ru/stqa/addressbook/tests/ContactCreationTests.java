package ru.stqa.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() throws Exception {
        int beforeContactsCount = app.getContactHelper().listOfContacts().size();
        app.getContactHelper().createContact(new ContactData("Michael", "V", "Jackson", "MJ", "PopStar",
                "Music", "NY", "NY", "+19991111111",
                "+19992222222", "+19993333333", "1", "January", "1900"));

        int afterContactsCount = app.getContactHelper().listOfContacts().size();
        Assert.assertEquals(beforeContactsCount, afterContactsCount - 1, "1 contact added");
        app.logout();
    }
}
