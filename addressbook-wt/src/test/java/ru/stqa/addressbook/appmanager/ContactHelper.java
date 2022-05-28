package ru.stqa.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.addressbook.model.ContactData;

public class ContactHelper extends HelperBase{

    public ContactHelper (WebDriver wd) {
        super(wd);
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

}
