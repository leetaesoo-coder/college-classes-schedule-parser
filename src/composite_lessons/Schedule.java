package composite_lessons;

import java.util.ArrayList;
import java.util.HashMap;

import db.Row;
import enums.Zi;

public class Schedule implements Rowable {
  private HashMap<Zi, Day> days;

  public Schedule(HashMap<Zi, Day> days) {
    this.days = new HashMap<Zi, Day>(days);
  }

  public HashMap<Zi, Day> getDays() {
    return days;
  }

  @Override
  public String toString() {
    return "Schedule{" +
            "days=" + days +
            '}';
  }

  @Override
  public ArrayList<Row> toRows() {
    ArrayList<Row> rows = new ArrayList<>();
    days.forEach((zi, day) -> rows.addAll(day.toRows()));
    return rows;
  }
}
