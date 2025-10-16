public abstract class Henkilo {
    private String nimi;
    private int ika;

    public Henkilo() {
        this.nimi = "Tuntematon";
        this.ika = 0;
    };

    public Henkilo(String nimi, int ika) {
        setNimi(nimi);
        setIka(ika);
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        if (nimi == null || nimi.trim().isEmpty()) {
            throw new IllegalArgumentException("Nimi ei saa olla tyhjä.");
        }
        this.nimi = nimi;
    }
   
    public int getIka() {
        return ika;
    }

    public void setIka(int ika) {
        if (ika < 0) {
            throw new IllegalArgumentException("Ikä ei saa olla negatiivinen.");
        }
        this.ika = ika;
    }

    @Override
    public String toString() {
        return nimi + ", " + ika;
    }

}
