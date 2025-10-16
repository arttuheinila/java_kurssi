public class Projektipaallikko extends Henkilo {
    private int kokemusVuodet;    

    public Projektipaallikko(String nimi, int ika, int kokemusVuodet) {
        super(nimi, ika);
        setKokemusVuodet(kokemusVuodet);
    }

    public int getKokemusVuodet() {
        return kokemusVuodet;
    }

    public void setKokemusVuodet(int kokemusVuodet) {
        if (kokemusVuodet < 0) {
            throw new IllegalArgumentException("Kokemusvuodet ei saa olla negatiivinen.");
        }
        this.kokemusVuodet = kokemusVuodet;
    }

    @Override
    public String toString() {
        return getNimi() + ", " + getIka() + ", " + kokemusVuodet;
    }
}
