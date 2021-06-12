package mediator.subsystem;

import org.openqa.selenium.WebElement;

import composite_lessons.lessons.Lesson;

public interface Mediator {

  public void registerHandler(Handler handler);

  public Lesson checkFor2Subgroups(WebElement element, int nr);
  public Lesson checkFor1Subgroup(WebElement element, int nr);
  public Lesson checkForSimpleLesson(WebElement element, int nr);

}