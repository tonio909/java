package ru.stqa.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.addressbook.model.ContactData;

public class ContactDeletionTests extends TestBase{

    @Test
    public void testContactDeletion() {
        app.getContactHelper().goToContactPage();
        int beforeContactsCount = app.getContactHelper().listOfContacts().size();
        if (app.getContactHelper().isElementMissing(By.name("selected[]"))) {
            app.getContactHelper().createContact(new ContactData
                    ("Michael", "V", "Jackson", "MJ", "PopStar",
                            "Music", "NY", "NY", "+19991111111", "+19992222222",
                            "+19993333333", "1", "January", "1900"));
        }
        app.getContactHelper().selectContactByIndex(beforeContactsCount - 1);
        app.getContactHelper().deleteContactAndAccept();
        app.getContactHelper().goToContactPage();
        int afterContactsCount = app.getContactHelper().listOfContacts().size();
        Assert.assertEquals(afterContactsCount, beforeContactsCount - 1, "1 contact deleted");
        app.logout();
    }
}
