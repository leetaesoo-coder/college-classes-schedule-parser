package db;

import enums.*;

public class Row {
  private int nr;
  private String numeLectie;
  private Subgrupa subgrupa; 
  private Saptamana saptamana;
  private String orele;
  private Zi ziua;
  private String cabinet;
  private String profesor;


  public Row(int nr, String numeLectie, Subgrupa subgrupa, Saptamana saptamana, String orele, Zi ziua, String cabinet, String profesor) {
    this.nr = nr;
    this.numeLectie = numeLectie;
    this.subgrupa = subgrupa;
    this.saptamana = saptamana;
    this.orele = orele;
    this.ziua = ziua;
    this.cabinet = cabinet;
    this.profesor = profesor;
  }


  public void setCabinet(String cabinet) {
    this.cabinet = cabinet;
  }

  public void setProfesor(String profesor) {
    this.profesor = profesor;
  }

  public String toSQL() {
    return String.format("(%d, '%s', '%s', '%s', '%s', '%s', %s, %s)", 
      nr, numeLectie, subgrupa, saptamana, orele, ziua, 
      cabinet != null ? "'" + cabinet + "'" : "null", 
      profesor != null ? "'" + profesor + "'" : "null");
  }

  @Override
  public String toString() {
    return "Row{" +
            "nr=" + nr +
            ", numeLectie='" + numeLectie + '\'' +
            ", subgrupa=" + subgrupa +
            ", saptamana=" + saptamana +
            ", orele='" + orele + '\'' +
            ", ziua=" + ziua +
            ", cabinet=" + cabinet +
            ", profesor='" + profesor + '\'' +
            '}';
  }
}
