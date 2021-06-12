package composite_lessons;

import java.util.ArrayList;

import db.Row;

// object that gives you the opportunity to convert it into Row objects

public interface Rowable {
  public ArrayList<Row> toRows();
}