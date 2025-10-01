public class Kayttaja {
    private String nimi;
    private Osoite osoite;

    public Kayttaja() {
        this.nimi = null;
        this.osoite = null;
    }

    public Kayttaja(String nimi, Osoite osoite) {
        this.nimi = nimi;
        this.osoite = osoite;
    }

    public String getNimi() { return nimi; }
    public void setNimi(String nimi) { this.nimi = nimi; }

    public Osoite getOsoite() { return osoite; }
    public void setOsoite(Osoite osoite) { this.osoite = osoite; }

    @Override
    public String toString() {
        return nimi + ", " + (osoite != null ? osoite.toString() : "null");
    }
}