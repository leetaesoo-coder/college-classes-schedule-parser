package composite_lessons.lessons;

import composite_lessons.Rowable;
import enums.*;

public interface Lesson extends Rowable {

  void setSubgrupa(Subgrupa subgrupa);

  void setSaptamana(Saptamana saptamana);

  void setZi(Zi ziua);
  
  void setOra(String orele);
  
  Zi getZi();
  
}