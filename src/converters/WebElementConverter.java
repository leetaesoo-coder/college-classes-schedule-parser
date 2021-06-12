package converters;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;

import composite_lessons.lessons.*;
import enums.*;

public class WebElementConverter {

  // from td(WebElement, part of the HTML table) to Lesson
  public static Lesson convertTdToLesson(WebElement td, int nr, Subgrupa subgrupa, Saptamana saptamana, Zi ziua) {
    Stream<String> linesStream = td.getText().lines();
    ArrayList<String> lines = linesStream.collect(Collectors.toCollection(ArrayList::new));

    String name = "";
    String cabinet = "";
    String profesor = "";

    try{
      // it means that the first row indicates the subgroup and OneSubgroupHandler handles that
      if (lines.get(0).toLowerCase().contains("grupa")) lines.remove(0);

      cabinet = lines.get(0);
      name = lines.get(1);
      profesor = lines.get(2);

      if (profesor.contains("Tudorean")) 
        profesor = "Scorpia";

    }
    catch(Exception e) {}

    return new SimpleLesson(nr, cabinet, name, profesor, "8:00-9:30", subgrupa, saptamana, ziua); 
  }

}
