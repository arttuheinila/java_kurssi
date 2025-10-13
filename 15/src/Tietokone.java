public class Tietokone extends Tuote {
    private String merkki;
    private String malli;
    
    // Oletuskonstruktori
    public Tietokone() {
        super();
        this.merkki = "?";
        this.malli = "?";
    }

    // Konstruktori merkki ja malli
    public Tietokone(final String merkki, final String malli) {
        super();
        setMerkki(merkki);
        setMalli(malli);
    }

    public Tietokone(final String merkki, final String malli, final String tuotenumero) {
        super(tuotenumero);
        setMerkki(merkki);
        setMalli(malli);
    }

    // Konstruktori merkki, malli ja tuotenumero
    public Tietokone(final String merkki, final String malli, final String tuotenumero, final int maara, final int tuotepaikka) {
        super(tuotenumero, maara, tuotepaikka);
        setMerkki(merkki);
        setMalli(malli);
    }

    public String getMerkki() {
        return merkki;
    }        

    public void setMerkki(String merkki) {
        if (merkki == null || merkki.trim().isEmpty()) {
            this.merkki = "?";
        } else {
            this.merkki = merkki.trim();
        }
    }

    public String getMalli() {
        return malli;
    }

    public void setMalli(String malli) {
        if (malli == null || malli.trim().isEmpty()) {
            this.malli = "?";
        } else {
            this.malli = malli.trim();
        }
    }
    @Override
    public String toString() {
        return merkki + "," + malli + "," + super.toString();
    }

}
