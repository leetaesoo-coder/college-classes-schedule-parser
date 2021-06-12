package mediator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

// parser that parses the start and end hours of the lessons
class HourParser {

  HashMap<Integer, String> parseHours(List<WebElement> trs) {
    HashMap<Integer, String> hours = new HashMap<>();

    // get the row with the hours
    WebElement row = trs.get(0);

    List<WebElement> cells = row.findElements(By.tagName("td"));
    for (int i = 1; i < cells.size(); i++) {
      Stream<String> linesStream = cells.get(i).getText().lines();
      ArrayList<String> lines = linesStream.collect(Collectors.toCollection(ArrayList::new));

      hours.put(i, lines.get(1));
    }

    return hours;
  }

}
