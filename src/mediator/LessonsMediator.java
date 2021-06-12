package mediator;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;

import composite_lessons.lessons.Lesson;
import composite_lessons.lessons.NoLesson;
import mediator.subsystem.*;
import enums.Zi;

public class LessonsMediator {
  private static LessonsMediator instance;
  private ScheduleMediator scheduleMediator;
  private HourParser hourParser; 

  private HashMap<Integer, String> hours;

  private LessonsMediator(){
    this.scheduleMediator = new ScheduleMediator();
    scheduleMediator.registerHandler(new DifferentSubgroupsHandler());
    scheduleMediator.registerHandler(new DifferentWeeksHandler());
    scheduleMediator.registerHandler(new OneSubgroupHandler());
    scheduleMediator.registerHandler(new SimpleLessonHandler());

    hourParser = new HourParser();
  }

  public void setHours(List<WebElement> trs) {
    this.hours = hourParser.parseHours(trs);
  }

  public Lesson toLesson(WebElement element, int nr, Zi ziua) {
    if (hours != null) {
      Lesson lesson = scheduleMediator.toLesson(element, nr);
      lesson.setZi(ziua);
      lesson.setOra(hours.get(nr));
      return lesson;
    } 
    System.out.println("didn't call HourParser.setHours()");
    return new NoLesson();
  }

  public static LessonsMediator getInstance() {
    if (instance == null) 
      instance = new LessonsMediator();
    return instance;
  }
  
}
