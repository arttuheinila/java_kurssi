public class Tietokone {    
    private String merkki;
    private String malli;
    private String sarjanumero;
    
    public Tietokone() {
        this.merkki = null;
        this.malli = null;
        this.sarjanumero = null;
    }
    
    public Tietokone(String merkki, String malli, String sarjanumero) {
        this.merkki = merkki;
        this.malli = malli;
        this.sarjanumero = sarjanumero;
    }
    
    public String getMerkki() { return merkki; }
    public void setMerkki(String merkki) { this.merkki = merkki; }
    
    public String getMalli() { return malli; }
    public void setMalli(String malli) { this.malli = malli; }
    
    public String getSarjanumero() { return sarjanumero; }
    public void setSarjanumero(String sarjanumero) { this.sarjanumero = sarjanumero; }
    
    @Override
    public String toString() {
        return merkki + "," + malli + "," + sarjanumero;
    }
}
