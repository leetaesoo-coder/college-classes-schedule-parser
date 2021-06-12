package composite_lessons;

import java.util.ArrayList;

import db.Row;
import enums.Zi;

public class Day implements Rowable {
  private Zi dayName;
  private ArrayList<Rowable> lessons;

  public Day(Zi dayName, ArrayList<Rowable> lessons) {
    this.dayName = dayName;
    this.lessons = new ArrayList<Rowable>(lessons);
  }

  public void addLesson(Rowable lesson) {
    if (lessons.size() < 5) 
      lessons.add(lesson);
  }

  @Override
  public String toString() {
    return "Day{" +
            "dayName=" + dayName +
            ", lessons=" + lessons +
            '}';
  }

  @Override
  public ArrayList<Row> toRows() {
    ArrayList<Row> rows = new ArrayList<>();
    lessons.forEach(lesson -> rows.addAll(lesson.toRows()));
    return rows;
  }

  public Zi getZi() {
    return dayName;
  }
}