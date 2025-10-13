public class Polttomoottoriauto extends Auto {
    private int moottoritilavuus;
    private double kulutus;

    public Polttomoottoriauto() {
        super();
        this.moottoritilavuus = 0;
        this.kulutus = 0;
    }

    public Polttomoottoriauto(String nimi, int maksiminopeus, int paino, int henkilolkm,
                              String vaihteisto, int moottoritilavuus, double kulutus) {
        super(nimi, maksiminopeus, paino, henkilolkm, vaihteisto);
        setMoottoritilavuus(moottoritilavuus);
        setPolttoaineenKulutus(kulutus);
    }

    public int getMoottoritilavuus() { return moottoritilavuus; }
    public void setMoottoritilavuus(int moottoritilavuus) {
        this.moottoritilavuus = Math.max(0, moottoritilavuus);
    }

    public double getPolttoaineenKulutus() { return kulutus; }
    public void setPolttoaineenKulutus(double kulutus) {
        this.kulutus = kulutus < 0 ? 0 : kulutus;
    }

    @Override
    public String toString() {
        return String.format("%s, %d, %.2f", super.toString(), moottoritilavuus, kulutus);
    }
}
