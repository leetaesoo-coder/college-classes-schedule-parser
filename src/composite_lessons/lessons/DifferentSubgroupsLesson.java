package composite_lessons.lessons;

import java.util.ArrayList;

import db.Row;
import enums.*;

public class DifferentSubgroupsLesson implements Lesson {
  private Lesson firstSubgroupLesson;
  private Lesson secondSubgroupLesson;

  public DifferentSubgroupsLesson(Lesson firstSubgroupLesson, Lesson secondSubgroupLesson) {
    this.firstSubgroupLesson = firstSubgroupLesson;
    this.secondSubgroupLesson = secondSubgroupLesson;
  }

  public DifferentSubgroupsLesson(Lesson lesson, Subgrupa subgrupa) {
    if (subgrupa == Subgrupa.unu) 
      this.firstSubgroupLesson = lesson;
    else if (subgrupa == Subgrupa.doi) 
      this.secondSubgroupLesson = lesson;
  }

  @Override
  public String toString() {
    return "DifferentSubgroupsLesson{" +
            "firstSubgroupLesson=" + firstSubgroupLesson +
            ", secondSubgroupLesson=" + secondSubgroupLesson +
            '}';
  }

  @Override
  public ArrayList<Row> toRows() {
    ArrayList<Row> rows = new ArrayList<>();
    rows.addAll(firstSubgroupLesson.toRows());
    rows.addAll(secondSubgroupLesson.toRows());
    return rows;
  }

  @Override
  public void setSubgrupa(Subgrupa subgrupa) {}

  @Override
  public void setSaptamana(Saptamana saptamana) {
    firstSubgroupLesson.setSaptamana(saptamana);
    secondSubgroupLesson.setSaptamana(saptamana);
  }

  @Override
  public void setZi(Zi ziua) {
    firstSubgroupLesson.setZi(ziua);
    secondSubgroupLesson.setZi(ziua);
  }

  @Override
  public void setOra(String orele) {
    firstSubgroupLesson.setOra(orele);
    secondSubgroupLesson.setOra(orele);
  }

  @Override
  public Zi getZi() {
    return firstSubgroupLesson.getZi();
  }
}
