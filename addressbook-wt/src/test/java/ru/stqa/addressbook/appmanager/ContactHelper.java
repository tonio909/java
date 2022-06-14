package ru.stqa.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.addressbook.model.ContactData;
import java.util.*;

public class ContactHelper extends HelperBase{

    public ContactHelper (WebDriver wd) {
        super(wd);
    }

    public void goToContactPage() {
        click(By.xpath("//a[normalize-space()='home']"));
    }

    public void fillContactForm(ContactData cd) {
        click(By.xpath("//a[normalize-space()='add new']"));
        type(By.name("firstname"), cd.getFirstname());
        type(By.name("middlename"), cd.getMiddlename());
        type(By.name("lastname"), cd.getLastname());
        type(By.name("nickname"), cd.getNickname());
        type(By.name("title"), cd.getTitle());
        type(By.name("company"), cd.getCompany());
        type(By.name("address"), cd.getAddress());
        type(By.name("home"), cd.getHome());
        type(By.name("mobile"), cd.getMiddlename());
        type(By.name("work"), cd.getWork());
        type(By.name("fax"), cd.getFax());
        select(By.name("bday"), cd.getBday());
        select(By.name("bmonth"), cd.getBmonth());
        type(By.name("byear"), cd.getYear());
    }

    public void openExistingContact() {
        click(By.xpath("//tbody/tr[2]/td[8]/a[1]/img[1]"));
    }

    public void saveContactFormAndReturn(boolean update) {
        if (update) {
            wd.findElement(By.name("update")).click();
        } else {
            wd.findElement(By.name("submit")).click();
        }
        wd.findElement(By.xpath("//a[normalize-space()='home page']")).click();
    }

    public void selectContactByIndex(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }

    public void deleteContactAndAccept() {
        click(By.xpath("//input[@value='Delete']"));
        wd.switchTo().alert().accept();
    }

    public void createContact(ContactData cd) {
        fillContactForm(cd);
        saveContactFormAndReturn(false);
    }

    public List<ContactData> listOfContacts() {
        List<ContactData> contacts = new ArrayList<ContactData>();
        List<WebElement> contact = wd.findElements(By.name("entry"));
        for (WebElement cont : contact) {
            String name = cont.getText();
            ContactData cd = new ContactData(name, null, null, null,null,null,null,null,null,null,null,null,null,null);
            contacts.add(cd);
        }
        return contacts;
    }
}
