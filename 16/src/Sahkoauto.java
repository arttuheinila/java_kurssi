public class Sahkoauto extends Auto {
    private double akkukapasiteetti;
    private int range;

    public Sahkoauto() {
        super();
        this.akkukapasiteetti = 0;
        this.range = 0;
    }

    public Sahkoauto(String nimi, int maksiminopeus, int paino, int henkilolkm,
                     String vaihteisto, double akkukapasiteetti, int range) {
        super(nimi, maksiminopeus, paino, henkilolkm, vaihteisto);
        setAkkukapasiteetti(akkukapasiteetti);
        setRange(range);
    }

    public double getAkkukapasiteetti() { return akkukapasiteetti; }
    public void setAkkukapasiteetti(double akkukapasiteetti) {
        this.akkukapasiteetti = akkukapasiteetti < 0 ? 0 : akkukapasiteetti;
    }

    public int getRange() { return range; }
    public void setRange(int range) {
        this.range = Math.max(0, range);
    }

    @Override
    public String toString() {
        return String.format("%s, %.2f, %d", super.toString(), akkukapasiteetti, range);
    }
}
