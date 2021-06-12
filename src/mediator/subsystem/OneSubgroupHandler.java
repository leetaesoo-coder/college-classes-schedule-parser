package mediator.subsystem;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import composite_lessons.lessons.Lesson;
import composite_lessons.lessons.SimpleLesson;
import enums.Subgrupa;

public class OneSubgroupHandler implements Handler {
  private ScheduleMediator mediator;

  @Override
  public Lesson handle(WebElement element, int nr) {
    Lesson lesson = new SimpleLesson();

    // arraylist with all the left tags in the cell, and the single left tags are those who specify the subgroup
    ArrayList<WebElement> pullLefts = (ArrayList<WebElement>) element.findElements(By.className("pull-left"));

    // if there is only one pullLeft it means that the lesson is only for one subgroup
    boolean isSingleSubgroup = (pullLefts.size() == 1);

    // finding out what subgroup
    int subgroupNumber = 0;
    if (isSingleSubgroup) {
      WebElement pullLeft = pullLefts.get(0);
      String pullLeftText = pullLeft.getText();

      if(pullLeftText.contains("1")) subgroupNumber = 1;
      else subgroupNumber = 2;
    

      Subgrupa subgrupa = subgroupNumber == 1 ? Subgrupa.unu : Subgrupa.doi;
      
      lesson = mediator.checkForSimpleLesson(element, nr);
      lesson.setSubgrupa(subgrupa);
    }

    return lesson;
  }

  @Override
  public void setMediator(ScheduleMediator m) {
    this.mediator = m;
  }

  @Override
  public String getName() {
    return "OneSubgroup";
  }
}
