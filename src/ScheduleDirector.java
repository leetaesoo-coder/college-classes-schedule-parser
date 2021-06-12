import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import composite_lessons.Schedule;
import mediator.ScheduleParser;

/* it parses the data from the website and turn it into a Schedule Object
* stiu ca numele nu cam e la tema dar deamu nu stiu cum sa mai numesc clasele astea))
*/

public class ScheduleDirector {
  ScheduleDriver driver;

  ScheduleDirector() {
    this.driver = ScheduleDriver.getInstance();
  }

  public void get(String groupName, int waitTime) {
    driver.get();
    driver.insertGroupName(groupName, waitTime);
  }

  // parsea randurile din orarul de site
  private List<WebElement> parseTableRows() {
    WebElement table = driver.findElementByCssSelector("table");
        
    return table.findElements(By.tagName("tr"));
  }

  public Schedule getSchedule() {
    List<WebElement> trs = parseTableRows();
    Schedule schedule = ScheduleParser.toSchedule(trs);

    // quit driver because we no longer need it
    driver.quit();

    return schedule;
  }

}
