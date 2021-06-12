import org.openqa.selenium.WebElement;

public class ScheduleDriver {
  private Driver driver;
  private String URL = "https://orar.ceiti.md/"; 

  private ScheduleDriver () {
    this.driver = Driver.getInstance(this.URL);
  }

  public void get() {
    this.driver.get();
  }

  public void insertGroupName(String groupName, int waitTime) {
    WebElement input = driver.findElementByClassName("search__message");
    input.sendKeys(groupName);

    try {
        Thread.sleep(waitTime);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
  }

  public WebElement findElementByCssSelector(String cssSelector) {
    return this.driver.findElementByCssSelector(cssSelector);
  }

  public WebElement findElementByClassName(String className) {
    return this.driver.findElementByClassName(className);
  }

  public static ScheduleDriver getInstance() {
    return new ScheduleDriver();
  }

  public void quit() {
    this.driver.quit();
  }
}