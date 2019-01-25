package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

  private WebDriver wd;
  private WebDriverWait wait;

  private ContactHelper contactHelper;
  private SessionHelper sessionHelper;
  private NavigationHelper navigationHelper;
  private GroupHelper groupHelper;

  public void init() {
   wd = new ChromeDriver();
   wait = new WebDriverWait(wd, 30);
   wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
   wd.get("http://localhost/addressbook/");
   groupHelper = new GroupHelper(wd, wait);
   navigationHelper = new NavigationHelper(wd, wait);
   sessionHelper = new SessionHelper(wd, wait);
   contactHelper = new ContactHelper(wd, wait);

  sessionHelper.login("admin", "secret");
  }



  public void stop() {
    wd.quit();
  }

  public GroupHelper getGroupHelper() {
    return groupHelper;
  }

  public NavigationHelper getNavigationHelper() {
    return navigationHelper;
  }

  public ContactHelper getContactHelper() {
    return contactHelper;
  }

  public SessionHelper getSessionHelper() {
    return sessionHelper;
  }
}
