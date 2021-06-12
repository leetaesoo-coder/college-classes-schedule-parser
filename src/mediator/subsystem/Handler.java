package mediator.subsystem;

import org.openqa.selenium.WebElement;

import composite_lessons.lessons.Lesson;

public interface Handler {
  public Lesson handle(WebElement element, int nr);
  public void setMediator(ScheduleMediator m);
  public String getName();
}