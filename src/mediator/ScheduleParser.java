package mediator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;

import composite_lessons.Day;
import composite_lessons.Schedule;
import enums.Zi;

public class ScheduleParser {
  public static Schedule toSchedule(List<WebElement> trs) {
    HashMap<Zi, Day> map = new HashMap<>();
    
    ArrayList<Day> days = DayParser.toDays(trs);
    
    days.forEach(day -> map.put(day.getZi(), day));

    return new Schedule(map);
  }
}