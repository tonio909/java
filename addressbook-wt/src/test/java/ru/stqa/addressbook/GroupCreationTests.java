package ru.stqa.addressbook;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class GroupCreationTests {
  private WebDriver wd;

  @BeforeMethod(alwaysRun = true)
  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    wd = new ChromeDriver();
    wd.get("http://localhost/addressbook/");
    login("admin", "secret");
  }

  private void login(String login, String password) {
    wd.findElement(By.xpath("//input[@name='user']")).sendKeys(login);
    wd.findElement(By.xpath("//input[@name='pass']")).sendKeys(password);
    wd.findElement(By.xpath("//input[@value='Login']")).click();
  }

  @Test
  public void testGroupCreation1() throws Exception {
    goToGroupPage();
    initGroupCreation();
    fillGroupForm(new GroupData("Gname", "Gheader", "Gfooter"));
    returnToGroupPageAndLogout();
  }

  private void goToGroupPage() {
    wd.findElement(By.linkText("groups")).click();
  }

  private void initGroupCreation() {
    wd.findElement(By.name("new")).click();
  }

  private void fillGroupForm(GroupData gd) {
    wd.findElement(By.name("group_name")).sendKeys(gd.getName());
    wd.findElement(By.name("group_header")).sendKeys(gd.getHeader());
    wd.findElement(By.name("group_footer")).sendKeys(gd.getFooter());
    wd.findElement(By.name("submit")).click();
  }

  private void returnToGroupPageAndLogout() {
    wd.findElement(By.linkText("group page")).click();
    wd.findElement(By.linkText("Logout")).click();
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown() throws Exception {
    wd.quit();
  }
}
