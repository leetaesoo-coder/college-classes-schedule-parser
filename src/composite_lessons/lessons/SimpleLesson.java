package composite_lessons.lessons;

import java.util.ArrayList;

import db.Row;
import enums.*;

public class SimpleLesson implements Lesson {
  private int nr;
  private String cabinet;
  private String name;
  private String profesor;
  private String orele;
  private Subgrupa subgrupa;
  private Saptamana saptamana;
  private Zi ziua;

  public SimpleLesson() {}

  public SimpleLesson(int nr, String cabinet, String name, String profesor, String orele, Subgrupa subgrupa, Saptamana saptamana, Zi ziua) {
    this.nr = nr;
    this.cabinet = cabinet;
    this.name = name;
    this.profesor = profesor;
    this.orele = orele;
    this.subgrupa = subgrupa;
    this.saptamana = saptamana;
    this.ziua = ziua;
  }

  @Override
  public String toString() {
    return "SimpleLesson{" +
            "nr=" + nr +
            ", cabinet=" + cabinet +
            ", name='" + name + '\'' +
            ", profesor='" + profesor + '\'' +
            ", orele='" + orele + '\'' +
            ", subgrupa=" + subgrupa +
            ", saptamana=" + saptamana +
            ", ziua=" + ziua +
            '}';
  }

  @Override
  public ArrayList<Row> toRows() {
    ArrayList<Row> rows = new ArrayList<>();
    rows.add(new Row(nr, name, subgrupa, saptamana, orele, ziua, cabinet, profesor));
    return rows;
  }

  public void setSubgrupa(Subgrupa subgrupa) {
    this.subgrupa = subgrupa;
  }

  public void setSaptamana(Saptamana saptamana) {
    this.saptamana = saptamana;
  }

  public void setZi(Zi ziua) {
    this.ziua = ziua;
  }

  @Override
  public void setOra(String orele) {
    this.orele = orele;
  }

  @Override
  public Zi getZi() {
    return ziua;
  }

  public String getCabinet() {
    return cabinet;
  }

  public String getProfesor() {
    return profesor;
  }

  public String getNume() {
    return name;
  }

}
