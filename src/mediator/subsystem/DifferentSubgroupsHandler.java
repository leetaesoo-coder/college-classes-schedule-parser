package mediator.subsystem;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import composite_lessons.lessons.DifferentSubgroupsLesson;
import composite_lessons.lessons.Lesson;

public class DifferentSubgroupsHandler implements Handler {
  private ScheduleMediator mediator;


  public Lesson handle(WebElement td, int nr) {
    Lesson lesson = null;

    ArrayList<WebElement> doubles = (ArrayList<WebElement>) td.findElements(By.className("student-data--double"));
    if (doubles.size() == 2) {
      Lesson lesson1 = mediator.checkFor1Subgroup(doubles.get(0), nr);
      Lesson lesson2 = mediator.checkFor1Subgroup(doubles.get(1), nr);

      lesson = new DifferentSubgroupsLesson(lesson1, lesson2);
    }
    
    return lesson;
  }

  @Override
  public void setMediator(ScheduleMediator m) {
    this.mediator = m;
  }

  @Override
  public String getName() {
    return "DifferentSubgroups";
  }   
}
