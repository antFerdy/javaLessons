package portalSk;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Login {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://portal.sk.kz/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testLogin() throws Exception {
    driver.get("https://portal.sk.kz/auth.php");
    driver.findElement(By.name("USER_PASSWORD")).clear();
    driver.findElement(By.name("USER_PASSWORD")).sendKeys("364251");
    driver.findElement(By.name("USER_LOGIN")).clear();
    driver.findElement(By.name("USER_LOGIN")).sendKeys("test3");
    driver.findElement(By.name("Login")).click();
    try {
      assertEquals("Живая лента", driver.findElement(By.id("pagetitle")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    // ERROR: Caught exception [Error: unknown strategy [class] for locator [class=user-block]]
    // ERROR: Caught exception [Error: unknown strategy [class] for locator [class=menu-popup-item user-menu-logOut]]
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
