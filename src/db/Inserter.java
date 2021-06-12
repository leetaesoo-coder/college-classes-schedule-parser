package db;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.sql.*;

public class Inserter {
  private ArrayList<Row> rows = new ArrayList<>();
  private DAO dao;

  public Inserter() throws SQLException, IOException {
    dao = DAO.getInstance();
  }

  public void addRow(Row row) {
    rows.add(row);
  }

  public void addRows(List<Row> rows) {
    this.rows.addAll(rows);
  }

  public void showRows() {
    rows.forEach(System.out::println);
  }

  public void resetRows() {
    rows = new ArrayList<>();
  }

  public String toSQL() {
    StringBuilder sqlFormatedValues = new StringBuilder("insert into lessons values ");

    for (int i = 0; i < rows.size(); i++) {
      sqlFormatedValues.append(rows.get(i).toSQL());
      if (i != rows.size() - 1) sqlFormatedValues.append(',');
    }

    return sqlFormatedValues.toString();
  }

  public void insert() throws SQLException {
    Statement st = dao.getConnection().createStatement();
    
    st.executeUpdate(this.toSQL());
  }

}