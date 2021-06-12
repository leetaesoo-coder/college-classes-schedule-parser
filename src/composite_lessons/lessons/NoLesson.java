package composite_lessons.lessons;

import java.util.ArrayList;

import db.Row;
import enums.*;

public class NoLesson implements Lesson {
    @Override
    public String toString() {
        return "NoLesson{}";
    }

    @Override
    public ArrayList<Row> toRows() {
      return new ArrayList<Row>();
    }

    @Override
    public void setSubgrupa(Subgrupa subgrupa) {}

    @Override
    public void setSaptamana(Saptamana saptamana) {}

    @Override
    public void setZi(Zi ziua) {}

    @Override
    public void setOra(String orele) {}

    @Override
    public Zi getZi() {
      return Zi.nothing;
    }
}
