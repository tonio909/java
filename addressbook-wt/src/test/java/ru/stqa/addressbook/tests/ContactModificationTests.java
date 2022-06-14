package ru.stqa.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() {
        app.getContactHelper().goToContactPage();
        if (app.getContactHelper().isElementMissing(By.name("selected[]"))) {
            app.getContactHelper().createContact(new ContactData
                    ("Michael", "V", "Jackson", "MJ", "PopStar",
                            "Music", "NY", "NY", "+19991111111", "+19992222222",
                            "+19993333333", "1", "January", "1900"));
        }
        int beforeContactsCount = app.getContactHelper().listOfContacts().size();
        app.getContactHelper().openExistingContact();
        app.getContactHelper().fillContactForm(new ContactData("Michael_Upd", "V_Upd", "Jackson_Upd", "MJ_Upd", "PopStar_Upd", "Music_Upd", "NY_Upd", "NY_Upd", "+19997777777", "+19998888888", "+19999999999", "31", "December", "1999"));
        app.getContactHelper().saveContactFormAndReturn(true);
        app.getContactHelper().goToContactPage();
        int afterContactsCount = app.getContactHelper().listOfContacts().size();
        Assert.assertEquals(afterContactsCount, beforeContactsCount, "1 contact modified, contacts count was not changed");
        app.logout();
    }
}
