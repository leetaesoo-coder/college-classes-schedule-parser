package mediator.subsystem;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import composite_lessons.lessons.DifferentWeeksLesson;
import composite_lessons.lessons.Lesson;
import composite_lessons.lessons.NoLesson;

import java.util.ArrayList;
import enums.*;

public class DifferentWeeksHandler implements Handler{
  private ScheduleMediator mediator;

  // todo: you can refactor here because the code repeats for halfsCount == 1 and halfsCount == 2
  public Lesson handle(WebElement element, int nr) {
    Lesson lesson;

    ArrayList<WebElement> halfs = (ArrayList<WebElement>) element.findElements(By.className("cell-half"));
    int halfsCount = halfs.size();

    // check if for both of the weeks there is a lesson
    if (halfsCount == 2) {

      // find out which is top and which is bottom
      WebElement topHalf, bottomHalf;
      if (halfs.get(0).getAttribute("class").contains("top")) {
        topHalf = halfs.get(0);
        bottomHalf = halfs.get(1);
      } else {
        bottomHalf = halfs.get(0);
        topHalf = halfs.get(1);
      }

      Lesson topLesson = handleHalf(topHalf, nr);
      Lesson bottomLesson = handleHalf(bottomHalf, nr);
      
      topLesson.setSaptamana(Saptamana.impara);
      bottomLesson.setSaptamana(Saptamana.para);

      lesson = new DifferentWeeksLesson(topLesson, bottomLesson);
    } 

    // otherwise it means that one of the halfs has no lesson, it means NoLesson()
    else if (halfsCount == 1) {

      WebElement theOnlyHalf = halfs.get(0);
      
      // find out which is top and which is bottom
      WebElement topHalf, bottomHalf;
      if (theOnlyHalf.getAttribute("class").contains("top")){
        topHalf = theOnlyHalf;
        bottomHalf = null;
      } else {
        bottomHalf = theOnlyHalf;
        topHalf = null;
      }

      // the odd week lesson
      Lesson topLesson;
      if (topHalf == null) topLesson = new NoLesson();
      else topLesson = handleHalf(topHalf, nr);

      if (topHalf != null) topLesson.setSaptamana(Saptamana.impara);

      // the even week lesson
      Lesson bottomLesson;
      if (bottomHalf == null) bottomLesson = new NoLesson();
      else bottomLesson = handleHalf(bottomHalf, nr);

      if (bottomHalf != null) bottomLesson.setSaptamana(Saptamana.para);

      lesson = new DifferentWeeksLesson(topLesson, bottomLesson);
    }

    else if (mediator.countPullLefts(element) == 2) lesson = mediator.checkFor2Subgroups(element, nr);
    else if (mediator.countPullLefts(element) == 1) lesson = mediator.checkFor1Subgroup(element, nr);
    else lesson = mediator.checkForSimpleLesson(element, nr);

    return lesson;
  }

  private Lesson handleHalf(WebElement element, int nr) {
    if (mediator.countPullLefts(element) == 2) return mediator.checkFor2Subgroups(element, nr);
    else if (mediator.countPullLefts(element) == 1) return mediator.checkFor1Subgroup(element, nr);
    else return mediator.checkForSimpleLesson(element, nr);
  }

  @Override
  public void setMediator(ScheduleMediator m) {
    this.mediator = m;
  }

  @Override
  public String getName() {
    return "DifferentWeeks";
  }
}
