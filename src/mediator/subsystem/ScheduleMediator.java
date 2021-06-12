package mediator.subsystem;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import composite_lessons.lessons.Lesson;

public class ScheduleMediator implements Mediator {
  private Handler differentSubgroupsHandler;
  private Handler differentWeeksHandler;
  private Handler oneSubgroupHandler;
  private Handler simpleLessonHandler;

  public void registerHandler(Handler handler) {
    handler.setMediator(this);
    switch(handler.getName()){
      case "DifferentSubgroups" -> differentSubgroupsHandler = handler;
      case "DifferentWeeks" -> differentWeeksHandler = handler;
      case "OneSubgroup" -> oneSubgroupHandler = handler;
      case "SimpleLesson" -> simpleLessonHandler = handler;
    }
  }

  public Lesson checkFor2Subgroups(WebElement element, int nr) {
    return differentSubgroupsHandler.handle(element, nr);
  }

  public Lesson checkFor1Subgroup(WebElement element, int nr) {
    return oneSubgroupHandler.handle(element, nr);
  }

  public Lesson checkForSimpleLesson(WebElement element, int nr) {
    return simpleLessonHandler.handle(element, nr);
  }
  
  public Lesson toLesson(WebElement element, int nr) {
    return differentWeeksHandler.handle(element, nr);
  }
  
  public int countPullLefts(WebElement element) {
    return element.findElements(By.className("pull-left")).size();
  }

}
