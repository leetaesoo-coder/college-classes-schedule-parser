package enums;

public enum Subgrupa {
  unu, doi, unuPlusDoi;

  @Override
  public String toString() {
    return switch (this) {
      case unu -> "1";
      case doi -> "2";
      case unuPlusDoi -> "1+2";
    };
  }
}