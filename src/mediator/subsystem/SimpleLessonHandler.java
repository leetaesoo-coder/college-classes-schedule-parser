package mediator.subsystem;

import org.openqa.selenium.WebElement;

import composite_lessons.lessons.Lesson;
import converters.WebElementConverter;
import enums.Saptamana;
import enums.Subgrupa;

public class SimpleLessonHandler implements Handler {
  private ScheduleMediator mediator;

  @Override
  public Lesson handle(WebElement element, int nr) {
    return WebElementConverter.convertTdToLesson(element, nr, Subgrupa.unuPlusDoi, Saptamana.pohui, null);
  }

  @Override
  public void setMediator(ScheduleMediator m) {
    this.mediator = m;
  }

  @Override
  public String getName() {
    return "SimpleLesson";
  }
  
}
