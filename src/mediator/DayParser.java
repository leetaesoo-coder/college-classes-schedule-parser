package mediator;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

import composite_lessons.Day;
import composite_lessons.lessons.Lesson;
import enums.Zi;

public class DayParser {

  public static ArrayList<Day> toDays(List<WebElement> trs) { 
    ArrayList<Day> days = new ArrayList<>();

    ArrayList<Lesson> lessons = LessonsParser.convertTrsToLessons(trs);

    for (int i = 1; i <= 5; i++) days.add(new Day(Zi.convertNumberToZi(i), new ArrayList<>()));

    lessons.forEach(lesson -> {
      int numarulZilei = lesson.getZi().getNumber();
      
      if(numarulZilei > 0 & numarulZilei <= 5)
        days.get(numarulZilei - 1).addLesson(lesson);
    });

    return days;
  }

}
