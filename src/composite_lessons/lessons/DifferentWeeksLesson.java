package composite_lessons.lessons;

import java.util.ArrayList;

import db.Row;
import enums.*;

public class DifferentWeeksLesson implements Lesson {
  private Lesson oddWeekLesson;
  private Lesson evenWeekLesson;

  public DifferentWeeksLesson(Lesson oddWeekLesson, Lesson evenWeekLesson) {
    this.evenWeekLesson = evenWeekLesson;
    this.oddWeekLesson = oddWeekLesson;
  }

  @Override
  public String toString() {
    return "DifferentWeeksLesson{" +
            "evenWeekLesson=" + evenWeekLesson +
            ", oddWeekLesson=" + oddWeekLesson +
            '}';
  }

  @Override
  public ArrayList<Row> toRows() {
    ArrayList<Row> rows = new ArrayList<>();
    rows.addAll(evenWeekLesson.toRows());
    rows.addAll(oddWeekLesson.toRows());
    return rows;
  }

  @Override
  public void setSubgrupa(Subgrupa subgrupa) {
    evenWeekLesson.setSubgrupa(subgrupa);
    oddWeekLesson.setSubgrupa(subgrupa);
  }

  @Override
  public void setSaptamana(Saptamana saptamana) {}

  @Override
  public void setZi(Zi ziua) {
    evenWeekLesson.setZi(ziua);
    oddWeekLesson.setZi(ziua);
  }

  @Override
  public void setOra(String orele) {
    evenWeekLesson.setOra(orele);
    oddWeekLesson.setOra(orele);
  }

  @Override
  public Zi getZi() {
    return evenWeekLesson.getZi();
  }
}
