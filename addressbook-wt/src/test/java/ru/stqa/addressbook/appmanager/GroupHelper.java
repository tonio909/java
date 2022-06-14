package ru.stqa.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.addressbook.model.GroupData;
import java.util.ArrayList;
import java.util.List;

public class GroupHelper extends HelperBase {

    public GroupHelper(WebDriver wd) {
        super(wd);
    }

    public void initGroupCreation() {
        click(By.name("new"));
    }

    public void initGroupModification() {
        click(By.name("edit"));
    }

    public void fillGroupForm(GroupData gd) {
        type(By.name("group_name"), gd.getName());
        type(By.name("group_header"), gd.getHeader());
        type(By.name("group_footer"), gd.getFooter());
    }

    public void submitGroupCreation() {
        click(By.name("submit"));
        click(By.linkText("groups"));
    }

    public void submitGroupModification() {
        click(By.name("update"));
    }

    public void deleteGroup(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
        click(By.name("delete"));
    }

    public void createGroup(GroupData gd) {
        initGroupCreation();
        fillGroupForm(gd);
        submitGroupCreation();
    }

    public List<GroupData> getGroupsList() {
        List<GroupData> gd = new ArrayList<GroupData>();
        List<WebElement> elementsOnPage = wd.findElements(By.xpath("//span[@class='group']"));
        for (WebElement elem : elementsOnPage) {
            String groupName = elem.getText();
            String elementValue = elem.getAttribute("value");
            GroupData groups = new GroupData(elementValue, groupName, null, null);
            gd.add(groups);
        }
        return gd;
    }
}
