public class Auto extends Ajoneuvo {
    private int henkilolkm;
    private String vaihteisto;

    public Auto() {
        super();
        this.henkilolkm = 0;
        this.vaihteisto = "Tuntematon";
    }

    public Auto(String nimi, int maksiminopeus, int paino, int henkilolkm, String vaihteisto) {
        super(nimi, maksiminopeus, paino);
        setHenkilolkm(henkilolkm);
        setVaihteisto(vaihteisto);
    }

    public int getHenkilolkm() { return henkilolkm; }
    public void setHenkilolkm(int henkilolkm) {
        this.henkilolkm = Math.max(0, henkilolkm);
    }

    public String getVaihteisto() { return vaihteisto; }
    public void setVaihteisto(String vaihteisto) {
        if (vaihteisto == null) {
            this.vaihteisto = "Tuntematon";
        } else {
            String lower = vaihteisto.trim().toLowerCase();
            if (lower.equals("automaatti") || lower.equals("manuaali")) {
                this.vaihteisto = capitalize(lower);
            } else {
                this.vaihteisto = "Tuntematon";
            }
        }
    }

    private String capitalize(String s) {
        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }

    @Override
    public String toString() {
        return super.toString() + ", " + henkilolkm + ", " + vaihteisto;
    }
}
