package enums;

public enum Zi {
  nothing(0), luni(1), marti(2), miercuri(3), joi(4), vineri(5);

  private int n;
  private Zi(int n) { this.n = n; }

  public static Zi convertNumberToZi(int n) {
    return switch (n) {
      case 1 -> Zi.luni;
      case 2 -> Zi.marti;
      case 3 -> Zi.miercuri;
      case 4 -> Zi.joi;
      case 5 -> Zi.vineri;
      default -> null;
    };
  }

  public int getNumber() {
    return n;
  }
}
