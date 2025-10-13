public class Vene extends Ajoneuvo {
    private int kantavuus;
    private int syvays;

    public Vene() {
        super();
        this.kantavuus = 0;
        this.syvays = 0;
    }

    public Vene(String nimi, int maksiminopeus, int paino, int kantavuus, int syvays) {
        super(nimi, maksiminopeus, paino);
        setKantavuus(kantavuus);
        setSyvays(syvays);
    }

    public int getKantavuus() { return kantavuus; }
    public void setKantavuus(int kantavuus) {
        this.kantavuus = Math.max(0, kantavuus);
    }

    public int getSyvays() { return syvays; }
    public void setSyvays(int syvays) {
        this.syvays = Math.max(0, syvays);
    }

    @Override
    public String toString() {
        return super.toString() + ", " + kantavuus + ", " + syvays;
    }
}
