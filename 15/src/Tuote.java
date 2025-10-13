public class Tuote {
    private String tuotenumero;
    private int maara;
    private int tuotepaikka;

    //Oletus
    public Tuote() {
        this.tuotenumero = "?";
        this.maara = 0;
        this.tuotepaikka = 0;
    }

    public Tuote(final String tuotenumero) {
        this.tuotenumero = tuotenumero;
        this.maara = 0;
        this.tuotepaikka = 0;
    }

    public Tuote(final String tuotenumero, final int maara, final int tuotepaikka) {
        this.tuotenumero = tuotenumero;
        this.maara = maara;
        this.tuotepaikka = tuotepaikka;
    }

    public String getTuotenumero() {
        return tuotenumero;
    }

    public void setTuotenumero(String tuotenumero) {
        if (tuotenumero == null || tuotenumero.trim().isEmpty()) {
            this.tuotenumero = "?";
        } else {
            this.tuotenumero = tuotenumero.trim();
        }
    } 

    public int getMaara() {
        return maara;
    }

    public void setMaara(int maara) {
        this.maara = Math.max(maara, 0);
    }

    public int getTuotepaikka() {
        return tuotepaikka;
    }

    public void setTuotepaikka(int tuotepaikka) {
        this.tuotepaikka = Math.max(tuotepaikka, 0);
    }

    @Override
    public String toString() {
        return tuotenumero + "," + maara + "," + tuotepaikka;
    }
}
