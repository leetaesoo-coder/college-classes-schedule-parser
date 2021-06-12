package mediator;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import composite_lessons.lessons.Lesson;
import composite_lessons.lessons.NoLesson;
import composite_lessons.lessons.SimpleLesson;
import enums.Zi;

public class LessonsParser {
  
  // from arraylist of trs to arraylist of lessons - this is better than convertTdsToLessons
  public static ArrayList<Lesson> convertTrsToLessons(List<WebElement> trs) {
    ArrayList<Lesson> lessons = new ArrayList<>();
    
    LessonsMediator parser = LessonsMediator.getInstance();

    parser.setHours(trs);

    // loop through days
    for (int i = 1; i < trs.size(); i++) {
      Zi ziua = Zi.convertNumberToZi(i);

      // loop through lessons
      List<WebElement> tds = trs.get(i).findElements(By.tagName("td"));
      for (int j = 1; j < tds.size(); j++) {
        lessons.add(parser.toLesson(tds.get(j), j, ziua));
      }
    }

    return filter(lessons);
  }

  private static ArrayList<Lesson> filter(ArrayList<Lesson> lessons) {
    for (int i = 0; i < lessons.size(); i++) {
      if (lessons.get(i) instanceof SimpleLesson) {
        SimpleLesson simpleLesson = (SimpleLesson) lessons.get(i);
        if (simpleLesson.getCabinet().equals("") & simpleLesson.getProfesor().equals("") 
        & simpleLesson.getNume().equals("")) {
          lessons.set(i, new NoLesson());
        }
      } 
    }

    return lessons;
  }

}
